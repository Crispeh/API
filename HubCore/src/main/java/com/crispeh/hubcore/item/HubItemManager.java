package com.crispeh.hubcore.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 3/5/2015.
 */
public class HubItemManager implements Listener {

    private static List<HubItem> items = new ArrayList<>();

    public HubItemManager() {
        addHubItems();
    }

    /**
     * Registers HubItems to be added to the players inventory.
     *
     * @param items All HubItems to be added.
     */
    public static void addHubItems(HubItem... items) {
        for(HubItem item : items) {
            add(item);
        }
    }

    private static void add(HubItem hubItem) {
        items.add(hubItem);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack;
        ItemStack itemInSlot;

        player.getInventory().clear();
        for(HubItem item : items) {
            if(!shouldAdd(player, item.getItems())) continue;

            HubItemMeta itemMeta = null;
            try {
                itemMeta = item.getItemMeta();
            } catch (HubItemException e) {e.printStackTrace(); continue;}

            if(itemMeta.hidden()) continue;

            if(player.hasPermission(itemMeta.permission()) ||
                    itemMeta.permission().isEmpty()) {
                itemStack = item.getItems().get(0);
                itemInSlot = player.getInventory().getItem(itemMeta.slot());
                if((itemInSlot != null && itemInSlot.getType() != Material.AIR) ||
                        itemMeta.slot() == -1) {
                    player.getInventory().addItem(itemStack);
                    continue;
                }
                player.getInventory().setItem(itemMeta.slot(), itemStack);
            }
        }
    }

    /**
     * Sees if the item should be added to the players inventory.
     *
     * @param player the player that it should/shouldn't be added to.
     * @param items the items that should/shouldn't be added to the players inventory
     * @return if the items should be added to the players inventory.
     */
    private Boolean shouldAdd(Player player, List<ItemStack> items) {
        for(ItemStack i: items) {
            if(player.getInventory().contains(i)) return false;
        }
        return true;
    }

}
