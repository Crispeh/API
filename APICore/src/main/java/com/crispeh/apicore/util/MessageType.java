package com.crispeh.apicore.util;

import static com.crispeh.apicore.util.StringUtil.colorize;

/**
 * Created by Joey on 3/1/2015.
 */
public enum MessageType {

    INFO("&6&l>> &r"),
    ERROR("&4&lX &r");

    public String prefix;

    MessageType(String s) {
        prefix = s;
    }

    public String getPrefix() {
        return colorize(prefix);
    }

}
