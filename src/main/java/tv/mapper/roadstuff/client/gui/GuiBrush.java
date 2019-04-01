package tv.mapper.roadstuff.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import tv.mapper.roadstuff.RoadStuff;

public class GuiBrush extends GuiScreen
{
    private static final int WIDTH = 256;
    private static final int HEIGHT = 256;

    private int guiLeft;
    private int guiTop;

    private static final ResourceLocation background = new ResourceLocation(RoadStuff.MODID, "textures/gui/test.png");

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        guiLeft = this.width / 2 - HEIGHT / 2;
        guiTop = this.height / 2 - HEIGHT / 2;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        super.render(mouseX, mouseY, partialTicks);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_))
        {
            return true;
        }
        else
        {
            if(p_keyPressed_1_ == 256 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(InputMappings.getInputByCode(p_keyPressed_1_, p_keyPressed_2_)))
            {
                this.mc.player.closeScreen();
            }
            return true;
        }
    }
}
