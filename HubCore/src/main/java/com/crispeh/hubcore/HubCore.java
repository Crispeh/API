package com.crispeh.hubcore;

import com.crispeh.apicore.util.APIModule;
import com.crispeh.hubcore.item.HubItemManager;
import lombok.Getter;

/**
 * Created by Joey on 3/4/2015.
 */
public class HubCore extends APIModule {

    @Getter private static HubCore instance;

    @Override
    protected void enable() {
        instance = this;
        logInfo("HubCore has been enabled.");
        registerListener(new HubItemManager());
    }

    @Override
    protected void disable() {
        logInfo("HubCore has been disabled.");
    }
}
