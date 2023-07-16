package mov.oli;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.joml.Vector2i;

import java.util.*;

public class SparseChunksGenerator extends ChunkGenerator {

    private final Set<Vector2i> validChunks;

    public SparseChunksGenerator() {
        int maximumRange = 100;

        validChunks = new HashSet<>();

        Random random = new Random(Bukkit.getWorld("world").getSeed());

        for (int x = -maximumRange; x < maximumRange + 1; x++) {
            for (int z = -maximumRange; z < maximumRange + 1; z++) {

                if (random.nextFloat() < 1.0F / 50) {
                    validChunks.add(new Vector2i(x, z));
                }
            }
        }
    }

    private boolean isValidChunk(int x, int z) {
        for (Vector2i key : validChunks) {
            if (key.x == x && key.y == z) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean shouldGenerateSurface(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }

    @Override
    public boolean shouldGenerateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }

    @Override
    public boolean shouldGenerateCaves(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }

    @Override
    public boolean shouldGenerateStructures(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }

    @Override
    public boolean shouldGenerateDecorations(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }

    @Override
    public boolean shouldGenerateMobs(WorldInfo worldInfo, Random random, int chunkX, int chunkZ) {
        return isValidChunk(chunkX, chunkZ);
    }
}
