package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<Long, Node> mNodes;

    public Graph() {
        this.mNodes = new HashMap<>();
    }

    public Graph(DataInputStream dis) throws IOException {
        this();
        while (dis.available() > 0) {
            char type = dis.readChar();
            switch (type) {
                case 'n':
                    add(new Node(dis));
                    break;
                case 'e':
                    Edge edge = new Edge(this, dis);
                    edge.getStartNode().addEdge(edge);
                    break;
            }
        }
    }

    public Graph(HashMap<Long, Node> nodes) {
        this.mNodes = nodes;
    }

    public HashMap<Long, Node> getNodes() {
        return mNodes;
    }

    public Node getNode(long id) {
        return mNodes.get(id);
    }

    public Node getNearest(double latitude, double longitude, boolean requireEdges) {
        Node res = null;
        double dist = Double.MAX_VALUE;
        for (Node node : getNodes().values()) {
            if (requireEdges && node.getEdges().isEmpty()) {
                continue;
            }
            double localDist = node.getDistance(latitude, longitude);
            if (localDist < dist) {
                res = node;
                dist = localDist;
            }
        }
        return res;
    }

    public Node getNearest(double latitude, double longitude) {
        return getNearest(latitude, longitude, true);
    }

    public boolean contains(Node node) {
        return mNodes.containsKey(node.getId());
    }

    public boolean contains(long id) {
        return mNodes.containsKey(id);
    }

    public void add(Node node) {
        if (mNodes.containsKey(node.getId())) {
            return; //TODO: throw an exception or handle it differently?
        }
        mNodes.put(node.getId(), node);
    }

    public ArrayList<Edge> getEdges(long nodeId) {
        return getNode(nodeId).getEdges();
    }

    public ArrayList<Edge> getEdges(Node node) {
        return getEdges(node.getId());
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray nodes = new JSONArray();
        long count = 0L;
        for (Node node : mNodes.values()) {
            nodes.put(node.toJSON());
            count++;
        }
        data.put("nodes", nodes);
        data.put("count", count);
        return data;
    }

    public void write(DataOutputStream dos) throws IOException {
        for (Node node : getNodes().values()) {
            dos.writeChar('n');
            node.write(dos);
        }
        for (Node node : getNodes().values()) {
            for (Edge edge : node.getEdges()) {
                dos.writeChar('e');
                edge.write(dos);
            }
        }
    }
}