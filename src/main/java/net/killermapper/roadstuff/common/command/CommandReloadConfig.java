package net.killermapper.roadstuff.common.command;

import java.io.File;

import net.killermapper.roadstuff.common.init.ConfigurationLoader;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandReloadConfig extends CommandBase {

	@Override
	public String getCommandName() {
		return "rsreload";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}
	
	@Override
	public int getRequiredPermissionLevel()
    {
        return 1;
    }

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		ConfigurationLoader.read(new File(ConfigurationLoader.configFilePath));
		sender.addChatMessage(new ChatComponentText("Configuration file reloaded"));
	}

}
