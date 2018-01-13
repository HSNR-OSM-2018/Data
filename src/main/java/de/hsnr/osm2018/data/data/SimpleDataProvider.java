package de.hsnr.osm2018.data.data;

import de.hsnr.osm2018.data.graph.Graph;

public interface SimpleDataProvider {

    /**
     * Get the complete @{@link Graph} managed by this data-provider
     *
     * @return Graph
     */
    Graph getGraph();
}