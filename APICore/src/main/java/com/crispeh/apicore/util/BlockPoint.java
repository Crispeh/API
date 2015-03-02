package com.crispeh.apicore.util;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

/**
 * Created by Joey on 3/1/2015.
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public final class BlockPoint implements Cloneable {

    @NonNull private Double pointX;
    @NonNull private Double pointY;
    @NonNull private Double pointZ;
    @NonNull private Float pitch;
    @NonNull private Float yaw;

    public boolean isBlock() {
        return (pitch == 0.0f && yaw == 0.0f && pointY % 1 == 0 && pointZ % 1 == 0 && pointX % 1 == 0);
    }

    public Location getLocation(World world) {
        return new Location(world, pointX, pointY, pointZ, yaw, pitch);
    }

    public static BlockPoint of(Double x, Double y, Double z) {
        return BlockPoint.of(x, y, z, 0f, 0f);
    }

    public static BlockPoint of(Location location) {
        return BlockPoint.of(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
    }

    public static BlockPoint of(Block block) {
        return BlockPoint.of(block.getLocation());
    }

    public Double distanceSquared(BlockPoint point) {
        Double x = Math.pow((this.pointX-point.getPointX()), 2);
        Double y = Math.pow((this.pointY-point.getPointY()), 2);
        Double z = Math.pow((this.pointZ-point.getPointZ()), 2);
        return x + y + z;
    }

    public Double distance(BlockPoint point) {
        return Math.sqrt(distanceSquared(point));
    }

    public BlockPoint add(Double x, Double y, Double z) {
        this.pointX += x;
        this.pointY += y;
        this.pointZ += z;
        return this;
    }

    public BlockPoint subtract(Double x, Double y, Double z) {
        return add(-1*x, -1*y, -1*z);
    }

}
