package com.crispeh.apicore.util;

import io.puharesource.mc.titlemanager.api.TitleObject;
import org.bukkit.entity.Player;

/**
 * Created by Joey on 3/5/2015.
 */
public final class TitleHandler {

    public static void sendFloatingText(Player player, String title, String subtitle) {
        new TitleObject(title, subtitle).send(player);
    }
    public static void sendFloatingText(Player player, String title, int fadeIn, int stay, int fadeOut) {
        new TitleObject(title, TitleObject.TitleType.TITLE).setFadeIn(fadeIn).setStay(stay).setFadeOut(fadeOut).send(player);
    }

}
