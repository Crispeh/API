package com.crispeh.apicore.arena;

import org.bukkit.World;

/**
 * Created by Joey on 3/3/2015.
 */
public final class GArena {

    public String name;
    public String author;
    public World w;
    public Integer ID;

    public GArena(String name, String author, World w, Integer ID) {
        name = this.name;
        author = this.author;
        w = this.w;
        ID = this.ID;
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

}
