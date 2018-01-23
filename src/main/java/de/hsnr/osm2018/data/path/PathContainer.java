package de.hsnr.osm2018.data.path;

import de.hsnr.osm2018.data.graph.Node;

public class PathContainer {

    private Node node;
    private double distance;

    public PathContainer(Node node, double distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public double getDistance() {
        return distance;
    }
}
