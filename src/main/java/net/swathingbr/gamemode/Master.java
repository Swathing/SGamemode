package net.swathingbr.gamemode;

import net.swathingbr.gamemode.cmd.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Master extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("gamemode").setExecutor(new Gamemode());
        Bukkit.getConsoleSender().sendMessage("§a[SGamemode] Enabled successfully!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[SGamemode] Disabled successfully!");
    }
}
