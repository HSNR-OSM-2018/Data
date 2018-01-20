package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements Serializable {

    private HashMap<Long, Node> mNodes;

    public Graph() {
        this.mNodes = new HashMap<>();
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
}