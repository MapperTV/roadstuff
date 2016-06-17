/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015

The MIT License (MIT)

Copyright (c) 2015 - 2016 KillerMapper

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

package net.killermapper.roadstuff.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.sun.imageio.plugins.common.I18N;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.Reference;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.blocks.BlockTrafficSign;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
import net.killermapper.roadstuff.common.init.RoadStuffConfig;
import net.killermapper.roadstuff.common.network.PacketSignType;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiTrafficSign extends GuiScreen
{
    private static final ResourceLocation textures = new ResourceLocation(RoadStuff.MODID, "textures/gui/signConfig.png");

    private GuiButton buttonTypePrevious, buttonTypeNext, buttonTypePrevious10, buttonTypeNext10, buttonShapePrevious, buttonShapeNext, buttonQuit, buttonReset;
    private TileEntityBlockTrafficSign tileSign;

    short currentType = 0;
    short maxSignDiamond = Reference.maxSignDiamond - 1;
    short maxSignSquare = Reference.maxSignSquare - 1;
    short maxSignCircle = Reference.maxSignCircle - 1;
    short maxSignTriangle = Reference.maxSignTriangle - 1;
    short maxSignRectangle = Reference.maxSignRectangle - 1;

    byte currentShape = 0;

    public GuiTrafficSign(TileEntityBlockTrafficSign tile)
    {
        this.tileSign = tile;
        this.allowUserInput = false;
    }

    @Override
    public void initGui()
    {
        currentType = tileSign.getSignType();
        currentShape = tileSign.getSignShape();

        buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        buttonList.add(buttonQuit = new GuiButton(0, width / 2 - 20, height / 2 + 68, 40, 20, I18n.format("gui.trafficsign.done")));
        buttonList.add(buttonShapePrevious = new GuiButton(1, width / 2 - 84, height / 2 - 82, 20, 20, "<"));
        buttonList.add(buttonShapeNext = new GuiButton(2, width / 2 + 64, height / 2 - 82, 20, 20, ">"));
        buttonList.add(buttonTypePrevious10 = new GuiButton(3, width / 2 - 100, height / 2 , 20, 20, "<<"));
        buttonList.add(buttonTypeNext10 = new GuiButton(4, width / 2 + 85, height / 2, 20, 20, ">>"));
        buttonList.add(buttonTypePrevious = new GuiButton(5, width / 2 - 75, height / 2, 20, 20, "<"));
        buttonList.add(buttonTypeNext = new GuiButton(6, width / 2 + 60, height / 2, 20, 20, ">"));
        buttonList.add(buttonReset = new GuiButton(7, width / 2 + 100, height / 2 + 84, 40, 20, "Reset"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(textures);
        drawTexturedModalRect(width / 2 - 9, height / 2 + 0, 0, 256, 32, 256);
        drawTexturedModalRect(width / 2 -100, height / 2 + 84, 16, 0, 39, 21);
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.title"), (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.title"))) / 2, height / 2 - 114, 16777215);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.type") + " : " + currentType, (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.type")) - 16) / 2, height / 2 - 50, 16777215);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.shape") + " : " + currentShape, (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.shape")) - 16) / 2, height / 2 - 100, 16777215);

        // GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        // mc.getTextureManager().bindTexture(textures);
        if(currentShape == 0)
        {
            mc.renderEngine.bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/blocks/sign/square/square" + currentType + ".png"));
            func_152125_a(width / 2 - 48, height / 2 - 32, 0, 0, 1, 1, 100, 100, 1, 1);
        }
        if(currentShape == 1)
        {
            mc.renderEngine.bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/blocks/sign/circle/circle" + currentType + ".png"));
            func_152125_a(width / 2 - 48, height / 2 - 32, 0, 0, 1, 1, 100, 100, 1, 1);
        }
        if(currentShape == 2)
        {
            mc.renderEngine.bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/blocks/sign/triangle/triangle" + currentType + ".png"));
            func_152125_a(width / 2 - 48, height / 2 - 32, 0, 0, 1, 1, 100, 100, 1, 1);
        }
        if(currentShape == 3)
        {
            mc.renderEngine.bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/blocks/sign/diamond/diamond" + currentType + ".png"));
            func_152125_a(width / 2 - 48, height / 2 - 32, 0, 0, 1, 1, 100, 100, 1, 1);
        }
        if(currentShape == 4)
        {
            mc.renderEngine.bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/blocks/sign/rectangle/rectangle" + currentType + ".png"));
            func_152125_a(width / 2 - 48, height / 2 - 32, 0, 0, 1, 1, 100, 100, 1, 1);
        }
        mc.getTextureManager().bindTexture(textures);
        drawTexturedModalRect(width / 2 - 16, height / 2 - 88, currentShape * 32 + 96, 0, 32, 32);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if(parButton.id == 0)
        {
            RoadStuff.network.sendToServer(new PacketSignType(this.currentType, this.currentShape, tileSign.xCoord, tileSign.yCoord, tileSign.zCoord));
            mc.displayGuiScreen((GuiScreen)null);
        }
        else if(parButton.id == 1)
        {
            currentShape--;
            currentType = 0;
        }
        else if(parButton.id == 2)
        {
            currentShape++;
            currentType = 0;
        }
        else if(parButton.id == 3)
            currentType -= 10;
        else if(parButton.id == 4)
            currentType += 10;
        else if(parButton.id == 5)
            currentType--;
        else if(parButton.id == 6)
            currentType++;
        else if(parButton.id == 7)
            currentType = 0;

        // Sign and shape bounds
        switch(currentShape)
        {
            case 0:
                if(currentType < 0)
                    currentType = maxSignSquare;
                else if(currentType > maxSignSquare)
                    currentType = 0;
                break;
            case 1:
                if(currentType < 0)
                    currentType = maxSignCircle;
                else if(currentType > maxSignCircle)
                    currentType = 0;
                break;
            case 2:
                if(currentType < 0)
                    currentType = maxSignTriangle;
                else if(currentType > maxSignTriangle)
                    currentType = 0;
                break;
            case 3:
                if(currentType < 0)
                    currentType = maxSignDiamond;
                else if(currentType > maxSignDiamond)
                    currentType = 0;
                break;
            case 4:
                if(currentType < 0)
                    currentType = maxSignRectangle;
                else if(currentType > maxSignRectangle)
                    currentType = 0;
                break;
        }

        if(currentShape < 0)
            currentShape = 4;
        else if(currentShape > 4)
            currentShape = 0;

        if(RoadStuffConfig.enableDebug)
        {
            System.out.println("Current selected type: " + currentType);
            System.out.println("Current selected shape: " + currentShape);
            System.out.println("Signs: " + maxSignDiamond + " " + maxSignTriangle + " " + maxSignCircle + " " + maxSignSquare);
        }
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
