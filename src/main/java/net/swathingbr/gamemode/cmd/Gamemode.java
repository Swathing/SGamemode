package net.swathingbr.gamemode.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.*;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("gamemode.use")) {
                if (args.length == 0) {
                    p.sendMessage(" ");
                    p.sendMessage("§aGamemode §f- §aHelp");
                    p.sendMessage(" §a/gm <gamemode> <player>");
                    p.sendMessage(" §a/gm <gamemode>");
                    p.sendMessage(" ");
                }

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        p.sendMessage("§aYour game mode changed to Survival!");
                        p.setGameMode(SURVIVAL);
                    }
                    if (args[0].equalsIgnoreCase("1")) {
                        p.sendMessage("§aYour game mode changed to Creative!");
                        p.setGameMode(CREATIVE);
                    }
                    if (args[0].equalsIgnoreCase("2")) {
                        p.sendMessage("§aYour game mode changed to Adventure!");
                        p.setGameMode(ADVENTURE);
                    }
                    if (args[0].equalsIgnoreCase("3")) {
                        p.sendMessage("§aYour game mode changed to Spectator!");
                        p.setGameMode(SPECTATOR);
                    }
                }

                if (args.length == 2) {
                    String args1 = args[1];
                    Player target = Bukkit.getPlayer(args1);
                    if (!(target == null)) {
                        if (args[0].equalsIgnoreCase("0")) {
                            p.sendMessage("§a" + args1 + " game mode changed to Survival!");
                            target.sendMessage("§aYour game mode changed to Survival!");
                            target.setGameMode(SURVIVAL);
                        }
                        if (args[0].equalsIgnoreCase("1")) {
                            p.sendMessage("§a" + args1 + " game mode changed to Creative!");
                            target.sendMessage("§aYour game mode changed to Creative!");
                            target.setGameMode(CREATIVE);
                        }
                        if (args[0].equalsIgnoreCase("2")) {
                            p.sendMessage("§a" + args1 + " game mode changed to Adventure!");
                            target.sendMessage("§aYour game mode changed to Adventure!");
                            target.setGameMode(ADVENTURE);
                        }
                        if (args[0].equalsIgnoreCase("3")) {
                            p.sendMessage("§a" + args1 + " game mode changed to Spectator!");
                            target.sendMessage("§aYour game mode changed to Spectator!");
                            target.setGameMode(SPECTATOR);
                        }
                    } else {
                        p.sendMessage("§cThis player is offline!");
                    }
                }
            } else {
                p.sendMessage("§cNo permission!");
            }
        } else {
            sender.sendMessage("§cOnly players can execute this command.");
        }
        return false;
    }
}
