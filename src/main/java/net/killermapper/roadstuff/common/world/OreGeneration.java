/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015

The MIT License (MIT)

Copyright (c) 2015 KillerMapper

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package net.killermapper.roadstuff.common.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
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
        this.addOreSpawn(RoadStuffBlocks.blockBitumenOre, 0, Blocks.stone, world, random, x, z, 16, 16, 16, 10, 32, 80);
    }

    private void generateNether(World world, Random random, int x, int z)
    {

    }

    public void addOreSpawn(Block block, int metadata, Block target, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {

        assert maxY > minY : "Y max must be above Y min!";
        assert maxX > 0 && maxX <= 16 : "X must be between 0 and 16.";
        assert minY > 0 : "Y min must be above 0.";
        assert maxY < 256 && maxY > 0 : "Y max must be between 0 and 256.";
        assert maxZ > 0 && maxZ <= 16 : "Z must be between 0 and 16.";

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
