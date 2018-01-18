package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Node {

    private long mId;
    private double mLatitude;
    private double mLongitude;
    private ArrayList<Edge> mEdges;

    public Node(long id, double latitude, double longitude) {
        this.mId = id;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mEdges = new ArrayList<>();
    }

    public long getId() {
        return mId;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public ArrayList<Edge> getEdges() {
        return mEdges;
    }

    public void addEdge(Edge edge) {
        mEdges.add(edge);
    }

    public void addEdge(Node destination, int length, short speed, EdgeType type) {
        addEdge(new Edge(this, destination, length, speed, type));
    }

    public double getDistance(double latitude, double longitude) {
        return Math.sqrt(Math.pow(getLatitude() - latitude, 2) + Math.pow(getLongitude() - longitude, 2));
    }

    public double getDistance(Node node) {
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

    public void addEdge(Edge edge) {
        this.mEdges.add(edge);
    }

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}