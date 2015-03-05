package com.crispeh.apicore.arena;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joey on 3/3/2015.
 */
public final class GArenaManager {

    private static Map<Integer, GArena> arenas = new HashMap<>();
    private static Map<Integer, GArena> loadedArenas = new HashMap<>();

    public static void addArena(String name, String author, World w, Integer ID) throws GArenaException {
        GArena arena = new GArena(name, author, w, ID);
        if(arenas.containsKey(arena.ID)) throw new GArenaException("You cannot create an add an arena that's already been added!");
        arenas.put(arena.ID, arena);
    }
    public static void removeArena(GArena arena) throws GArenaException {
        if(!arenas.containsKey(arena.ID)) throw new GArenaException("You cannot remove an arena that doesn't exist!");
        arenas.remove(arena.ID);
    }
    public static GArena getArena(Integer ID) throws GArenaException {
        if(arenas.get(ID) == null) throw new GArenaException("No arenas exist under this ID!");
        return arenas.get(ID);
    }
    public static void loadArena(Integer ID) throws GArenaException {
        if(arenaLoaded(ID)) throw new GArenaException("Arena already loaded!");
        loadedArenas.put(arenas.get(ID).ID, arenas.get(ID));
        Bukkit.createWorld(WorldCreator.name(getArena(ID).w.getName()));
    }
    public static void unloadArena(Integer ID) throws GArenaException {
        if(!arenaLoaded(ID)) throw new GArenaException("Arena is not loaded!");
        loadedArenas.remove(getArena(ID).ID);
        Bukkit.unloadWorld(getArena(ID).w, false);
    }
    public static Boolean arenaLoaded(Integer ID) {
        return loadedArenas.containsKey(ID);
    }

}
