package com.crispeh.hubcore.item;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Joey on 3/5/2015.
 */
public abstract class HubItemToggleable extends HubItem {

    private final Boolean leftClick;
    private final Boolean rightClick;
    protected List<UUID> enabledFor = new ArrayList<UUID>();

    public HubItemToggleable(Boolean onLeftClick, Boolean onRightClick) {
        super(true);
        leftClick = onLeftClick;
        rightClick = onRightClick;
    }

    public HubItemToggleable() {
        this(true, true);
    }

    @Override
    public final void leftClicked(Player player) {
        if(!leftClick) return;
        toggleItem(player);
        if(allowNextState(player)) nextState(player);
    }

    protected abstract Boolean allowNextState(Player player);

    protected abstract void toggleItem(Player player);

    @Override
    public final void rightClicked(Player player) {
        if(!rightClick) return;
        toggleItem(player);
        if(allowNextState(player)) nextState(player);
    }

    private void nextState(Player player) {
        if(enabledFor.contains(player.getUniqueId())) {
            player.getInventory().setItemInHand(getItems().get(0));
            enabledFor.remove(player.getUniqueId());
            return;
        }
        player.getInventory().setItemInHand(getItems().get(1));
        enabledFor.add(player.getUniqueId());
    }
}
