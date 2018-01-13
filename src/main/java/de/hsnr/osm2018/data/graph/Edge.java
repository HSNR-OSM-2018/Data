package de.hsnr.osm2018.data.graph;

public class Edge {

    private Node mStartNode;
    private Long mDestinationNodeId;
    private Integer mLength;
    private Short mSpeed;
    private EdgeType mType;

    public Edge(Node startNode, Long destinationNodeId, Integer length, Short speed, EdgeType type) {
        this.mStartNode = startNode;
        this.mDestinationNodeId = destinationNodeId;
        this.mLength = length;
        this.mSpeed = speed;
        this.mType = type;
    }

    public Node getStartNode() {
        return mStartNode;
    }

    public Long getDestinationNodeId() {
        return mDestinationNodeId;
    }

    public Node getDestinationNode(Graph graph) {
        return graph.getNode(mDestinationNodeId);
    }

    /* length in meters */
    public int getLength() {
        return mLength != null ? mLength : -1;
    }

    /* speed in kilometers per hour */
    public short getSpeed() {
        return mSpeed != null ? mSpeed : -1;
    }

    public EdgeType getType() {
        return mType;
    }

    @Override
    public String toString() {
        return "Edge:\n{\n\tStartNode: " + this.getStartNode() + ",\n\tEndNode: " + this.getDestinationNodeId() + ",\n\tWith MaxSpeed: " + this.getSpeed() + ",\n\tWithLength: " + this.getLength() + ",\n\tWith EdgeType: " + this.getType();
    }
}