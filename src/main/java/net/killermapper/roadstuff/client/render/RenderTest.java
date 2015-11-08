//This render was a test using MinecraftForgeFrance tutorials. Credits to them.
//This file isn't meant to be kept and thus will be deleted later.

package net.killermapper.roadstuff.client.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderTest implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.1F, 0.8F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.45F, 0.1F, 0.45F, 0.55F, 0.8F, 0.55F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.0F, 0.8F, 0.0F, 1F, 0.9F, 1F);
		this.renderInInventory(tessellator, renderer, block, metadata);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		renderer.setRenderBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.1F, 0.8F);
		renderer.uvRotateTop = 1;
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.45F, 0.1F, 0.45F, 0.55F, 0.9F, 0.55F);
		renderer.uvRotateWest = 1;
		renderer.uvRotateEast = 1;
		renderer.uvRotateNorth = 1;
		renderer.uvRotateSouth = 1;
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.0F, 0.9F, 0.0F, 1F, 1F, 1F);
		renderer.uvRotateTop = 0;
		renderer.renderStandardBlock(block, x, y, z);
		renderer.uvRotateTop = 0;
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.renderTestId;
	}
	
	private void renderInInventory(Tessellator tessellator, RenderBlocks renderer, Block block, int metadata)
	{
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

}
