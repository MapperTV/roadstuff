/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015-2016

The MIT License (MIT)

Copyright (c) 2015-2016 KillerMapper

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

        renderer.setRenderBounds(7 / 16F, 0.0F, 9 / 16F, 9 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(7 / 16F, 0.0F, 0.5F, 7.5 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(8.5 / 16F, 0.0F, 0.5F, 9 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);

        if(metadata == 1)
        {
            renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            TileEntityBlockTrafficSign tileSign = (TileEntityBlockTrafficSign)tile;

            GL11.glPushMatrix();

            // Direction
            switch(tileSign.getSignDirection())
            {
                case 0:

                    renderer.setRenderBounds(7 / 16F, 0.0F, 9 / 16F, 9 / 16F, 1F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 0.5F, 0.46875F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 9 / 16F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(1 / 16F, 0.0F, 10 / 16F, 15 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 1 / 16F, 10 / 16F, 1F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 0.25F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 10 / 16F, 0.8875F, 0.5F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 0.5F, 10 / 16F, 0.8225F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 10 / 16F, 10 / 16F, 12 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(6 / 16F, 0.0F, 10 / 16F, 10 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 10 / 16F, 11 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 2 / 16F, 10 / 16F, 12 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 3 / 16F, 10 / 16F, 13 / 16F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 0.25F, 10 / 16F, 14 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 5 / 16F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 6 / 16F, 10 / 16F, 1F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 11 / 16F, 10 / 16F, 14 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 12 / 16F, 10 / 16F, 13 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 13 / 16F, 10 / 16F, 12 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 10 / 16F, 11 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 15 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                case 1:

                    renderer.setRenderBounds(6 / 16F, 0.0F, 7 / 16F, 7 / 16F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 7 / 16F, 0.5F, 1F, 0.48F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 0.525F, 0.5F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 6 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 3 / 16F, 6 / 16F, 2 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 2 / 16F, 6 / 16F, 3 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 3 / 16F, 1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 5 / 16F, 0.0F, 6 / 16F, 11 / 16F, 16 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F, 13 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F, 14 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F, 15 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 1 / 16F, 6 / 16F, 1 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 0.0F, 6 / 16F, 4 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 4 / 16F, 1 / 16F, 6 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 6 / 16F, 2 / 16F, 6 / 16F, 8 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 8 / 16F, 3 / 16F, 6 / 16F, 10 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 10 / 16F, 4 / 16F, 6 / 16F, 12 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 5 / 16F, 6 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 6 / 16F, 6 / 16F, 1 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 5 / 16F, 6 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 4 / 16F, 6 / 16F, 3 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 3 / 16F, 3 / 16F, 6 / 16F, 4 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 4 / 16F, 2 / 16F, 6 / 16F, 5 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 5 / 16F, 1 / 16F, 6 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 6 / 16F, 0.0F, 6 / 16F, 10 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 10 / 16F, 1 / 16F, 6 / 16F, 11 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 11 / 16F, 2 / 16F, 6 / 16F, 12 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 3 / 16F, 6 / 16F, 13 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 4 / 16F, 6 / 16F, 14 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 5 / 16F, 6 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 6 / 16F, 6 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                case 2:

                    renderer.setRenderBounds(7 / 16F, 0.0F, 6 / 16F, 9 / 16F, 1F, 7 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 7 / 16F, 0.46875F, 1F, 8 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0.0F, 7 / 16F, 9 / 16F, 1F, 8 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(0.0F, 0.0F, 5 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 5 / 16F, 1F, 11 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F, 13 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 5 / 16F, 14 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 5 / 16F, 13 / 16F, 15 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(1 / 16F, 0.0F, 5 / 16F, 15 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 1 / 16F, 5 / 16F, 1F, 4 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 4 / 16F, 5 / 16F, 15 / 16F, 6 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 5 / 16F, 14 / 16F, 8 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 8 / 16F, 5 / 16F, 13 / 16F, 10 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 10 / 16F, 5 / 16F, 12 / 16F, 12 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 5 / 16F, 10 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(6 / 16F, 0.0F, 5 / 16F, 10 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 5 / 16F, 11 / 16F, 2 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 2 / 16F, 5 / 16F, 12 / 16F, 3 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 3 / 16F, 5 / 16F, 13 / 16F, 0.25F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 0.25F, 5 / 16F, 14 / 16F, 5 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 5 / 16F, 5 / 16F, 15 / 16F, 6 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 6 / 16F, 5 / 16F, 1F, 10 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 10 / 16F, 5 / 16F, 15 / 16F, 11 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 11 / 16F, 5 / 16F, 14 / 16F, 12 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 12 / 16F, 5 / 16F, 13 / 16F, 13 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 13 / 16F, 5 / 16F, 12 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 5 / 16F, 11 / 16F, 15 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 15 / 16F, 5 / 16F, 10 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                case 3:

                    renderer.setRenderBounds(9 / 16F, 0.0F, 0.5F, 10 / 16F, 1F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(8 / 16F, 0.0F, 0.5F, 9 / 16F, 1F, 0.5375F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(8 / 16F, 0.0F, 0.5875F, 9 / 16F, 1F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 11 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(10 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 3 / 16F, 11 / 16F, 2 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 2 / 16F, 2 / 16F, 11 / 16F, 3 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 3 / 16F, 1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 5 / 16F, 0.0F, 11 / 16F, 11 / 16F, 16 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F, 13 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F, 14 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F, 15 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(10 / 16F, 0.0F, 1 / 16F, 11 / 16F, 1 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 0.0F, 11 / 16F, 4 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 4 / 16F, 1 / 16F, 11 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 6 / 16F, 2 / 16F, 11 / 16F, 8 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 8 / 16F, 3 / 16F, 11 / 16F, 10 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 10 / 16F, 4 / 16F, 11 / 16F, 12 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 12 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(10 / 16F, 0.0F, 6 / 16F, 11 / 16F, 1 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 5 / 16F, 11 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 2 / 16F, 4 / 16F, 11 / 16F, 3 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 3 / 16F, 3 / 16F, 11 / 16F, 4 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 4 / 16F, 2 / 16F, 11 / 16F, 5 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 5 / 16F, 1 / 16F, 11 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 6 / 16F, 0.0F, 11 / 16F, 10 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 10 / 16F, 1 / 16F, 11 / 16F, 11 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 11 / 16F, 2 / 16F, 11 / 16F, 12 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 12 / 16F, 3 / 16F, 11 / 16F, 13 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 13 / 16F, 4 / 16F, 11 / 16F, 14 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 5 / 16F, 11 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                default:

                    renderer.setRenderBounds(7 / 16F, 0.0F, 9 / 16F, 9 / 16F, 1F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 0.5F, 0.46875F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 9 / 16F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 0.25F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 10 / 16F, 0.8875F, 0.5F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 0.5F, 10 / 16F, 0.8225F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 10 / 16F, 10 / 16F, 12 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(6 / 16F, 0.0F, 10 / 16F, 10 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 10 / 16F, 11 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 2 / 16F, 10 / 16F, 12 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 3 / 16F, 10 / 16F, 13 / 16F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 0.25F, 10 / 16F, 14 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 5 / 16F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 6 / 16F, 10 / 16F, 1F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 11 / 16F, 10 / 16F, 14 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 12 / 16F, 10 / 16F, 13 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 13 / 16F, 10 / 16F, 12 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 10 / 16F, 11 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 15 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
            }
            GL11.glPopMatrix();
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