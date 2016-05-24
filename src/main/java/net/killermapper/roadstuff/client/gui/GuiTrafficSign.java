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

package net.killermapper.roadstuff.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.sun.imageio.plugins.common.I18N;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
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
    private static final ResourceLocation textures = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign/signConfig.png");
    private GuiButton buttonTypePrevious, buttonTypeNext, buttonShapePrevious, buttonShapeNext, buttonQuit;
    private TileEntityBlockTrafficSign tileSign;
    short currentType = 0, maxSign = 37;
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
        buttonList.add(buttonQuit = new GuiButton(0, width / 2 - 35, height / 2 + 30, 40, 20, I18n.format("gui.trafficsign.done")));
        buttonList.add(buttonShapePrevious = new GuiButton(1, width / 2 - 35, height / 2 - 26, 20, 20, "<"));
        buttonList.add(buttonShapeNext = new GuiButton(2, width / 2 + 15, height / 2 - 26, 20, 20, ">"));
        buttonList.add(buttonTypePrevious = new GuiButton(3, width / 2 - 35, height / 2 + 6, 20, 20, "<"));
        buttonList.add(buttonTypeNext = new GuiButton(4, width / 2 + 15, height / 2 + 6, 20, 20, ">"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textures);
        drawTexturedModalRect(width / 2 - 39, height / 2 - 56, 176, 144, 78, 112);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.title"), (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.title"))) / 2, height / 2 - 50, 16777215);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.type"), (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.type"))) / 2, height / 2 - 5, 16777215);
        drawString(fontRendererObj, I18n.format("gui.trafficsign.shape"), (width - fontRendererObj.getStringWidth(I18n.format("gui.trafficsign.shape"))) / 2, height / 2 - 37, 16777215);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textures);
        if(currentShape == 0)
            drawTexturedModalRect(width / 2 - 7, height / 2 + 8, currentType * 16, 0, 16, 16);
        if(currentShape == 1)
            drawTexturedModalRect(width / 2 - 7, height / 2 + 8, currentType * 16, 64, 16, 16);
        if(currentShape == 2)
            drawTexturedModalRect(width / 2 - 7, height / 2 + 8, currentType * 16, 128, 16, 16);
        if(currentShape == 3)
        {
            if(currentType < 11)
                drawTexturedModalRect(width / 2 - 7, height / 2 + 8, currentType * 16, 192, 16, 16);
            if(currentType > 10 && currentType < 22)
                drawTexturedModalRect(width / 2 - 7, height / 2 + 8, (currentType - 11) * 16, 208, 16, 16);
            if(currentType > 21 && currentType < 33)
                drawTexturedModalRect(width / 2 - 7, height / 2 + 8, (currentType - 22) * 16, 224, 16, 16);
            if(currentType > 32)
                drawTexturedModalRect(width / 2 - 7, height / 2 + 8, (currentType - 33) * 16, 240, 16, 16);
        }
        mc.getTextureManager().bindTexture(textures);
        drawTexturedModalRect(width / 2 - 7, height / 2 - 24, currentShape * 16 + 192, 128, 16, 16);
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
            currentShape--;
        else if(parButton.id == 2)
            currentShape++;
        else if(parButton.id == 3)
            currentType--;
        else if(parButton.id == 4)
            currentType++;

        // Sign and shape bounds
        if(currentType < 0)
            currentType = maxSign;
        else if(currentType > maxSign)
            currentType = 0;

        if(currentShape < 0)
            currentShape = 3;
        else if(currentShape > 3)
            currentShape = 0;
        System.out.println("Current selected type: " + currentType);
        System.out.println("Current selected shape: " + currentShape);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
