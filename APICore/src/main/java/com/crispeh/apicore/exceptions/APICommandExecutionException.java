package com.crispeh.apicore.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Joey on 7/22/2014.
 */
@EqualsAndHashCode(callSuper = false)
@Data
public final class APICommandExecutionException extends APICommandException {
    private final String[] args;
    private final Command command;
    private final CommandSender sender;

    public APICommandExecutionException(String message, CommandErrorType commandErrorType, String[] args, Command command, CommandSender sender) {
        super(message, commandErrorType);
        this.args = args;
        this.command = command;
        this.sender = sender;
    }
}
