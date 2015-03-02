package com.crispeh.apicore.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * Created by Joey on 3/1/2015.
 */
public final class LocationUtil {

    public static final String DIVIDER = ",";

    /**
     * Will decode a location string to an actual location.
     *
     * @param locationString Location string.
     * @return The location decoded by the parser.
     */
    public static Location decodeLocationString(String locationString) {
        String[] seperator = locationString.split(LocationUtil.DIVIDER);
        if(seperator.length < 6) return null;
        Location location = new Location(Bukkit.getWorld(seperator[0]), Double.valueOf(seperator[1]), Double.valueOf(seperator[2]), Double.valueOf(seperator[3]));
        location.setYaw(Float.parseFloat(seperator[4]));
        location.setPitch(Float.parseFloat(seperator[5]));
        return location;
    }
    /**
     * Encodes a location into a storable string.
     *
     * @param location Location being encoded into a string.
     * @return Returns the encoded string for the location.
     */
    public static String encodeLocationString(Location location) {
        return location.getWorld().getName() + LocationUtil.DIVIDER + location.getX() + LocationUtil.DIVIDER + location.getY() + LocationUtil.DIVIDER + location.getZ() + LocationUtil.DIVIDER + location.getYaw() + LocationUtil.DIVIDER + location.getPitch();
    }

}
