package com.crispeh.hubcore;

import com.crispeh.apicore.util.APIModule;
import lombok.Getter;

/**
 * Created by Joey on 3/4/2015.
 */
public abstract class HubCore extends APIModule {

    @Getter private static HubCore instance;

    @Override
    protected void enable() {
        logInfo("HubCore has been enabled.");
    }

    @Override
    protected void disable() {
        logInfo("HubCore has been disabled.");
    }
}
