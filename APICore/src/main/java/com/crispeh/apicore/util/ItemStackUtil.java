package com.crispeh.apicore.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static com.crispeh.apicore.util.StringUtil.colorize;

/**
 * Created by Joey on 3/1/2015.
 */
public final class ItemStackUtil {

    public static ItemStack createItemStack(Material m, Integer amount, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(m);
        itemStack.setAmount(amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        //Auto-Colorizes Name
        itemMeta.setDisplayName(colorize(name));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
