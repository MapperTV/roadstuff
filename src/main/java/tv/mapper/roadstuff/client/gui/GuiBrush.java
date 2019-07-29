package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.network.BrushPacket;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;
import tv.mapper.roadstuff.util.ModConstants;

public class GuiBrush extends Screen
{
    public static final ITextComponent title = new StringTextComponent("");

    private static final int WIDTH = 195;
    private static final int HEIGHT = 205;

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

    private int scroll = 0;
    private float currentScroll = 0.0f;
    private boolean isScrolling;

    private static final ResourceLocation brush_gui = new ResourceLocation(RoadStuff.MODID, "textures/gui/brush.png");

    public GuiBrush(int pattern, int paint, int color, float scroll)
    {
        super(title);
        this.pattern = pattern;
        this.paint = paint;
        this.color = color;
        this.currentScroll = scroll;
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

        scroll = (int)((currentScroll + 0.1) * 14);
        if(scroll < 0)
            scroll = 0;
        else if(scroll > 14)
            scroll = 14;

        int pattern_temp = pattern;
        if(pattern > 8 && pattern < 18)
            pattern_temp = pattern - 9;
        else if(pattern > 17 && pattern < 27)
            pattern_temp = pattern - 18;
        else if(pattern > 26 && pattern < 36)
            pattern_temp = pattern - 27;
        else if(pattern > 35 && pattern < 45)
            pattern_temp = pattern - 36;
        else if(pattern > 44 && pattern < 54)
            pattern_temp = pattern - 45;
        else if(pattern > 53 && pattern < 63)
            pattern_temp = pattern - 54;
        else if(pattern > 62 && pattern < 72)
            pattern_temp = pattern - 63;
        else if(pattern > 71 && pattern < 81)
            pattern_temp = pattern - 72;
        else if(pattern > 80 && pattern < 90)
            pattern_temp = pattern - 81;
        else if(pattern > 89 && pattern < 99)
            pattern_temp = pattern - 90;
        else if(pattern > 98 && pattern < 108)
            pattern_temp = pattern - 99;
        else if(pattern > 107 && pattern < 117)
            pattern_temp = pattern - 108;
        else if(pattern > 116 && pattern < 126)
            pattern_temp = pattern - 117;
        else if(pattern > 125 && pattern < 135)
            pattern_temp = pattern - 126;
        else if(pattern > 134 && pattern < 144)
            pattern_temp = pattern - 135;
        else if(pattern > 143 && pattern < 153)
            pattern_temp = pattern - 144;
        else if(pattern > 152 && pattern < 162)
            pattern_temp = pattern - 153;
        else if(pattern > 161 && pattern < 171)
            pattern_temp = pattern - 162;
        else if(pattern > 170 && pattern < 180)
            pattern_temp = pattern - 171;
        else if(pattern > 179 && pattern < 189)
            pattern_temp = pattern - 180;
        else if(pattern > 188 && pattern < 198)
            pattern_temp = pattern - 189;
        else if(pattern > 197 && pattern < 207)
            pattern_temp = pattern - 198;
        else if(pattern > 206 && pattern < 216)
            pattern_temp = pattern - 207;

        selectX = guiLeft + 6 + pattern_temp * 18;
        selectY = guiTop + 15 + (pattern / 9) * 18;
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
        for(int i = 0; i < 90; i++)
        {
            if(i + (scroll * 9) < ModConstants.PATTERNS)
            {
                minecraft.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/line/" + (i + (9 * scroll)) + ".png"));
                blit(guiLeft + 16 * j + 9 + j * 2, guiTop + 18 + row, 0, 0, 16, 16, 16, 16);

                j++;
                if(j >= 9)
                {
                    j = 0;
                    row += 18;
                }
            }
        }

        // Draws hover square above slots
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + 171 && mouseY > guiTop + 16 && mouseY < guiTop + 196)
        {
            posX = Math.toIntExact(Math.round((mouseX - guiLeft - 9) / 18) * 18) + guiLeft + 9;
            posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 18) * 18) + guiTop + 18;
            // this.font.drawStringWithShadow("posX: " + posX, 8, 80, new Color(255, 0, 0).getRGB());
            // this.font.drawStringWithShadow("PosY: " + posY, 8, 96, new Color(255, 0, 0).getRGB());
            fill(posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
        }

        // Draws selection box around the selected pattern

        // int patternCalc = pattern / 9;
        int boxY = selectY - (scroll * 18);

        // this.font.drawStringWithShadow("patternCalc: " + patternCalc + " (" + pattern / 9 + ")", 8, 170, new Color(255, 255, 0).getRGB());
        // this.font.drawStringWithShadow("boxY: " + boxY, 8, 186, new Color(255, 255, 0).getRGB());

        if(boxY > guiTop && boxY < guiTop + HEIGHT - 27)
        {
            minecraft.getTextureManager().bindTexture(brush_gui);
            blit(selectX, boxY, 256 - 22, 256 - 22, 22, 22);
        }

        // Scrollbar

        String title = new TranslationTextComponent("roadstuff.gui.paintbrush.title").getString();
        this.font.drawString(title, guiLeft + WIDTH / 2 - font.getStringWidth(title) / 2, guiTop + 6, 4210752);

        minecraft.getTextureManager().bindTexture(brush_gui);
        blit(guiLeft + WIDTH - 20, (int)(guiTop + 18 + 164 * this.currentScroll), 256 - 24, 0, 12, 15);

        this.font.drawStringWithShadow(warning, this.width / 2 - (warning.length() * 5) / 2, this.height / 96, new Color(255, 0, 0).getRGB());
        this.font.drawStringWithShadow(warning2, this.width / 2 - (warning2.length() * 5) / 2, this.height - this.height / 26, new Color(255, 0, 0).getRGB());
        this.font.drawStringWithShadow("Pattern: " + pattern, 8, 24, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("Paint: " + paint, 8, 40, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("Color: " + EnumPaintColor.getColorByID(color).getName(), 8, 56, new Color(255, 255, 255).getRGB());
        // this.font.drawStringWithShadow("selectX: " + selectX, 8, 72, new Color(255, 255, 255).getRGB());
        // this.font.drawStringWithShadow("selectY: " + selectY, 8, 88, new Color(255, 255, 255).getRGB());
        // this.font.drawStringWithShadow("scroll: " + scroll, 8, 110, new Color(255, 255, 255).getRGB());
        // this.font.drawStringWithShadow("currentScroll: " + currentScroll, 8, 140, new Color(255, 255, 0).getRGB());
        // this.font.drawStringWithShadow("isScrolling: " + isScrolling, 8, 156, new Color(255, 255, 0).getRGB());
        // this.font.drawStringWithShadow("mouseX: " + mouseX, 8, 200, new Color(255, 255, 0).getRGB());
        // this.font.drawStringWithShadow("mouseY: " + mouseY, 8, 216, new Color(255, 255, 0).getRGB());
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 0 && mouseX > guiLeft + 7 && mouseX < guiLeft + WIDTH - 25 && mouseY > guiTop + 14 && mouseY < guiTop + 196)
        {
            int choice = (posX - guiLeft - 9) / 18 + ((posY - guiTop - 9) / 18) * 9 + scroll * 9;
            if(choice < ModConstants.PATTERNS)
            {
                pattern = choice;
                selectX = posX - 3;
                selectY = posY + scroll * 18 - 3;
            }
            return true;
        }
        if(scrollbarClamp(mouseX, mouseY))
            isScrolling = true;
        return false;
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(this.shouldCloseOnEsc() && p_keyPressed_1_ == 256 || this.minecraft.gameSettings.keyBindInventory.isActiveAndMatches(InputMappings.getInputByCode(p_keyPressed_1_, p_keyPressed_2_)))
        {
            RSNetwork.ROADSTUFF_CHANNEL.sendToServer(new BrushPacket(pattern, paint, currentScroll));
            this.onClose();
            return true;
        }
        else
        {
            return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
        }
    }

    @Override
    public boolean mouseScrolled(double p_mouseScrolled_1_, double p_mouseScrolled_3_, double p_mouseScrolled_5_)
    {
        scroll -= p_mouseScrolled_5_;
        if(scroll < 0)
            scroll = 0;
        else if(scroll > (ModConstants.PATTERNS / 9) - 10)
            scroll = (ModConstants.PATTERNS / 9) - 10;

        int i = (ModConstants.PATTERNS + 8) / 16;
        this.currentScroll = (float)((double)this.currentScroll - p_mouseScrolled_5_ / (double)i);
        this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);

        return true;
    }

    @Override
    public boolean mouseDragged(double p_mouseDragged_1_, double p_mouseDragged_3_, int p_mouseDragged_5_, double p_mouseDragged_6_, double p_mouseDragged_8_)
    {
        if(this.isScrolling)
        {
            int i = this.guiTop + 18;
            int j = i + 179;
            this.currentScroll = ((float)p_mouseDragged_3_ - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);
            scroll = (int)((currentScroll + 0.05) * 14);
            if(scroll < 0)
                scroll = 0;
            return true;
        }
        else
        {
            return super.mouseDragged(p_mouseDragged_1_, p_mouseDragged_3_, p_mouseDragged_5_, p_mouseDragged_6_, p_mouseDragged_8_);
        }
    }

    @Override
    public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int p_mouseReleased_5_)
    {
        if(p_mouseReleased_5_ == 0)
        {
            this.isScrolling = false;
        }

        return super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, p_mouseReleased_5_);
    }

    protected boolean scrollbarClamp(double mouseX, double mouseY)
    {
        int i = this.guiLeft;
        int j = this.guiTop;
        int k = i + 175;
        int l = j + 18;
        int i1 = k + 13;
        int j1 = l + 179;
        return mouseX >= (double)k && mouseY >= (double)l && mouseX < (double)i1 && mouseY < (double)j1;
    }

}