package com.crispeh.apicore.util;

import java.util.List;

/**
 * Created by Joey on 3/2/2015.
 */
public final class IntegerUtil {

    public static List<String> getHighestSize(List<String>... arrays) {
        int index = 0;
        int size = arrays[0].size();

        for(int i = 1; i < arrays.length; i++)
            if(arrays[i].size() > size)
                index = i;

        return arrays[index];
    }

}
