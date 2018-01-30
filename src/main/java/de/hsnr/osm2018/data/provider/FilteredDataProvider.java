package de.hsnr.osm2018.data.provider;

import de.hsnr.osm2018.data.graph.Edge;
import de.hsnr.osm2018.data.graph.EdgeType;
import de.hsnr.osm2018.data.graph.Graph;
import de.hsnr.osm2018.data.graph.Node;
import de.hsnr.osm2018.data.path.PathGraphContainer;

import java.util.HashMap;
import java.util.logging.Logger;

public class FilteredDataProvider extends SimpleDataProvider {

    private Logger logger = Logger.getLogger(FilteredDataProvider.class.getSimpleName());

    /**
     * Get a subset of the full @{@link Graph} managed by this data-provider.
     * The subset contains all relevant nodes and edges that are contained within a rectangular bound by the start and destination points.
     * It is furthermore widen by the vicinityRage used to be able for including slight differences from the air line.
     * Within the radius of the start- and destination positions edges of all @{@link EdgeType}s are included. The remaining area contains only edges of certain @{@link EdgeType}s (e.g. motorway, trunk and primary). Nodes without edges of these types will be omitted as well.
     * Building this subset of the graph is based on the assumption that only within a certain range all types of roads are used for traveling. For traveling longer distances only motorways and other high-speed roads are used.
     *
     * @param startLatitude        Latitude of start position
     * @param startLongitude       Longitude of start position
     * @param destinationLatitude  Latitude of destination position
     * @param destinationLongitude Longitude of destination position
     * @param globalVicinityRange  Tolerance range that will widen the bounding box. value should be interpreted as meters
     * @param localVicinityRadius  Subset local radius around start- and destination positions. value should be interpreted as meters
     * @return Graph subset of graph with nodes and edges within the bound box
     */
    public Graph getGraph(double startLatitude, double startLongitude, double destinationLatitude, double destinationLongitude, double globalVicinityRange, double localVicinityRadius) {
        double minLatitude = Math.min(startLatitude, destinationLatitude) - globalVicinityRange;
        double minLongitude = Math.min(startLongitude, destinationLongitude) - globalVicinityRange;
        double maxLatitude = Math.max(startLatitude, destinationLatitude) + globalVicinityRange;
        double maxLongitude = Math.max(startLongitude, destinationLongitude) + globalVicinityRange;

        Graph subset = new Graph();
        for (Node node : mGraph.getNodes().values()) {
            if (node.getDistance(startLatitude, startLongitude) <= localVicinityRadius || node.getDistance(destinationLatitude, destinationLongitude) <= localVicinityRadius) {
                subset.add(new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            }
        }
        for (Node node : subset.getNodes().values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (subset.contains(edge.getDestinationNode().getId())) {
                    node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                }
            }
        }
        for (Node node : mGraph.getNodes().values()) {
            if (node.getLatitude() >= minLatitude && node.getLatitude() <= maxLatitude && node.getLongitude() >= minLongitude && node.getLongitude() <= maxLongitude) {
                subset.add(new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            }
        }
        for (Node node : subset.getNodes().values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (subset.contains(edge.getDestinationNode().getId()) && edge.getType().isHighSpeed()) {
                    node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                }
            }
        }
        return subset;
    }

    /**
     * Get a subset of the full @{@link Graph} managed by this data-provider.
     * The subset contains all nodes and edges that are contained within a rectangular bound by the start and destination points.
     * It is furthermore widen by the vicinityRage used to be able for including slight differences from the air line.
     *
     * @param startLatitude        Latitude of start position
     * @param startLongitude       Longitude of start position
     * @param destinationLatitude  Latitude of destination position
     * @param destinationLongitude Longitude of destination position
     * @param vicinityRange        Tolerance range that will widen the bounding box. value should be interpreted as meters
     * @return Graph subset of graph with nodes and edges within the bound box
     */
    public Graph getGraph(double startLatitude, double startLongitude, double destinationLatitude, double destinationLongitude, double vicinityRange) {
        double minLatitude = Math.min(startLatitude, destinationLatitude) - vicinityRange;
        double minLongitude = Math.min(startLongitude, destinationLongitude) - vicinityRange;
        double maxLatitude = Math.max(startLatitude, destinationLatitude) + vicinityRange;
        double maxLongitude = Math.max(startLongitude, destinationLongitude) + vicinityRange;

        Graph subset = new Graph();
        for (Node node : mGraph.getNodes().values()) {
            if (node.getLatitude() >= minLatitude && node.getLatitude() <= maxLatitude && node.getLongitude() >= minLongitude && node.getLongitude() <= maxLongitude) {
                subset.add(new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            }
        }
        for (Node node : subset.getNodes().values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (subset.contains(edge.getDestinationNode().getId())) {
                    node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                }
            }
        }
        return subset;
    }

    /**
     * Get a subset of the full @{@link Graph} managed by this data-provider.
     * The subset contains all nodes and edges that are contained within an circle around the point. The circle radius is defined by the parameter vicinityRange.
     *
     * @param pointLatitude  Latitude of center point
     * @param pointLongitude Longitude of center point
     * @param vicinityRadius Subset radius. value should be interpreted as meters
     * @return Graph subset of graph with nodes and edges within the bound circle
     */
    public Graph getGraph(double pointLatitude, double pointLongitude, double vicinityRadius) {
        Graph subset = new Graph();
        for (Node node : mGraph.getNodes().values()) {
            if (node.getDistance(pointLatitude, pointLongitude) <= vicinityRadius) {
                subset.add(new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            }
        }
        for (Node node : subset.getNodes().values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (subset.contains(edge.getDestinationNode().getId())) {
                    node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                }
            }
        }
        return subset;
    }

    /**
     * Get a subset of the full @{@link Graph} managed by this data-provider together with the calculated start and destination node.
     * The subset contains all relevant nodes and edges that are contained within a rectangular bound by the start and destination points.
     * It is furthermore widen by the vicinityRage used to be able for including slight differences from the air line.
     * Within the radius of the start- and destination positions edges of all @{@link EdgeType}s are included. The remaining area contains only edges of certain @{@link EdgeType}s (e.g. motorway, trunk and primary). Nodes without edges of these types will be omitted as well.
     * Building this subset of the graph is based on the assumption that only within a certain range all types of roads are used for traveling. For traveling longer distances only motorways and other high-speed roads are used.
     *
     * @param startLatitude        Latitude of start position
     * @param startLongitude       Longitude of start position
     * @param destinationLatitude  Latitude of destination position
     * @param destinationLongitude Longitude of destination position
     * @param globalVicinityRange  Tolerance range that will widen the bounding box. value should be interpreted as meters
     * @param localVicinityRadius  Subset local radius around start- and destination positions. value should be interpreted as meters
     * @return Graph subset of graph with nodes and edges within the bounding box together with the start- and destination-node
     */
    public PathGraphContainer getPathGraphContainer(double startLatitude, double startLongitude, double destinationLatitude, double destinationLongitude, double globalVicinityRange, double localVicinityRadius) {
        logger.info("Starting subset generation for: startLatitude = [" + startLatitude + "], startLongitude = [" + startLongitude + "], destinationLatitude = [" + destinationLatitude + "], destinationLongitude = [" + destinationLongitude + "], globalVicinityRange = [" + globalVicinityRange + "], localVicinityRadius = [" + localVicinityRadius + "]");
        long start = System.currentTimeMillis();

        double minLatitude = Math.min(startLatitude, destinationLatitude) - globalVicinityRange;
        double minLongitude = Math.min(startLongitude, destinationLongitude) - globalVicinityRange;
        double maxLatitude = Math.max(startLatitude, destinationLatitude) + globalVicinityRange;
        double maxLongitude = Math.max(startLongitude, destinationLongitude) + globalVicinityRange;

        HashMap<Long, Node> localNodes = new HashMap<>(), globalNodes = new HashMap<>();
        Node startNode = null, destinationNode = null;
        double startDist = Double.MAX_VALUE, destinationDist = Double.MAX_VALUE;

        for (Node node : mGraph.getNodes().values()) {
            if (node.getEdges().isEmpty()) {
                continue;
            }
            double localStartDist = node.getDistance(startLatitude, startLongitude),
                   localDestinationDist = node.getDistance(destinationLatitude, destinationLongitude);
            if (localStartDist < startDist) {
                startNode = node;
                startDist = localStartDist;
            }
            if (localDestinationDist < destinationDist) {
                destinationNode = node;
                destinationDist = localDestinationDist;
            }
            if (node.getDistance(startLatitude, startLongitude) <= localVicinityRadius || node.getDistance(destinationLatitude, destinationLongitude) <= localVicinityRadius) {
                localNodes.put(node.getId(), new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            } else if (node.getLatitude() >= minLatitude && node.getLatitude() <= maxLatitude && node.getLongitude() >= minLongitude && node.getLongitude() <= maxLongitude) {
                globalNodes.put(node.getId(), new Node(node.getId(), node.getLatitude(), node.getLongitude()));
            }
        }
        Graph subset = new Graph();
        logger.info("Adding edges to subset graph after " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
        for (Node node : localNodes.values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (localNodes.containsKey(edge.getDestinationNode().getId()) || globalNodes.containsKey(edge.getDestinationNode().getId())) {
                    node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                }
            }
            subset.add(node);
        }
        for (Node node : globalNodes.values()) {
            for (Edge edge : mGraph.getNode(node.getId()).getEdges()) {
                if (edge.getType().isHighSpeed()) {
                    if (localNodes.containsKey(edge.getDestinationNode().getId()) || globalNodes.containsKey(edge.getDestinationNode().getId())) {
                        node.addEdge(new Edge(node, edge.getDestinationNode(), edge.getLength(), edge.getSpeed(), edge.getType()));
                    }
                }
            }
            subset.add(node);
        }
        long time = System.currentTimeMillis() - start;
        logger.info("Finished subset generation in " + (time / 1000) + " seconds");
        return new PathGraphContainer(startNode, destinationNode, subset);
    }
}