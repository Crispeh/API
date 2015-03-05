package com.crispeh.apicore.arena;

import com.crispeh.apicore.util.BlockPoint;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 3/3/2015.
 */
public final class GArena {

    public String name;
    public String author;
    public World w;
    public Integer ID;
    public List<BlockPoint> spawnPoints = new ArrayList<>();

    public GArena(String name, String author, World w, Integer ID, List<BlockPoint> spawnPoints) {
        name = this.name;
        author = this.author;
        w = this.w;
        ID = this.ID;
        spawnPoints = this.spawnPoints;
        //Stores all arena info inside this class, as long as defined every reload, should maintain properly.
    }

    /**
     * Get the name of the arena.
     *
     * @return the arena name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the author of the arena.
     *
     * @return the arena author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the world for the arena.
     *
     * @return the arena world.
     */
    public World getWorld() {
        return w;
    }

    /**
     * Gets the ID of the arena.
     *
     * @return the arena ID.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Gets all the spawn points defined for the arena.
     *
     * @return the List of spawn points.
     */
    public List<BlockPoint> getSpawnPoints() {
        return spawnPoints;
    }

}
