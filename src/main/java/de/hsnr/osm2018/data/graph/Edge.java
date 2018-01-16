package de.hsnr.osm2018.data.graph;

public class Edge {

    private Node mStartNode;
    private Node mDestinationNode;
    private int mLength;
    private short mSpeed;
    private EdgeType mType;

    public Edge(Node startNode, Node destinationNode, int length, short speed, EdgeType type) {
        this.mStartNode = startNode;
        this.mDestinationNode = destinationNode;
        this.mLength = length;
        this.mSpeed = speed;
        this.mType = type;
    }

    public Node getStartNode() {
        return mStartNode;
    }

    public Node getDestinationNode() {
        return mDestinationNode;
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

    @Override
    public String toString() {
        return "Edge:\n{\n\tStartNode: " + this.getStartNode() + ",\n\tEndNode: " + this.getDestinationNode() + ",\n\tWith MaxSpeed: " + this.getSpeed() + ",\n\tWithLength: " + this.getLength() + ",\n\tWith EdgeType: " + this.getType();
    }
}