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
    }

}
