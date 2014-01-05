package it.flaten.wandaway;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WandAway extends JavaPlugin implements Listener {
    WorldEditPlugin worldEdit;

    @Override
    public void onEnable() {
        this.worldEdit = (WorldEditPlugin) this.getServer().getPluginManager().getPlugin("WorldEdit");

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("wandaway.auto")) {
            this.worldEdit.getSession(event.getPlayer()).setToolControl(false);
        }
    }
}
