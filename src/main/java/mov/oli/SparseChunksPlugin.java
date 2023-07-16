package mov.oli;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class SparseChunksPlugin extends JavaPlugin {

    private static SparseChunksGenerator GENERATOR;

    @Override
    public void onEnable() {

        GENERATOR = new SparseChunksGenerator();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        getServer().getScheduler().scheduleSyncDelayedTask(this,
                new Runnable() {
                    public void run() {
                        {
                            getServer().createWorld(new WorldCreator("chunks").environment(World.Environment.NORMAL).generator(GENERATOR));
                        }
                        }});


    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return GENERATOR;
    }
}