package net.killermapper.roadstuff.common.blocks;

import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
import net.killermapper.roadstuff.common.tiles.TileEntityBoundingBlock;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTrafficLigth extends Block implements ITileEntityProvider {

	public static String[] subBlocks = new String[]{"render", "void"};
	public IIcon[] iconArray = new IIcon[subBlocks.length];

	public BlockTrafficLigth() {
		super(Material.rock);
		this.setResistance(5.0F);
		this.setHardness(3.0F);
		this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
		this.setBlockBounds(0, 0, 0, 1F, 1F, 1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		if(metadata == 0)
		{
			return new TileEntityTrafficLigth();
		}
		if(metadata == 1)
		{
			return new TileEntityBoundingBlock();
		}
		return null;
	}

	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	/*@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) 
	{
		int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(world.getTileEntity(x, y, z) instanceof TileEntityTrafficLigth)
		{
			TileEntityTrafficLigth tile = (TileEntityTrafficLigth)world.getTileEntity(x, y, z);
			tile.setDirection(direction);
		}
		if(world.getBlockMetadata(x, y, z) == 0)
		{
			for(int i = 1; i < 5; i++)
			{
				world.setBlock(x, y + i, z, RoadStuffBlocks.blockTrafficLight, 1, 3);
			}
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
		for(int i = 0; i < 5; i++)
		{
			if(!world.getBlock(x, y + i, z).isReplaceable(world, x, y + i, z))
			{
				return false;
			}
		}
        return true;
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) 
	{
		if(metadata == 0)
		{
			for(int i = 1; i < 5; i++)
			{
				world.setBlockToAir(x, y + i, z);
			}
		}
		else
		{
			int i = 1;
			boolean flag = true;
			while(flag)
			{
				if(world.getBlock(x, y - i, z) == RoadStuffBlocks.blockTrafficLight)
				{
					if(world.getBlockMetadata(x, y - i, z) == 0)
					{
						for(int j = 1; j < 5 - i; j++)
						{
							world.setBlockToAir(x, y + j, z);
						}
						world.setBlockToAir(x, y - i, z);
						flag = false;
					}
					else
					{
						world.setBlockToAir(x, y - i, z);
						i++;
					}
				}
				else
				{
					flag = false;
				}
			}
		}
	}


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
	{
		if(world.getBlockMetadata(x, y, z) != 0)
		{
			for(int i = 1; i < 5; i++)
			{
				if(world.getBlockMetadata(x, y - i, z) == 0 && world.getBlock(x, y - i, z) == RoadStuffBlocks.blockTrafficLight)
				{
					world.getBlock(x, y - i, z).onBlockActivated(world, x, y - i, z, player, side, hitx, hity, hitz);
					return true;
				}
			}
		}
		if (world.isRemote)
		{
			player.openGui(RoadStuff.instance, 1, world, x, y, z);
			return true;
		}
		else
		{
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return ClientProxy.renderTrafficLigthId;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata == 0 ? 0 : null;
	}*/
}
