package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Graph {

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

    public Node getNode(Long id) {
        return mNodes.get(id);
    }

    public boolean contains(Node node) {
        return mNodes.containsKey(node.getId());
    }

    public void add(Node node) {
        mNodes.put(node.getId(), node);
    }

    public List<Edge> getEdges(Long nodeId) {
        return getNode(nodeId).getEdges();
    }

    public List<Edge> getEdges(Node node) {
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