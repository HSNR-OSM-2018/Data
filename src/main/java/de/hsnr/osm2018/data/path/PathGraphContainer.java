package de.hsnr.osm2018.data.path;

import de.hsnr.osm2018.data.graph.Graph;
import de.hsnr.osm2018.data.graph.Node;

public class PathGraphContainer {

    private Node start;
    private Node destination;
    private Graph graph;

    public PathGraphContainer(Node start, Node destination, Graph graph) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    public Node getStart() {
        return start;
    }

    public Node getDestination() {
        return destination;
    }

    public Graph getGraph() {
        return graph;
    }
}
