package tv.mapper.roadstuff.client.gui;

import net.minecraft.client.gui.GuiScreen;
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
    public void initGui() {
        super.initGui();
        guiLeft = (this.width - WIDTH - WIDTH) / 2;
        guiTop = (this.height - HEIGHT) / 2;
    }
    
    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft + WIDTH, guiTop, 0, 0, WIDTH, HEIGHT);
    }
}
