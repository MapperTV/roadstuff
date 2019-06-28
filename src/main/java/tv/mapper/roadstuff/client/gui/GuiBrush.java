package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.network.BrushPacket;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.util.ModConstants;

public class GuiBrush extends Screen
{
    public static final ITextComponent title = new StringTextComponent("");

    private static final int WIDTH = 250;
    private static final int HEIGHT = 221;

    String warning = "WARNING: Mod in alpha test, to not use on your main save!";
    String warning2 = "Blocks may change in the future, breaking saves. Always backup!";

    private int pattern;
    private int paint;
    private int color;

    private int guiLeft;
    private int guiTop;
    private int selectX;
    private int selectY;

    private int posX;
    private int posY;

    private static final ResourceLocation brush_gui = new ResourceLocation(RoadStuff.MODID, "textures/gui/brush.png");

    public GuiBrush(int pattern, int paint, int color)
    {
        super(title);
        this.pattern = pattern;
        this.paint = paint;
        this.color = color;
    }

    @Override
    public boolean isPauseScreen()
    {
        return false;
    }

    @Override
    public void init()
    {
        super.init();
        guiLeft = this.width / 2 - WIDTH / 2;
        guiTop = this.height / 2 - HEIGHT / 2;

        int pattern_temp = pattern;
        if(pattern > 12 && pattern < 26)
            pattern_temp = pattern - 13;
        else if(pattern > 25 && pattern < 39)
            pattern_temp = pattern - 26;
        else if(pattern > 38 && pattern < 52)
            pattern_temp = pattern - 39;
        else if(pattern > 51 && pattern < 65)
            pattern_temp = pattern - 52;
        else if(pattern > 64 && pattern < 78)
            pattern_temp = pattern - 65;
        else if(pattern > 77 && pattern < 91)
            pattern_temp = pattern - 78;
        else if(pattern > 90 && pattern < 104)
            pattern_temp = pattern - 91;
        else if(pattern > 103 && pattern < 117)
            pattern_temp = pattern - 104;
        else if(pattern > 116 && pattern < 130)
            pattern_temp = pattern - 117;
        else if(pattern > 129 && pattern < 143)
            pattern_temp = pattern - 130;
        selectX = guiLeft + 6 + pattern_temp * 18;
        selectY = guiTop + 13 + (pattern / 13) * 18;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        super.render(mouseX, mouseY, partialTicks);

        renderBackground(0);
        minecraft.getTextureManager().bindTexture(brush_gui);
        blit(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);

        int j = 0;
        int row = 0;
        for(int i = 0; i < ModConstants.PATTERNS; i++)
        {
            minecraft.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/line/" + i + ".png"));
            blit(guiLeft + 16 * j + 9 + j * 2, guiTop + 16 + row, 0, 0, 16, 16, 16, 16);

            j++;
            if(j >= 13)
            {
                j = 0;
                row += 18;
            }
        }

        // Draws hover square above slots
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + 241 && mouseY > guiTop + 14 && mouseY < guiTop + 212)
        {
            posX = Math.toIntExact(Math.round((mouseX - guiLeft - 9) / 18) * 18) + guiLeft + 9;
            posY = Math.toIntExact(Math.round((mouseY - guiTop - 15) / 18) * 18) + guiTop + 16;
            this.font.drawStringWithShadow("posX: " + posX, 8, 80, new Color(255, 0, 0).getRGB());
            this.font.drawStringWithShadow("PosY: " + posY, 8, 96, new Color(255, 0, 0).getRGB());
            fill(posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
        }

        minecraft.getTextureManager().bindTexture(brush_gui);
        blit(selectX, selectY, 256 - 22, 256 - 22, 22, 22);

        this.font.drawStringWithShadow(warning, this.width /2 - (warning.length() * 5) / 2, this.height / 96, new Color(255, 0, 0).getRGB());
        this.font.drawStringWithShadow(warning2, this.width /2 - (warning2.length() * 5) / 2, this.height - this.height / 26, new Color(255, 0, 0).getRGB());
        this.font.drawStringWithShadow("Pattern: " + pattern, 8, 24, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("Paint: " + paint, 8, 40, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("Color: " + color, 8, 56, new Color(255, 255, 255).getRGB());

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 0 && mouseX > guiLeft + 7 && mouseX < guiLeft + 241 && mouseY > guiTop + 14 && mouseY < guiTop + 212)
        {
            pattern = (posX - guiLeft - 9) / 18 + ((posY - guiTop - 9) / 18) * 13;
            selectX = posX - 3;
            selectY = posY - 3;
            return true;
        }

        return false;
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(this.shouldCloseOnEsc() && p_keyPressed_1_ == 256 || this.minecraft.gameSettings.keyBindInventory.isActiveAndMatches(InputMappings.getInputByCode(p_keyPressed_1_, p_keyPressed_2_)))
        {
            RSNetwork.ROADSTUFF_CHANNEL.sendToServer(new BrushPacket(pattern, paint));
            this.onClose();
            return true;
        }
        else
        {
            return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
        }
    }
}
