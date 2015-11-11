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
		renderer.setRenderBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.1875F, 0.0625F, 0.1875F, 0.8125F, 0.25F, 0.8125F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.4375F, 0.75F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.3125F, 0.4375F, 0.3125F, 0.6875F, 0.625F, 0.6875F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(0.375F, 0.625F, 0.375F, 0.625F, 0.8125F, 0.625F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(0.4375F, 0.8125F, 0.4375F, 0.5625F, 1F, 0.5625F);
        this.renderInInventory(tessellator, renderer, block, metadata);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		renderer.setRenderBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.1875F, 0.0625F, 0.1875F, 0.8125F, 0.25F, 0.8125F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.4375F, 0.75F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.3125F, 0.4375F, 0.3125F, 0.6875F, 0.625F, 0.6875F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.375F, 0.625F, 0.375F, 0.625F, 0.8125F, 0.625F);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.4375F, 0.8125F, 0.4375F, 0.5625F, 1F, 0.5625F);
        renderer.renderStandardBlock(block, x, y, z);
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
