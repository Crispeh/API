package com.crispeh.hubcore.item;

import com.crispeh.hubcore.HubCore;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.crispeh.hubcore.util.Messages.getFormat;

/**
 * Created by Joey on 3/5/2015.
 */
public abstract class HubItem implements Listener {

    public final List<ItemStack> items;

    public List<ItemStack> getItems() {
        return items;
    }

    protected abstract List<ItemStack> getValidItems();

    protected void rightClicked(Player player) {
        clicked(player);
    }

    protected void leftClicked(Player player) {
        clicked(player);
    }

    protected void clicked(Player player) {

    }

    public HubItem(boolean interactable) {
        if (interactable) {
            HubCore.getInstance().registerListener(this);
        }
        items = addItems(getValidItems());
    }

    private List<ItemStack> addItems(List<ItemStack> items) {
        List<ItemStack> cachedItems = new ArrayList<ItemStack>();
        ItemMeta itemMeta;
        for(ItemStack itemStack : items) {
            itemMeta = itemStack.getItemMeta();
            itemMeta.setLore(Arrays.asList(getPermanentItemLore()));
            itemStack.setItemMeta(itemMeta);
            cachedItems.add(itemStack);
        }
        return cachedItems;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public final void onInteract(PlayerInteractEvent event) {
		/*
		 *	If action is not left/right click block/air or
		 *	there is no item in the person's hand or
		 *	the item has no meta data or the item display name isn't matching return;
		 */
        if (event.getAction() == null ||
                event.getAction() == Action.PHYSICAL ||
                event.getPlayer().getItemInHand() == null ||
                !event.getPlayer().getItemInHand().hasItemMeta() ||
                !event.getPlayer().getItemInHand().getItemMeta().hasLore() ||
                !event.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals(getPermanentItemLore())) return;
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                rightClicked(event.getPlayer());
                break;
            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
                leftClicked(event.getPlayer());
                break;
        }
        event.setCancelled(true);
    }

    /**
     * Returns the item lore ~ which will stay permanent First line
     * @return item lore
     */
    protected abstract String getPermanentItemLore();

    /**
     * Returns the HubItemMeta for the current class
     * @return hubItemMeta
     * @throws HubItemException ~ if meta is null
     * @see HubItemMeta
     */
    public HubItemMeta getItemMeta() throws HubItemException {
        HubItemMeta itemMeta = getClass().getAnnotation(HubItemMeta.class);
        if(itemMeta == null) throw new HubItemException("Invalid HubItemMeta for "+getClass().getName()+" ~ It Does Not Exist!");
        return itemMeta;
    }

    /**
     * Get property ~ Other object aka boolean etc.
     * @param property ~ The property to get
     * @return Object ~ the property ~ Object
     */
    public final Object getPropertyObject(String property) throws HubItemException {
        return getConfigurationSection().get(property);
    }

    /**
     * Returns the configuration section
     * @return Object ~ the configuration section
     */
    public final ConfigurationSection getConfigurationSection() throws HubItemException {
        return HubCore.getInstance().getConfig().getConfigurationSection("hub-items." + getItemMeta().key() + ".properties");
    }

    /**
     * Get property like getFormat though it gets off property part
     * aka instead of getFormat("format.somecategory.lroekwiew")
     * it will automatically go to ("hub-items.<your-item-key>.properties.<property>")
     * @param property the property to get
     * @return String ~ The property
     */
    public final String getProperty(String property) throws HubItemException {
        return getProperty(property, false);
    }

    /**
     * Get property like getFormat though it gets off property part
     * aka instead of getFormat("format.somecategory.lroekwiew")
     * it will automatically go to ("hub-items.<your-item-key>.properties.<property>")
     * @param property the property to get
     * @return String ~ The property
     */
    public final String getProperty(String property, boolean prefix, String[]... replacements) throws HubItemException {
        return getFormat(getConfigurationSection().getCurrentPath() + "." + property, prefix, replacements);
    }
}
