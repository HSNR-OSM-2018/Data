package de.hsnr.osm2018.data.graph;

import java.util.List;

public class Node {

    private long mId;
    private double mLatitude;
    private double mLongitude;
    private List<Edge> mEdges;

    public Node(long id, double latitude, double longitude, List<Edge> edges) {
        this.mId = id;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mEdges = edges;
    }

    public long getId() {
        return mId;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitute() {
        return mLongitude;
    }

    public List<Edge> getEdges() {
        return mEdges;
    }

    public void addEdge(Edge edge) {
        this.mEdges.add(edge);
    }

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}