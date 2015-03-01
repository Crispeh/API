package com.crispeh.apicore;

import com.crispeh.apicore.util.APIModule;
import lombok.Getter;
import lombok.SneakyThrows;

/**
 * Created by Joey on 3/1/2015.
 */
public class APICore extends APIModule {

    @Getter private static APICore instance;


    @Override
    @SneakyThrows
    protected void enable() {
        logInfo("Enabled APICore.");
    }

    @Override
    protected void disable() {

    }
}
