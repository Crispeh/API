package com.crispeh.apicore.util;

import com.crispeh.apicore.arena.GArena;

import java.util.Map;

/**
 * Created by Joey on 3/2/2015.
 */
public final class IntegerUtil {

    public static GArena getHighestVote(Map<GArena, Integer> voteMap) {
        int index = 0;
        GArena arena = null;

        for(GArena arenas : voteMap.keySet()) {
            if(voteMap.get(arenas) >= index) {
                index = voteMap.get(arenas);
                arena = arenas;
            }
        }
        return arena;
    }

}
