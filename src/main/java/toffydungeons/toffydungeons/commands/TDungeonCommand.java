package toffydungeons.toffydungeons.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import toffydungeons.toffydungeons.GUIs.DungeonCreationMenu;
import toffydungeons.toffydungeons.GUIs.DungeonMainMenu;
import toffydungeons.toffydungeons.GUIs.DungeonSelectionMenu;

public class TDungeonCommand implements CommandExecutor {

    /**
     * This is the main command when the user does /TDungeon, a list of features (in order) is:
     * Create a new dungeon
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can preform this command");
            return true;
        }
        if (args.length == 0) {
            DungeonMainMenu menu =  new DungeonMainMenu();
            menu.initaliseItems();
            ((Player) sender).openInventory(menu.getInventory());
            return true;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("dungeons")) {
            DungeonSelectionMenu menu = new DungeonSelectionMenu();
            menu.initaliseItems();
            ((Player) sender).openInventory(menu.getInventory());
            return true;
        }  else if (args.length == 1 && args[0].equalsIgnoreCase("create")) {
            DungeonCreationMenu menu = new DungeonCreationMenu();
            menu.updateLayout();
            ((Player) sender).openInventory(menu.getInventory());
        }   else if (args.length == 1 && args[0].equalsIgnoreCase("rename")) {
            return true;
        }
        return false;
    }

}
