package de.hsnr.osm2018.data.graph;

import java.util.List;

public class Node {

    private long mId;
    private double mLatitude;
    private double mLongitude;
    private List<Edge> mEdges;
    private double d; // Node weight
    private double f; // Node weight with heuristik
    private Node parent;

    public Node(long id, double latitude, double longitude, List<Edge> edges) {
        this.mId = id;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mEdges = edges;
        this.d = Double.POSITIVE_INFINITY;
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

    public double getD() {
        return d;
    }

    public double getF() {
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

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}