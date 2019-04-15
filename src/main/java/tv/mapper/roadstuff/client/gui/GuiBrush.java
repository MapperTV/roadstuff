package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.network.BrushPacket;
import tv.mapper.roadstuff.network.RSNetwork;

public class GuiBrush extends GuiScreen
{
    private static final int WIDTH = 206;
    private static final int HEIGHT = 102;

    private static final int MAX_CHOICE = 10;

    private int pattern = 0;
    private int paint = 0;

    private int guiLeft;
    private int guiTop;
    private int selectX;
    private int selectY;

    private int posX;
    private int posY;

    private static final ResourceLocation brush_gui = new ResourceLocation(RoadStuff.MODID, "textures/gui/brush.png");

    public GuiBrush(int pattern, int paint)
    {
        this.pattern = pattern;
        this.paint = paint;
    }

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
        
        int pattern_temp = pattern;
        if(pattern > 7 && pattern < 16)
            pattern_temp = pattern - 8;
        else if(pattern > 15 && pattern < 24)
            pattern_temp = pattern - 16;
        else if(pattern > 23 && pattern < 32)
            pattern_temp = pattern - 24;
        selectX = guiLeft + 13 + pattern_temp * 18;
        selectY = guiTop + 13 + (pattern / 8) * 18;
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

        // Draws hover square above slots
        if(mouseX > guiLeft + 14 && mouseX < guiLeft + 159 && mouseY > guiTop + 14 && mouseY < guiTop + 87)
        {
            posX = Math.toIntExact(Math.round((mouseX - guiLeft - 15) / 18) * 18) + guiLeft + 16;
            posY = Math.toIntExact(Math.round((mouseY - guiTop - 15) / 18) * 18) + guiTop + 16;
            this.fontRenderer.drawStringWithShadow("posX: " + posX + ", posY: " + posY, 8, 56, new Color(255, 0, 0).getRGB());
            drawRect(posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
        }
        
        mc.getTextureManager().bindTexture(brush_gui);
        drawTexturedModalRect(selectX, selectY, 0, 102, 22, 22);

        this.fontRenderer.drawStringWithShadow("DEBUG MODE", 8, 8, new Color(255, 0, 0).getRGB());
        this.fontRenderer.drawStringWithShadow("mouseX: " + mouseX + ", mouseY: " + mouseY, 8, 40, new Color(255, 0, 0).getRGB()); // Draws mouse pointer coordinates. Only used to debug
        this.fontRenderer.drawStringWithShadow("pattern: " + pattern + ", paint: " + paint, 8, 24, new Color(255, 0, 0).getRGB());

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 0 && mouseX > guiLeft + 14 && mouseX < guiLeft + 159 && mouseY > guiTop + 14 && mouseY < guiTop + 87)
        {
            pattern = (posX - guiLeft - 15) / 18 + ((posY - guiTop - 15) / 18) * 8;
            selectX = posX - 3;
            selectY = posY - 3;
            return true;
        }

        return false;
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(this.allowCloseWithEscape() && p_keyPressed_1_ == 256 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(InputMappings.getInputByCode(p_keyPressed_1_, p_keyPressed_2_)))
        {
            RSNetwork.ROADSTUFF_CHANNEL.sendToServer(new BrushPacket(pattern, paint));
            this.close();
            return true;
        }
        else
        {
            return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
        }
    }
}
