package com.crispeh.apicore.player;

import com.crispeh.apicore.util.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * Created by Joey on 3/1/2015.
 */
public class CPlayer {

    private Player bukkitPlayer;

    public CPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }
    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }
    public UUID getUUID() {
        return getBukkitPlayer().getUniqueId();
    }
    public String getName() {
        return getBukkitPlayer().getName();
    }
    public Location getLocation() {
        return getBukkitPlayer().getLocation();
    }
    public InetSocketAddress getAddress() {
        return getBukkitPlayer().getAddress();
    }
    public void message(MessageType msgType ,String message) {
        getBukkitPlayer().sendMessage(msgType.getPrefix() + ChatColor.translateAlternateColorCodes('&', message));
    }
    public void message(String message) {
        getBukkitPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
    public void teleport(Location l) { getBukkitPlayer().teleport(l); }
    public GameMode getGameMode() {
        return getBukkitPlayer().getGameMode();
    }
    public void setGameMode(GameMode gm) {
        getBukkitPlayer().setGameMode(gm);
    }
    public Boolean flightAllowed() {
        return getBukkitPlayer().getAllowFlight();
    }
    public void setFlightAllowed(Boolean b) {
        getBukkitPlayer().setAllowFlight(b);
    }
    public void setFlying(Boolean b) {
        getBukkitPlayer().setFlying(b);
    }
    public Boolean isFlying() {
        return getBukkitPlayer().isFlying();
    }
    public void showPlayer(CPlayer p) {
        getBukkitPlayer().showPlayer(getBukkitPlayer());
    }
    public void hidePlayer(CPlayer p) {
        getBukkitPlayer().hidePlayer(getBukkitPlayer());
    }
    public void setSaturation(Float saturation) {
        getBukkitPlayer().setSaturation(saturation);
    }
    public void setFoodLevel(Integer foodLevel) {
        getBukkitPlayer().setFoodLevel(foodLevel);
    }
    public void kickPlayer(String reason) {
        getBukkitPlayer().kickPlayer(reason);
    }
    public Double getHealth() {
        return getBukkitPlayer().getHealth();
    }
    public Integer getFoodLevel() {
        return getBukkitPlayer().getFoodLevel();
    }
    public void setHealth(Integer health) {
        getBukkitPlayer().setHealth(health);
    }
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        getBukkitPlayer().playSound(location, sound, volume, pitch);
    }

}
