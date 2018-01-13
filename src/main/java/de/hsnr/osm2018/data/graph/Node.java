package de.hsnr.osm2018.data.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Long mId;
    private Double mLatitude;
    private Double mLongitude;
    private List<Edge> mEdges;
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
        this.mEdges = edges;
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

    public List<Edge> getEdges() {
        return mEdges;
    }

    public void addEdge(Edge e) {
        this.mEdges.add(e);
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

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}