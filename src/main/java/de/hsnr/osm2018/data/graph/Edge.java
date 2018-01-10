package de.hsnr.osm2018.data.graph;

public class Edge {

    private Node mFrom;
    private Node mTo;
    private int mLength;
    private short mSpeed;
    private EdgeType mType;

    public Edge(Node from, Node to, int length, short speed, EdgeType type) {
        this.mFrom = from;
        this.mTo = to;
        this.mLength = length;
        this.mSpeed = speed;
        this.mType = type;
    }

    public Node getFrom() {
        return mFrom;
    }

    public Node getTo() {
        return mTo;
    }

    /* length in meters */
    public int getLength() {
        return mLength;
    }

    /* speed in kilometers per hour */
    public short getSpeed() {
        return mSpeed;
    }

    public EdgeType getType() {
        return mType;
    }
}