package com.crispeh.apicore;

import com.crispeh.apicore.util.APIModule;
import lombok.SneakyThrows;

/**
 * Created by Joey on 3/1/2015.
 */
public class APICore extends APIModule {


    @Override
    @SneakyThrows
    protected void enable() {
        logInfo("Enabled APICore.");
    }

    @Override
    protected void disable() {

    }
}
