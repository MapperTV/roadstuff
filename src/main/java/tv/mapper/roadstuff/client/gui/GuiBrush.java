package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import tv.mapper.roadstuff.RoadStuff;

public class GuiBrush extends GuiScreen
{
    private static final int WIDTH = 206;
    private static final int HEIGHT = 102;

    private static final int MAX_CHOICE = 10;

    private int guiLeft;
    private int guiTop;

    private static final ResourceLocation brush_gui = new ResourceLocation(RoadStuff.MODID, "textures/gui/brush.png");

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        guiLeft = this.width / 2 - WIDTH / 2;
        guiTop = this.height / 2 - HEIGHT / 2;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        super.render(mouseX, mouseY, partialTicks);
        
        drawWorldBackground(0);
        mc.getTextureManager().bindTexture(brush_gui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);

        int j = 0;
        int row = 0;
        for(int i = 0; i < MAX_CHOICE; i++)
        {
            mc.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/line/" + i + ".png"));
            drawScaledCustomSizeModalRect(guiLeft + 16 * j + 16 + j * 2, guiTop + 16 + row, 0, 0, 1, 1, 16, 16, 1, 1);
            j++;
            if(j >= 8)
            {
                j = 0;
                row += 18;
            }
        }

        // ToDo: draw square above slots
        Color myColour = new Color(255, 255, 255, 128);
        drawRect(mouseX - 8, mouseY - 8, mouseX + 8, mouseY + 8, myColour.getRGB());
        this.fontRenderer.drawStringWithShadow(mouseX + "," + mouseY, 200.0F, 200.0F, new Color(255, 0, 0).getRGB()); // Draws mouse pointer coordinates. Only used to debug
    }

    public void tick()
    {

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
