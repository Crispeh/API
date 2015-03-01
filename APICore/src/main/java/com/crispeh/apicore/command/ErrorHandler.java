package com.crispeh.apicore.command;

import com.crispeh.apicore.exceptions.APICommandExecutionException;

/**
 * Created by Joey on 7/22/2014.
 */
public interface ErrorHandler {

    void handleCommandError(APICommandExecutionException ex);
}
