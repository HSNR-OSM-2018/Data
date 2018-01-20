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

    public static EdgeType evaluateEdgeTypeById(int id) {
        switch (id) {
            case 1:
                return EdgeType.MOTORWAY;
            case 2:
                return EdgeType.MOTORWAY_LINK;
            case 3:
                return EdgeType.LIVING_STREET;
            case 4:
                return EdgeType.PRIMARY;
            case 5:
                return EdgeType.PRIMARY_LINK;
            case 6:
                return EdgeType.RESIDENTIAL;
            case 7:
                return EdgeType.SECONDARY;
            case 8:
                return EdgeType.SECONDARY_LINK;
            case 9:
                return EdgeType.TERTIARY;
            case 10:
                return EdgeType.TERTIARY_LINK;
            case 11:
                return EdgeType.TRUNK;
            case 12:
                return EdgeType.TRUNK_LINK;
            case 13:
                return EdgeType.SERVICE;
            case 14:
                return EdgeType.UNCLASSIFIED;
        }
        return EdgeType.UNKNOWN;
    }
}