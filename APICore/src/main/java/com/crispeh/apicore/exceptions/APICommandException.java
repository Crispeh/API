package com.crispeh.apicore.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Joey on 7/22/2014.
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class APICommandException extends Exception {
    private final String message;
    private final CommandErrorType commandErrorType;

    public static enum CommandErrorType {
        PERMISSION,
        FEWARGS,
        MANYARGS,
        OTHER,
        NULL
    }
}
