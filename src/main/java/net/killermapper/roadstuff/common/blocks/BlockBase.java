package net.killermapper.roadstuff.common.blocks;

import net.killermapper.roadstuff.common.RoadStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{

    protected BlockBase(Material material)
    {
        super(material);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

}
