package de.hsnr.osm2018.data.graph;

public enum EdgeType {
    MOTORWAY("motorway"),
    MOTORWAY_LINK("motorway_link"),
    TRUNK("trunk"),
    TRUNK_LINK("trunk_link"),
    PRIMARY("primary"),
    PRIMARY_LINK("primary_link"),
    SECONDARY("secondary"),
    SECONDARY_LINK("secondary_link"),
    TERTIARY("teritiary"),
    TERTIARY_LINK("teritiary_link"),
    LIVING_STREET("living_street"),
    RESIDENTIAL("residential"),
    UNCLASSIFIED("unclassified"),
    SERVICE("service"),
    UNKNOWN("");

    private String mName;

    EdgeType(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }
}