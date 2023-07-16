package mov.oli;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        World world = Bukkit.getServer().getWorld("chunks");

        event.getPlayer().teleport(new Location(world, 0, 64, 0));
    }
}
