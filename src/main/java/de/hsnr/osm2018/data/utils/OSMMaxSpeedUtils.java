package de.hsnr.osm2018.data.utils;


import de.hsnr.osm2018.data.graph.Edge;
import de.hsnr.osm2018.data.graph.EdgeType;

public class OSMMaxSpeedUtils {

    public static short convertOsmMaxSpeedTagToShort(String maxSpeedTag) {
        if(maxSpeedTag.equals("walk")) {
            return 5;
        } else if(maxSpeedTag.equals("none")) {
            return 130;
        } else if(maxSpeedTag.equals("signals")) {
            return 130;
        }
        else {
            return 0;
        }
    }

    public static short evaluateMaxSpeedByEdgeType(EdgeType mType) {
        short maxSpeed = 0;
        if(mType.getName().equals(EdgeType.LIVING_STREET.getName())) {
            maxSpeed = 30;
        } else if(mType.getName().equals(EdgeType.MOTORWAY.getName())) {
            maxSpeed = 130;
        } else if(mType.getName().equals(EdgeType.MOTORWAY_LINK.getName())) {
            maxSpeed = 130;
        } else if(mType.getName().equals(EdgeType.PRIMARY.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.PRIMARY_LINK.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.RESIDENTIAL.getName())) {
            maxSpeed = 50;
        } else if(mType.getName().equals(EdgeType.SECONDARY.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.SECONDARY_LINK.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.SERVICE.getName())) {
            maxSpeed = 50;
        } else if(mType.getName().equals(EdgeType.TERTIARY.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.TERTIARY_LINK.getName())) {
            maxSpeed = 80;
        } else if(mType.getName().equals(EdgeType.TRUNK.getName())) {
            maxSpeed = 50;
        } else if(mType.getName().equals(EdgeType.TRUNK_LINK.getName())) {
            maxSpeed = 50;
        } else if(mType.getName().equals(EdgeType.UNCLASSIFIED.getName())) {
            maxSpeed = 50;
        } else if(mType.getName().equals(EdgeType.UNKNOWN.getName())) {
            maxSpeed = 50;
        }
        return maxSpeed;
    }
}
