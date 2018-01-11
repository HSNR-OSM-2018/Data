package de.hsnr.osm2018.data.utils;

import de.hsnr.osm2018.data.graph.EdgeType;

public class EdgeTypeUtils {

    public static EdgeType evaluateEdgeTypeByOSMTagName(String osmTagName) {
        if(osmTagName == null) {
            return EdgeType.UNKNOWN;
        }
        if(osmTagName.equals("motorway")) {
            return EdgeType.MOTORWAY;
        } else if(osmTagName.equals("motorway_link")) {
            return EdgeType.MOTORWAY_LINK;
        } else if(osmTagName.equals("living_street")) {
            return EdgeType.LIVING_STREET;
        } else if(osmTagName.equals("primary")) {
            return EdgeType.PRIMARY;
        } else if(osmTagName.equals("primary_link")) {
            return EdgeType.PRIMARY_LINK;
        } else if(osmTagName.equals("residential")) {
            return EdgeType.RESIDENTIAL;
        } else if(osmTagName.equals("secondary")) {
            return EdgeType.SECONDARY;
        } else if(osmTagName.equals("secondary_link")) {
            return EdgeType.SECONDARY_LINK;
        } else if(osmTagName.equals("teritiary")) {
            return EdgeType.TERTIARY;
        } else if(osmTagName.equals("teritiary_link")) {
            return EdgeType.TERTIARY_LINK;
        } else if(osmTagName.equals("trunk")) {
            return EdgeType.TRUNK;
        } else if(osmTagName.equals("trunk_link")) {
            return EdgeType.TRUNK_LINK;
        } else if(osmTagName.equals("service")) {
            return EdgeType.SERVICE;
        } else if(osmTagName.equals("unclassified")) {
            return EdgeType.UNCLASSIFIED;
        }
        return EdgeType.UNKNOWN;
    }
}
