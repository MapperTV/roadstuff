package net.killermapper.roadstuff.common.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.items.RoadStuffItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadstuffOre extends Block
{
    protected BlockRoadstuffOre()
    {
        super(Material.rock);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    public int quantityDropped(Random rand)
    {
        return 4 + rand.nextInt(2);
    }

    public Item getItemDropped(int metadata, Random rand, int fortune)
    {

        return RoadStuffItems.itemBitumen;
        /*if(metadata == 0)
        {
            return RoadStuffItems.itemBitumen;
        }
        else if(metadata == 1)
        {
            return RoadStuffItems.itemBitumen;
        }
        else if(metadata == 2)
        {
            return RoadStuffItems.itemBitumen;
        }
        return null;*/

    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(meta, random, fortune))
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
    
    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
        {
            if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
            {
                int j1 = 0;

                if (this == RoadStuffBlocks.blockBitumenOre)
                {
                    j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
                }
                return j1;
            }
            return 0;
        } 
}
