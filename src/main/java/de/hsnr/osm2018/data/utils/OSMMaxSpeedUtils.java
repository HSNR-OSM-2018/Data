package de.hsnr.osm2018.data.utils;

public class OSMMaxSpeedUtils {

    /**
     * This function converts a number as string, or a specific word as string to a byte.
     * The string should describe a maximum speed.
     * All speed limits from 0-100 are supported.
     * Furthermore the speed limits 110,120,130,140 and 150 can be resolved within one byte. These values are stored like this:
     * 110 = 101, 120 = 102, 130 = 103, 140 = 104, 150 = 105.
     * If there is no speed limit the Value 127 (MAX_BYTE) is returned.
     **/
    public static byte compressOsmMaxSpeedValueToByte(String maxSpeed) {
        if(maxSpeed == null) {
            return -1;
        }

        byte compressedSpeed;
        short tmpSpeed;

        try {
            tmpSpeed = Short.parseShort(maxSpeed);
            if(tmpSpeed > 100) {
                compressedSpeed = OSMMaxSpeedUtils.parseToCompactedValue(tmpSpeed);
            } else {
                compressedSpeed = (byte) tmpSpeed;
            }
        } catch(NumberFormatException ex) {
            compressedSpeed = OSMMaxSpeedUtils.convertOsmMaxSpeedTagToByte(maxSpeed);
        }

        return compressedSpeed;
    }

    private static byte parseToCompactedValue(short tmpSpeed) {
        if(tmpSpeed < 100 && tmpSpeed % 10 != 0) {
            return -1;
        }

        return (byte) (100 + ((tmpSpeed - 100) / 10));
    }

    public static byte convertOsmMaxSpeedTagToByte(String maxSpeed) {
        byte compressedMaxSpeed;

        if(maxSpeed.toLowerCase().equals("walk")) {
            compressedMaxSpeed = 5;
        } else if(maxSpeed.toLowerCase().equals("none")) {
            compressedMaxSpeed = Byte.MAX_VALUE;
        } else {
            compressedMaxSpeed = -1;
        }

        return compressedMaxSpeed;
    }

    public static short convertOsmMaxSpeedTagToShort(String maxSpeed) {
        short maxSpeedValue;
        if(maxSpeed.toLowerCase().equals("walk")) {
            maxSpeedValue = 5;
        } else if(maxSpeed.toLowerCase().equals("none")) {
            maxSpeedValue = 130;
        }
        else {
            maxSpeedValue = -1;
        }
        return maxSpeedValue;
    }
}
