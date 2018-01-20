package de.hsnr.osm2018.data.graph;

public enum EdgeType {
    MOTORWAY(1, "motorway", true),
    MOTORWAY_LINK(2, "motorway_link", true),
    TRUNK(3, "trunk", true),
    TRUNK_LINK(4, "trunk_link", true),
    PRIMARY(5, "primary", true),
    PRIMARY_LINK(6, "primary_link", true),
    SECONDARY(7, "secondary", true),
    SECONDARY_LINK(8, "secondary_link", true),
    TERTIARY(9, "teritiary"),
    TERTIARY_LINK(10, "teritiary_link"),
    LIVING_STREET(11, "living_street"),
    RESIDENTIAL(12, "residential"),
    UNCLASSIFIED(13, "unclassified"),
    SERVICE(14, "service"),
    UNKNOWN(0, "");

    private String mName;
    private boolean mHighSpeed;
    private int mId;

    EdgeType(int id, String name) {
        this(id, name, false);
    }


    EdgeType(int id, String name, boolean highSpeed) {
        this.mId = id;
        this.mName = name;
        this.mHighSpeed = highSpeed;
    }

    public String getName() {
        return mName;
    }

    public boolean isHighSpeed() {
        return mHighSpeed;
    }

    public int getId() {
        return mId;
    }
}