package de.hsnr.osm2018.data.utils;


public class OSMMaxSpeedUtils {

    public static short convertOsmMaxSpeedTagToShort(String maxSpeedTag) {
        if(maxSpeedTag.equals("walk")) {
            return 5;
        } else if(maxSpeedTag.equals("none")) {
            return 130;
        } else {
            return 0;
        }
    }
}
