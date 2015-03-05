package com.crispeh.apicore.arena;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joey on 3/3/2015.
 */
public final class GArenaManager {

    //Contains the arenas and loaded arenas.
    private static Map<Integer, GArena> arenas = new HashMap<>();
    private static List<GArena> loadedArenas = new ArrayList<>();

    /**
     * Add an arena.
     *
     * @param arena The arena to be added. Allows getting, removing, loading, and unloading the arena.
     * @throws GArenaException Prevents the creation of already created arenas.
     */
    public static void addArena(GArena arena) throws GArenaException {
        if(arenas.containsKey(arena.ID)) throw new GArenaException("You cannot create an add an arena that's already been added!");
        arenas.put(arena.ID, arena);
    }

    /**
     * Remove an arena.
     *
     * @param arena The arena to be removed. Completely removes the arena, cannot be accessed unless re-added.
     * @throws GArenaException Prevents the removal of non-existent arenas.
     */
    public static void removeArena(GArena arena) throws GArenaException {
        if(!arenas.containsKey(arena.ID)) throw new GArenaException("You cannot remove an arena that doesn't exist!");
        arenas.remove(arena.ID);
    }

    /**
     * Get an arena for use.
     *
     * @param ID The ID of the arena. Special identifier for when fetching it.
     * @return The arena the matches the ID specified.
     * @throws GArenaException Prevents the returning on non-existent arenas.
     */
    public static GArena getArena(Integer ID) throws GArenaException {
        if(arenas.get(ID) == null) throw new GArenaException("No arenas exist under this ID!");
        return arenas.get(ID);
    }

    /**
     * Loads an arena, which allows the world to be modified and accessed by players.
     *
     * @param arena The arena to be loaded.
     * @throws GArenaException Prevents the loading of already loaded arenas or non-existent arenas.
     */
    public static void loadArena(GArena arena) throws GArenaException {
        if(arenaLoaded(arena)) throw new GArenaException("Arena already loaded!");
        if(arenas.get(arena.ID) == null) throw new GArenaException("Arena could not be found! Please try adding it first!");
        loadedArenas.add(arena);
        Bukkit.createWorld(WorldCreator.name(arena.w.getName()));
    }

    /**
     * Unloads an arena, preventing world modification and accessing by players.
     *
     * @param arena The arena to be unloaded.
     * @throws GArenaException Prevents the unloading of arenas that aren't loaded.
     */
    public static void unloadArena(GArena arena) throws GArenaException {
        if(!arenaLoaded(arena)) throw new GArenaException("Arena is not loaded!");
        loadedArenas.remove(arena);
        Bukkit.unloadWorld(arena.w, false);
    }

    /**
     * Checks if a specified arena is loaded.
     *
     * @param arena The arena being checked to see if it's loaded.
     * @return Returns true if the arena is loaded, otherwise false.
     */
    public static Boolean arenaLoaded(GArena arena) {
        return loadedArenas.contains(arena);
    }

}
