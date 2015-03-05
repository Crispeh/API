package com.crispeh.apicore.arena;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joey on 3/4/2015.
 */
public class VoteManager {

    @Getter
    private static Map<GArena, Integer> arenaVotes = new HashMap<>();

    /**
     * Adds a vote for an arena.
     *
     * @param arena the arena the vote is being added to.
     */
    public static void addVote(GArena arena) {
        if(GArenaManager.arenaLoaded(arena)) {
            if(getArenaVotes().get(arena) != null) {
                arenaVotes.put(arena, arenaVotes.get(arena)+1);
            }else arenaVotes.put(arena, 1);
        }
    }

    /**
     * Removes a vote for an arena.
     *
     * @param arena the arena the vote is being removed from.
     */
    public static void removeVote(GArena arena) {
        if(GArenaManager.arenaLoaded(arena)) {
            arenaVotes.put(arena, arenaVotes.get(arena)-1);
        }
    }

    /**
     * Gets the votes of an arena.
     *
     * @param arena the arena the votes are being gotten from.
     * @return the votes.
     */
    public static Integer getVotes(GArena arena) {
        return arenaVotes.get(arena);
    }

}
