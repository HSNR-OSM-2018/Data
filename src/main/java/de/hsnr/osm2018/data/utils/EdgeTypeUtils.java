package de.hsnr.osm2018.data.utils;

import de.hsnr.osm2018.data.graph.EdgeType;

public class EdgeTypeUtils {

    public static EdgeType evaluateEdgeTypeByOSMTagName(String osmTagName) {
        if(osmTagName == null) {
            return EdgeType.UNKNOWN;
        }
        switch (osmTagName) {
            case "motorway":
                return EdgeType.MOTORWAY;
            case "motorway_link":
                return EdgeType.MOTORWAY_LINK;
            case "living_street":
                return EdgeType.LIVING_STREET;
            case "primary":
                return EdgeType.PRIMARY;
            case "primary_link":
                return EdgeType.PRIMARY_LINK;
            case "residential":
                return EdgeType.RESIDENTIAL;
            case "secondary":
                return EdgeType.SECONDARY;
            case "secondary_link":
                return EdgeType.SECONDARY_LINK;
            case "teritiary":
                return EdgeType.TERTIARY;
            case "teritiary_link":
                return EdgeType.TERTIARY_LINK;
            case "trunk":
                return EdgeType.TRUNK;
            case "trunk_link":
                return EdgeType.TRUNK_LINK;
            case "service":
                return EdgeType.SERVICE;
            case "unclassified":
                return EdgeType.UNCLASSIFIED;
        }
        return EdgeType.UNKNOWN;
    }
}