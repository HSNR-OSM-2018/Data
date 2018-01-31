package de.hsnr.osm2018.data.graph;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Node {
    private long mId;
    private double mLatitude;
    private double mLongitude;
    private ArrayList<Edge> mEdges;

    public Node(DataInputStream dis) throws IOException {
        this(dis.readLong(), dis.readDouble(), dis.readDouble());
    }

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


    public double getRealDistance(Node node) {
        double R = 6371000; // metres
        double phi1 = Math.toRadians(this.mLatitude);
        double phi2 = Math.toRadians(node.getLatitude());
        double phiDelta = Math.toRadians((node.getLatitude() - this.mLatitude));
        double lambda = Math.toRadians(node.getLongitude() - this.mLongitude);

        double a = Math.sin(phiDelta / 2) * Math.sin(phiDelta / 2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(lambda / 2) * Math.sin(lambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    /**
     * Calculate the distance between this node and another geo-coordinate identified by latitude and longitude
     *
     * @param latitude  other point latitude
     * @param longitude other point longitude
     * @return distance in meters
     */
    public double getDistance(double latitude, double longitude) {
        return getDistance(this.mLatitude, this.mLongitude, latitude, longitude);
    }

    public double getDistance(Node node) {
        return getDistance(this.mLatitude, this.mLongitude, node.getLatitude(), node.getLongitude());
    }

    public static double getDistance(double latitude, double longitude, double latitude2, double longitude2) {
        double distanceLatitude = (latitude - latitude2) * 111.3D;
        double distanceLongitude = (longitude - longitude2) * 71.5D;
        return Math.sqrt((distanceLatitude * distanceLatitude) + (distanceLongitude * distanceLongitude)) * 1000D;
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

    public void write(DataOutputStream dos) throws IOException {
        dos.writeLong(getId());
        dos.writeDouble(getLatitude());
        dos.writeDouble(getLongitude());
    }

    @Override
    public String toString() {
        return "NodeID: " + mId + "\n\tLat/Lng: " + mLatitude + "/" + mLongitude;
    }
}