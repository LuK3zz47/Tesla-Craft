package eu.teslacraft.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import eu.teslacraft.EnumMetals;
import eu.teslacraft.TeslaCraft;
import eu.teslacraft.blocks.BlockOre;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGenerator implements IWorldGenerator {

    private final EnumMetals generatedMetal;
    private final int minY;
    private final int maxY;
    private final int clustersInChunk;
    private final int clusterSize;

    public OreGenerator(EnumMetals generatedMetal, int minY, int maxY, int clustersInChunk, int clusterSize) {
        this.generatedMetal = generatedMetal;
        this.minY = minY;
        this.maxY = maxY;
        this.clustersInChunk = clustersInChunk;	
        this.clusterSize = clusterSize;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateOres(TeslaCraft.netherOre, world, random, chunkX, chunkZ);
                break;
            case 1:
                break;
            default:
                generateOres(TeslaCraft.ore, world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateOres(BlockOre block, World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < clustersInChunk; i++) {
            int x = (chunkX << 4) + random.nextInt(16);
            int y = random.nextInt(Math.max(maxY - minY, 0) + minY);
            int z = (chunkZ << 4) + random.nextInt(16);
            WorldGenMinable mineable = new WorldGenMinable(block, generatedMetal.meta, clusterSize, Blocks.stone);
            if(world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
                mineable.generate(world, random, x, y, z);
            }
        }
        world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
    }
}
