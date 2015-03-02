package com.crispeh.apicore.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Joey on 3/1/2015.
 */
public class PlayerManager {

    public static CPlayer getPlayer(Player p) {
        return new CPlayer(p);
    }
    public static Player getPlayer(CPlayer p) {
        return p.getBukkitPlayer();
    }
    public static Player getPlayer(String name) {
        return Bukkit.getPlayer(name);
    }
    public static Player getPlayer(UUID uuid) {
        return Bukkit.getPlayer(uuid);
    }

}
