package tv.mapper.roadstuff.client.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.network.BrushPacket;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;
import tv.mapper.roadstuff.util.ModConstants;

public class GuiBrush extends Screen
{
    public static final ITextComponent title = new StringTextComponent("Paintbrush");

    private static final int WIDTH = 217;
    private static final int HEIGHT = 205;
    private static final int ROWS = (ModConstants.PATTERNS / 9) - 10;

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

    private int favorites[] = {0, 0, 0, 0, 0, 0, 0, 0};
    int favX;
    int favY;

    private TranslationTextComponent textTitle = new TranslationTextComponent("roadstuff.gui.paintbrush.title");
    private TranslationTextComponent textEraser = new TranslationTextComponent("roadstuff.message.brush.gui.eraser");
    private TranslationTextComponent textPattern = new TranslationTextComponent("roadstuff.message.brush.gui.pattern");
    private TranslationTextComponent textPaint = new TranslationTextComponent("roadstuff.message.brush.gui.paint");
    private TranslationTextComponent textColor = new TranslationTextComponent("roadstuff.message.brush.gui.color");
    private TranslationTextComponent textFav1 = new TranslationTextComponent("roadstuff.message.brush.gui.fav1");
    private TranslationTextComponent textFav2 = new TranslationTextComponent("roadstuff.message.brush.gui.fav2");

    private static final ResourceLocation brush_gui = new ResourceLocation(RoadStuff.MODID, "textures/gui/brush.png");

    public GuiBrush(int pattern, int paint, int color, float scroll, int[] favorites)
    {
        super(title);
        this.pattern = pattern;
        this.paint = paint;
        this.color = color;
        this.currentScroll = scroll;

        if(favorites.length == 8)
            this.favorites = favorites;
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

        scroll = (int)(currentScroll * ROWS);
        if(scroll < 0)
            scroll = 0;
        else if(scroll > ROWS)
            scroll = ROWS;

        int pattern_temp = pattern;
        if(pattern > 8)
            pattern_temp = pattern - 9 * (pattern / 9);

        selectX = guiLeft + 6 + pattern_temp * 18;
        selectY = guiTop + 15 + (pattern / 9) * 18;
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks)
    {
        super.render(stack, mouseX, mouseY, partialTicks);

        renderBackground(stack, 0);
        minecraft.getTextureManager().bindTexture(brush_gui);
        blit(stack, guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);

        // Draws patterns
        int j = 0;
        int row = 0;
        for(int i = 0; i < 90; i++)
        {
            if(i + (scroll * 9) < ModConstants.PATTERNS)
            {
                minecraft.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/" + (i + (9 * scroll)) + ".png"));
                blit(stack, guiLeft + 16 * j + 9 + j * 2, guiTop + 18 + row, 0, 0, 16, 16, 16, 16);

                j++;
                if(j >= 9)
                {
                    j = 0;
                    row += 18;
                }
            }
        }

        // Draws current selected pattern
        minecraft.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/" + pattern + ".png"));
        blit(stack, guiLeft + 193, guiTop + 18, 0, 0, 16, 16, 16, 16);

        // Draws favorites
        int fav_y = 54;
        for(int i = 0; i < 8; i++)
        {
            if(favorites[i] != 0)
            {
                minecraft.getTextureManager().bindTexture(new ResourceLocation(RoadStuff.MODID, "textures/block/" + (favorites[i] + ".png")));
                blit(stack, guiLeft + 193, guiTop + fav_y, 0, 0, 16, 16, 16, 16);
            }
            fav_y += 18;
        }

        // Draws hover square above slots
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + 171 && mouseY > guiTop + 16 && mouseY < guiTop + 196)
        {
            posX = Math.toIntExact(Math.round((mouseX - guiLeft - 9) / 18) * 18) + guiLeft + 9;
            posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 18) * 18) + guiTop + 18;
            fill(stack, posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
        }

        // Draws hover square above favs
        if(mouseX > guiLeft + 191 && mouseX < guiLeft + 210 && mouseY > guiTop + 52 && mouseY < guiTop + 197)
        {
            favX = Math.toIntExact(Math.round((mouseX - guiLeft - 12) / 18) * 18) + guiLeft + 13;
            favY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 18) * 18) + guiTop + 18;
            fill(stack, favX, favY, favX + 16, favY + 16, new Color(255, 255, 255, 128).getRGB());
        }

        // Draws selection box around the selected pattern
        int boxY = selectY - (scroll * 18);

        if(boxY > guiTop && boxY < guiTop + HEIGHT - 27)
        {
            minecraft.getTextureManager().bindTexture(brush_gui);
            blit(stack, selectX, boxY, 256 - 22, 256 - 22, 22, 22);
        }

        String title = textTitle.getString();
        this.font.drawString(stack, title, guiLeft + WIDTH / 2 - font.getStringWidth(title) / 2, guiTop + 6, 4210752);

        // Scrollbar
        minecraft.getTextureManager().bindTexture(brush_gui);
        blit(stack, guiLeft + WIDTH - 42, (int)(guiTop + 18 + 164 * this.currentScroll), 256 - 24, 0, 12, 15);

        this.font.drawStringWithShadow(stack, textPattern.getString() + pattern, guiLeft + 225, guiTop + 22, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow(stack, textPaint.getString() + paint, guiLeft + 225, guiTop + 40, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow(stack, textColor.getString() + EnumPaintColor.getColorByID(color).getNameTranslated(), guiLeft + 225, guiTop + 58, new Color(255, 255, 255).getRGB());

        // Draw tooltip
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + WIDTH - 43 && mouseY > guiTop + 14 && mouseY < guiTop + 196)
        {
            int patternHover = (posX - guiLeft - 9) / 18 + ((posY - guiTop - 9) / 18) * 9 + scroll * 9;
            if(patternHover == 0)
                GuiUtils.drawHoveringText(stack, Arrays.asList(textEraser), mouseX, mouseY, width, height, -1, font);
            else
            {
                TranslationTextComponent textPatternDisplay = new TranslationTextComponent(textPattern.getString() + patternHover);
                GuiUtils.drawHoveringText(stack, Arrays.asList(textPatternDisplay), mouseX, mouseY, width, height, -1, font);
            }
        }
        // Draw favorite tooltip
        else if(mouseX > guiLeft + 191 && mouseX < guiLeft + 210 && mouseY > guiTop + 52 && mouseY < guiTop + 197)
        {
            int patternHover = ((favY - guiTop - 40) / 18);

            List<TranslationTextComponent> patternTooltipFinal = new ArrayList<TranslationTextComponent>();
            TranslationTextComponent patternTooltip;
            TranslationTextComponent patternTooltip2;

            if(favorites[patternHover] == 0)
            {
                patternTooltip = new TranslationTextComponent(textFav1.getString());
                patternTooltip2 = new TranslationTextComponent(textFav2.getString());
                patternTooltipFinal.add(patternTooltip);
                patternTooltipFinal.add(patternTooltip2);
            }
            else
            {
                patternTooltip = new TranslationTextComponent(textPattern.getString() + favorites[patternHover]);
                patternTooltipFinal.add(patternTooltip);
            }

            GuiUtils.drawHoveringText(stack, patternTooltipFinal, mouseX, mouseY, width, height, -1, font);
        }

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + WIDTH - 43 && mouseY > guiTop + 14 && mouseY < guiTop + 196)
        {
            if(button == 0)
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
            else if(button == 1)
            {
                int fav = 0;

                int choice = (posX - guiLeft - 9) / 18 + ((posY - guiTop - 9) / 18) * 9 + scroll * 9;

                if(choice < ModConstants.PATTERNS && !IntStream.of(favorites).anyMatch(x -> x == choice) && choice != 0)
                {
                    while(favorites[fav] != 0 && fav < 7)
                        fav++;

                    if(fav == 7 && favorites[7] != 0)
                    {
                        for(int i = 0; i < 7; i++)
                        {
                            favorites[i] = favorites[i + 1];
                        }
                        favorites[7] = choice;
                    }
                    else
                        favorites[fav] = choice;
                }
            }
        }
        else if(mouseX > guiLeft + 191 && mouseX < guiLeft + 210 && mouseY > guiTop + 52 && mouseY < guiTop + 197)
        {
            int selectedFav = 0;
            selectedFav = ((favY - guiTop - 40) / 18);
            if(selectedFav >= 0 && selectedFav < 8)
            {
                if(favorites[selectedFav] != 0)
                    pattern = favorites[selectedFav];
            }
            else
                RoadStuff.LOGGER.warn("Invalid selected pattern! This is not supposed to happen... Please report to https://github.com/MapperTV/roadstuff/issues if you see this.");
        }

        if(button == 0 && scrollbarClamp(mouseX, mouseY))
            isScrolling = true;
        return false;
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(this.shouldCloseOnEsc() && p_keyPressed_1_ == 256 || this.minecraft.gameSettings.keyBindInventory.isActiveAndMatches(InputMappings.getInputByCode(p_keyPressed_1_, p_keyPressed_2_)))
        {
            RSNetwork.ROADSTUFF_CHANNEL.sendToServer(new BrushPacket(pattern, currentScroll, favorites));
            this.closeScreen();
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
        else if(scroll > ROWS)
            scroll = ROWS;

        int i = (ModConstants.PATTERNS + 375) / ROWS;
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
            scroll = (int)((currentScroll + 0.01) * ROWS);
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