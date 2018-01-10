package de.hsnr.osm2018.data.graph;

import java.util.List;

public class Graph {

    private List<Node> mNodes;
    private List<Edge> mEdges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.mNodes = nodes;
        this.mEdges = edges;
    }

    public List<Node> getNodes() {
        return mNodes;
    }

    public List<Edge> getEdges() {
        return mEdges;
    }
}