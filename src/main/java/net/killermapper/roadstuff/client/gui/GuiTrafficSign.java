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
import net.killermapper.roadstuff.common.PacketSignType;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiTrafficSign extends GuiScreen
{
    private static final ResourceLocation textures = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign/signConfig.png");
    private GuiButton buttonPrevious, buttonNext, buttonQuit;
    private TileEntityBlockTrafficSign tileSign;
    short currentSign = 0, maxSign = 4;

    public GuiTrafficSign(TileEntityBlockTrafficSign tile)
    {
        this.tileSign = tile;
        this.allowUserInput = false;
    }

    @Override
    public void initGui()
    {
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        buttonList.add(buttonQuit = new GuiButton(0, width / 2 - 25, height / 2 + 15, 50, 20, I18n.format("gui.trafficsign.done")));
        buttonList.add(buttonPrevious = new GuiButton(1, width / 2 - 40, height / 2 - 10, 20, 20, "<"));
        buttonList.add(buttonNext = new GuiButton(2, width / 2 + 20, height / 2 - 10, 20, 20, ">"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textures);
        drawTexturedModalRect(width / 2 - 64, height / 2 - 40, 0, 0, 128, 80);
        drawString(fontRendererObj, "Sign Selection", width / 2 - 35, height / 2 - 28, 100);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textures);
        /*
         * switch(currentSign)
         * {
         * case 0:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 0, 80, 16, 16);
         * break;
         * case 1:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 16, 80, 16, 16);
         * break;
         * case 2:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 32, 80, 16, 16);
         * break;
         * case 3:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 48, 80, 16, 16);
         * break;
         * case 4:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 64, 80, 16, 16);
         * break;
         * default:
         * drawTexturedModalRect(width / 2 - 8, height / 2 - 8, 0, 80, 16, 16);
         * break;
         * }
         */
        drawTexturedModalRect(width / 2 - 8, height / 2 - 8, currentSign * 16, 80, 16, 16);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if(parButton.id == 0)
        {
            RoadStuff.network.sendToServer(new PacketSignType(this.currentSign, tileSign.xCoord, tileSign.yCoord, tileSign.zCoord));
            mc.displayGuiScreen((GuiScreen)null);
        }
        else if(parButton.id == 1)
        {
            currentSign--;
        }
        else if(parButton.id == 2)
            currentSign++;

        if(currentSign < 0)
            currentSign = maxSign;
        else if(currentSign > maxSign)
            currentSign = 0;
        System.out.println("Current selected sign: " + currentSign);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
