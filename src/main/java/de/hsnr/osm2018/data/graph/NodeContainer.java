package de.hsnr.osm2018.data.graph;

public class NodeContainer {

    private Node mNode;
    private double d = Double.POSITIVE_INFINITY; // Node weight
    private double f; // Node weight with heuristic
    private Node parent;

    public NodeContainer(Node node) {
        this.mNode = node;
    }

    public Node getNode() {
        return mNode;
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
}
