package com.crispeh.apicore.command;

import com.crispeh.apicore.APICore;
import com.crispeh.apicore.exceptions.APICommandException;
import com.crispeh.apicore.exceptions.APICommandExecutionException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 7/22/2014.
 */
public abstract class APICommandHandler implements CommandExecutor, TabCompleter, ErrorHandler {

    @Getter
    private final String commandName;
    @Getter(AccessLevel.PROTECTED) private final APICore plugin = APICore.getInstance();
    @Getter(AccessLevel.PROTECTED) private final List<ErrorHandler> errorHandlerList = new ArrayList<>();
    @Getter
    private final Permission permission = getClass().getAnnotation(Permission.class);

    @SneakyThrows
    public APICommandHandler(String commandName) {
        this.commandName = commandName;
        register();
    }

    @Override
    public final boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        try {
            try {
                if (commandSender instanceof Player) {
                    if (permission != null && !commandSender.hasPermission(permission.value())) throw new APICommandException(this.permission.permissionErrorMessage(), APICommandException.CommandErrorType.PERMISSION);
                    playerExecutesCommand((Player) commandSender, args);
                }
                if (commandSender instanceof ConsoleCommandSender) {
                    consoleExecutesCommand((ConsoleCommandSender) commandSender, args);
                }
                if (commandSender instanceof BlockCommandSender) {
                    blockExecutesCommand((BlockCommandSender) commandSender, args);
                }
            } catch (Throwable t) {
                if (!(t instanceof CommandException)) {
                    t.printStackTrace();
                    throw new APICommandException(t.getClass().getSimpleName() + ": Exception encountered during command execution: " + t.getMessage(), APICommandException.CommandErrorType.OTHER);
                } else {
                    throw t;
                }
            }
        } catch (APICommandException ex) {
            APICommandExecutionException commandExecutionException = new APICommandExecutionException(ex.getMessage(), ex.getCommandErrorType(), args, command, commandSender);
            if (errorHandlerList.size() >= 1) {
                for (ErrorHandler commandErrorHandler : errorHandlerList) {
                    commandErrorHandler.handleCommandError(commandExecutionException);
                    errorHandlerList.add(commandErrorHandler);
                }
            } else {
                this.handleCommandError(commandExecutionException);
            }
        }
        return true;
    }

    private void register() throws APICommandException {
        PluginCommand pluginCommand = plugin.getCommand(commandName);
        if (pluginCommand == null) throw new APICommandException("Could not register command, check that it's in the plugin.yml!", APICommandException.CommandErrorType.NULL);
        pluginCommand.setExecutor(this);
    }

    @Override
    public void handleCommandError(APICommandExecutionException ex) {
        ex.getSender().sendMessage(ChatColor.RED + ex.getMessage());
    }

    @SuppressWarnings("UnusedParameters")
    protected void playerExecutesCommand(Player sender, String[] args) throws APICommandException {
        throw new APICommandException("You cannot execute this command!", APICommandException.CommandErrorType.OTHER);
    }

    @SuppressWarnings("UnusedParameters")
    protected void consoleExecutesCommand(ConsoleCommandSender sender, String[] args) throws APICommandException {
        throw new APICommandException("The console cannot execute this command!", APICommandException.CommandErrorType.OTHER);
    }

    @SuppressWarnings("UnusedParameters")
    protected void blockExecutesCommand(BlockCommandSender sender, String[] args) throws APICommandException {
        throw new APICommandException("A block cannot execute this command!", APICommandException.CommandErrorType.OTHER);
    }

    protected List<String> tabCompleteArgs(CommandSender sender, String[] args) {
        return new ArrayList<>();
    }

    @Override
    public final List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return tabCompleteArgs(commandSender, strings);
    }

}
