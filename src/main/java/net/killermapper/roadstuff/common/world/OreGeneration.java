package net.killermapper.roadstuff.common.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.killermapper.roadstuff.common.blocks.RoadStuffBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGeneration implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {

        switch(world.provider.dimensionId)
        {

            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;

        }

    }

    private void generateEnd(World world, Random random, int x, int z)
    {

    }

    private void generateSurface(World world, Random random, int x, int z)
    {
        this.addOreSpawn(RoadStuffBlocks.blockBitumenOre, 0, Blocks.stone, world, random, x, z, 16, 16, 20, 18, 24, 72);
    }

    private void generateNether(World world, Random random, int x, int z)
    {

    }

    public void addOreSpawn(Block block, int metadata, Block target, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {

        assert maxY > minY : "La position Y maximum doit être supérieure à la position Y minimum.";
        assert maxX > 0 && maxX <= 16 : "X doit se trouver entre 0 et 16.";
        assert minY > 0 : "La position Y minimum doit être supérieure à 0.";
        assert maxY < 256 && maxY > 0 : "La position Y maximum doit se trouver entre 0 et 256.";
        assert maxZ > 0 && maxZ <= 16 : "Z doit se trouver entre 0 et 16.";

        for(int i = 0; i < chancesToSpawn; i++)
        {

            int posY = random.nextInt(128);

            if((posY <= maxY) && (posY >= minY))
            {

                (new WorldGenMinable(block, metadata, maxVeinSize, target)).generate(world, random, blockXPos + random.nextInt(16), posY, blockZPos + random.nextInt(16));

            }

        }

    }
}
