package de.hsnr.osm2018.data.graph;

import java.io.Serializable;

public enum EdgeType implements Serializable {
    MOTORWAY("motorway", true),
    MOTORWAY_LINK("motorway_link", true),
    TRUNK("trunk", true),
    TRUNK_LINK("trunk_link", true),
    PRIMARY("primary", true),
    PRIMARY_LINK("primary_link", true),
    SECONDARY("secondary", true),
    SECONDARY_LINK("secondary_link", true),
    TERTIARY("teritiary"),
    TERTIARY_LINK("teritiary_link"),
    LIVING_STREET("living_street"),
    RESIDENTIAL("residential"),
    UNCLASSIFIED("unclassified"),
    SERVICE("service"),
    UNKNOWN("");

    private String mName;
    private boolean mHighSpeed;

    EdgeType(String name) {
        this(name, false);
    }


    EdgeType(String name, boolean highSpeed) {
        this.mName = name;
        this.mHighSpeed = highSpeed;
    }

    public String getName() {
        return mName;
    }

    public boolean isHighSpeed() {
        return mHighSpeed;
    }
}