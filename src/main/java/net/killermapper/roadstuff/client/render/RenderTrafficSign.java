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

package net.killermapper.roadstuff.client.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class RenderTrafficSign implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;

        renderer.setRenderBounds(0.4375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(0.4375F, 0.0F, 0.5F, 0.46875F, 1F, 0.625F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 0.5625F, 1F, 0.625F);
        this.renderInInventory(tessellator, renderer, block, metadata);

        if(metadata == 1)
        {
            renderer.setRenderBounds(0.3125F, 0.0F, 0.625F, 0.6875F, 0.0625F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.1875F, 0.0625F, 0.625F, 0.8125F, 0.125F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.125F, 0.125F, 0.625F, 0.875F, 0.1875F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.0625F, 0.1875F, 0.625F, 0.9375F, 0.3125F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.0F, 0.3125F, 0.625F, 1F, 0.6875F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.0625F, 0.6875F, 0.625F, 0.9375F, 0.8125F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.125F, 0.8125F, 0.625F, 0.875F, 0.875F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.1875F, 0.875F, 0.625F, 0.8125F, 0.9375F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.3125F, 0.9375F, 0.625F, 0.6875F, 1F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        if(metadata == 2)
        {
            renderer.setRenderBounds(0.0F, 0.3125F, 0.625F, 1F, 0.6875F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        if(metadata == 3)
        {
            renderer.setRenderBounds(0.0F, 0.0F, 0.625F, 1F, 1F, 0.6875F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        if(metadata == 4)
        {
            renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        if(metadata == 5)
        {
            renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            TileEntityBlockTrafficSign tileDirection = (TileEntityBlockTrafficSign)tile;

            // if(tileDirection.getDirection() == 0)
            // {
            // if(tileDirection.getDirection() == 1)
            // GL11.glRotatef(tileDirection.getDirection() * 90F, 0F, 1F, 0F);
            renderer.setRenderBounds(0.4375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
            renderer.renderStandardBlock(block, x, y, z);
            renderer.setRenderBounds(0.4375F, 0.0F, 0.5F, 0.46875F, 1F, 0.5625F);
            renderer.renderStandardBlock(block, x, y, z);
            renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 0.5625F, 1F, 0.5625F);
            renderer.renderStandardBlock(block, x, y, z);

            if(world.getBlockMetadata(x, y, z) == 1)
            {
                renderer.setRenderBounds(0.3125F, 0.0F, 0.625F, 0.6875F, 0.0625F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.1875F, 0.0625F, 0.625F, 0.8125F, 0.125F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.125F, 0.125F, 0.625F, 0.875F, 0.1875F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.0625F, 0.1875F, 0.625F, 0.9375F, 0.3125F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.0F, 0.3125F, 0.625F, 1F, 0.6875F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.0625F, 0.6875F, 0.625F, 0.9375F, 0.8125F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.125F, 0.8125F, 0.625F, 0.875F, 0.875F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.1875F, 0.875F, 0.625F, 0.8125F, 0.9375F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
                renderer.setRenderBounds(0.3125F, 0.9375F, 0.625F, 0.6875F, 1F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);

            }
            if(world.getBlockMetadata(x, y, z) == 2)
            {
                renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            if(world.getBlockMetadata(x, y, z) == 3)
            {
                renderer.setRenderBounds(0.0F, 0.0F, 0.625F, 1F, 1F, 0.6875F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            if(world.getBlockMetadata(x, y, z) == 4)
            {
                renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            if(world.getBlockMetadata(x, y, z) == 5)
            {
                renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            // }

            /*
             * renderer.setRenderBounds(0.4375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.4375F, 0.0F, 0.5F, 0.46875F, 1F, 0.5625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 0.5625F, 1F, 0.5625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * if(world.getBlockMetadata(x, y, z) == 1)
             * {
             * renderer.setRenderBounds(0.3125F, 0.0F, 0.625F, 0.6875F, 0.0625F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.1875F, 0.0625F, 0.625F, 0.8125F, 0.125F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.125F, 0.125F, 0.625F, 0.875F, 0.1875F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.0625F, 0.1875F, 0.625F, 0.9375F, 0.3125F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.0F, 0.3125F, 0.625F, 1F, 0.6875F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.0625F, 0.6875F, 0.625F, 0.9375F, 0.8125F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.125F, 0.8125F, 0.625F, 0.875F, 0.875F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.1875F, 0.875F, 0.625F, 0.8125F, 0.9375F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * renderer.setRenderBounds(0.3125F, 0.9375F, 0.625F, 0.6875F, 1F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * }
             * if(world.getBlockMetadata(x, y, z) == 2)
             * {
             * renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * }
             * if(world.getBlockMetadata(x, y, z) == 3)
             * {
             * renderer.setRenderBounds(0.0F, 0.0F, 0.625F, 1F, 1F, 0.6875F);
             * renderer.renderStandardBlock(block, x, y, z);
             * }
             * if(world.getBlockMetadata(x, y, z) == 4)
             * {
             * renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * }
             * if(world.getBlockMetadata(x, y, z) == 5)
             * {
             * renderer.setRenderBounds(0.375F, 0.0F, 0.5625F, 0.5625F, 1F, 0.625F);
             * renderer.renderStandardBlock(block, x, y, z);
             * }
             */
        }
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
        return ClientProxy.renderSignPostId;
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