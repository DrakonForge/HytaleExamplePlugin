package org.example.plugin;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.newcmdsystem.CommandContext;
import com.hypixel.hytale.server.core.command.newcmdsystem.commandtypes.CommandBase;

import javax.annotation.Nonnull;

/**
 * This is an example command that will simply print the name of the plugin in chat when used.
 */
public class ExampleCommand extends CommandBase {

    private final String pluginName;

    public ExampleCommand(String pluginName) {
        super("test", "Prints a test message from the " + pluginName + " plugin.");
        this.pluginName = pluginName;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext commandContext) {
        commandContext.sendMessage(Message.raw("Hello from the " + pluginName + " plugin!"));
    }
}