package de.hsnr.osm2018.data.provider;

import de.hsnr.osm2018.data.graph.Graph;

public class SimpleDataProvider {

    protected Graph mGraph;

    public SimpleDataProvider() {
        this.mGraph = new Graph();
    }

    public SimpleDataProvider(Graph graph) {
        this.mGraph = graph;
    }

    /**
     * Get the complete @{@link Graph} managed by this data-provider
     *
     * @return Graph
     */
    public Graph getGraph() {
        return mGraph;
    }
}