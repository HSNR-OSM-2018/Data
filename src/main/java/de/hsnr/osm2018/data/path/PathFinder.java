package de.hsnr.osm2018.data.path;

import de.hsnr.osm2018.data.graph.Graph;
import de.hsnr.osm2018.data.graph.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class PathFinder {

    private Graph mGraph;
    private List<PathContainer> mPath;

    public PathFinder(Graph graph) {
        this.mGraph = graph;
        this.mPath = new ArrayList<>();
    }

    public Graph getGraph() {
        return mGraph;
    }

    public List<PathContainer> getPath() {
        return mPath;
    }

    protected void clearPath() {
        mPath = new ArrayList<>();
    }

    protected void addPathNode(Node node, double distance) {
        mPath.add(new PathContainer(node, distance));
    }

    protected void addPathNode(int index, Node node, double distance) {
        mPath.add(index, new PathContainer(node, distance));
    }

    public abstract boolean run(Node start, Node destination);
}