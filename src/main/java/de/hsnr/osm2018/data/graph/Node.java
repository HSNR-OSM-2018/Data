package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Node {

    private Long mId;
    private Double mLatitude;
    private Double mLongitude;
    private HashMap<Long, Edge> mEdges;
    private double d = Double.POSITIVE_INFINITY; // Node weight
    private double f; // Node weight with heuristic
    private Node parent;

    public Node(Long id, Double latitude, Double longitude) {
        this(id, latitude, longitude, new ArrayList<>());
    }

    public Node(Long id, Double latitude, Double longitude, List<Edge> edges) {
        this.mId = id;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mEdges = new HashMap<>();
        for (Edge edge : edges) {
            addEdge(edge);
        }
    }

    public Long getId() {
        return mId;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public Collection<Edge> getEdges() {
        return mEdges.values();
    }

    public void addEdge(Edge edge) {
        if (mEdges.containsKey(edge.getDestinationNodeId())) {
            return; //TODO: throw an exception or handle it differently?
        }
        mEdges.put(edge.getDestinationNodeId(), edge);
    }

    public void addEdge(Long destinationNodeId, Integer length, Short speed, EdgeType type) {
        addEdge(new Edge(this, destinationNodeId, length, speed, type));
    }

    public Double getD() {
        return d;
    }

    public Double getF() {
        return f;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setF(double f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Double getDistance(Double latitude, Double longitude) {
        return Math.sqrt(Math.pow(getLatitude() - latitude, 2) + Math.pow(getLongitude() - longitude, 2));
    }

    public Double getDistance(Node node) {
        return getDistance(node.getLatitude(), node.getLongitude());
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject data = new JSONObject();
        data.put("id", getId());
        data.put("latitude", getLatitude());
        data.put("longitude", getLongitude());
        JSONArray edges = new JSONArray();
        for (Edge edge : getEdges()) {
            edges.put(edge.toJSON());
        }
        data.put("edges", edges);
        return data;
    }

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}