package tv.mapper.roadstuff.client.gui;

import java.awt.Color;
import java.util.Arrays;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.config.GuiUtils;
import tv.mapper.roadstuff.RoadStuff;

public class RGBScreen extends Screen
{
    private SignWorkshopScreen previousScreen;

    private static final int WIDTH = 240;
    private static final int HEIGHT = 96;

    private int guiLeft;
    private int guiTop;

    private Color RGB = new Color(0, 0, 0);
    public static final ITextComponent title = new StringTextComponent("Color Picker");
    private ResourceLocation RGB_SCREEN = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign_workshop_tabs.png");

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    private float redCursor = 0.0f;
    private float greenCursor = 0.0f;
    private float blueCursor = 0.0f;

    private int colorIndex;
    private int currentCursor;

    private boolean isScrolling;

    protected RGBScreen(SignWorkshopScreen previousScreen, int colorIndex, Color existingColor)
    {
        super(title);
        this.previousScreen = previousScreen;
        this.colorIndex = colorIndex;

        red = existingColor.getRed();
        green = existingColor.getGreen();
        blue = existingColor.getBlue();
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

        this.addButton(new Button(guiLeft + 44, guiTop + 17, 15, 20, "-", (redMinus) ->
        {
            if(red > 0)
                red--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 17, 15, 20, "+", (redPlus) ->
        {
            if(red < 255)
                red++;
        }));
        this.addButton(new Button(guiLeft + 44, guiTop + 39, 15, 20, "-", (greenMinus) ->
        {
            if(green > 0)
                green--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 39, 15, 20, "+", (greenPlus) ->
        {
            if(green < 255)
                green++;
        }));
        this.addButton(new Button(guiLeft + 44, guiTop + 61, 15, 20, "-", (blueMinus) ->
        {
            if(blue > 0)
                blue--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 61, 15, 20, "+", (bluePlus) ->
        {
            if(blue < 255)
                blue++;
        }));
        this.addButton(new Button(guiLeft + 60, guiTop + 100, 120, 20, "Confirm", (validation) ->
        {
            switch(colorIndex)
            {
                case 0:
                    previousScreen.symbolColor = new Color(red, green, blue);
                    break;
                case 1:
                    previousScreen.borderColor = new Color(red, green, blue);
                    break;
                case 2:
                    previousScreen.bgColor = new Color(red, green, blue);
                    break;
                case 3:
                    previousScreen.detailColor = new Color(red, green, blue);
                    break;
            }
            minecraft.displayGuiScreen(previousScreen);
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(RGB_SCREEN);

        this.blit(guiLeft, guiTop, 0, 160, WIDTH, HEIGHT);

        this.blit(guiLeft + 60 + red / 2, guiTop + 20, 250, 240, 6, 16);
        this.blit(guiLeft + 60 + green / 2, guiTop + 42, 250, 240, 6, 16);
        this.blit(guiLeft + 60 + blue / 2, guiTop + 64, 250, 240, 6, 16);

        this.font.drawString(title.getString(), guiLeft + WIDTH / 2 - font.getStringWidth(title.getString()) / 2, guiTop + 6, 4210752);

        this.font.drawStringWithShadow("R:" + red, guiLeft + 11, guiTop + 23, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("G:" + green, guiLeft + 11, guiTop + 45, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("B:" + blue, guiLeft + 11, guiTop + 67, new Color(255, 255, 255).getRGB());

        RGB = new Color(red, green, blue);
        fill(guiLeft + 218, guiTop + 17, guiLeft + 233, guiTop + 81, RGB.getRGB());

        if(mouseX > guiLeft + 218 && mouseX < guiLeft + 233 && mouseY > guiTop + 17 && mouseY < guiTop + 81)
        {
            String hex = String.format("#%02X%02X%02X", red, green, blue);
            GuiUtils.drawHoveringText(Arrays.asList("" + hex), mouseX, mouseY, width, height, -1, font);
        }

        super.render(mouseX, mouseY, partialTicks);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 0 && scrollbarClamp(mouseX, mouseY))
        {
            this.isScrolling = true;
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean mouseDragged(double p_mouseDragged_1_, double p_mouseDragged_3_, int p_mouseDragged_5_, double p_mouseDragged_6_, double p_mouseDragged_8_)
    {
        if(this.isScrolling)
        {
            int i = this.guiLeft + 60;
            int j = i + 128;

            if(currentCursor == 0)
            {
                this.redCursor = ((float)p_mouseDragged_1_ - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
                this.redCursor = MathHelper.clamp(this.redCursor, 0.0F, 1.0F);

                red = (int)(redCursor * 255);
                if(red < 0)
                    red = 0;
                else if(red > 255)
                    red = 255;
                return true;
            }
            else if(currentCursor == 1)
            {
                this.greenCursor = ((float)p_mouseDragged_1_ - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
                this.greenCursor = MathHelper.clamp(this.greenCursor, 0.0F, 1.0F);

                green = (int)(greenCursor * 255);
                if(green < 0)
                    green = 0;
                else if(green > 255)
                    green = 255;
                return true;
            }
            else if(currentCursor == 2)
            {
                this.blueCursor = ((float)p_mouseDragged_1_ - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
                this.blueCursor = MathHelper.clamp(this.blueCursor, 0.0F, 1.0F);

                blue = (int)(blueCursor * 255);
                if(blue < 0)
                    blue = 0;
                else if(blue > 255)
                    blue = 255;
                return true;
            }
            else
                return false;
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

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(p_keyPressed_1_ == 256 || p_keyPressed_1_ == 69)
        {
            minecraft.displayGuiScreen(previousScreen);
            return true;
        }

        return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
    }

    protected boolean scrollbarClamp(double mouseX, double mouseY)
    {
        int i = this.guiLeft;
        int j = this.guiTop;

        int k_red = i + 60;
        int l_red = j + 18;
        int i1_red = k_red + 128;
        int j1_red = l_red + 16;

        int k_green = i + 60;
        int l_green = j + 42;
        int i1_green = k_green + 128;
        int j1_green = l_green + 16;

        int k_blue = i + 60;
        int l_blue = j + 66;
        int i1_blue = k_blue + 128;
        int j1_blue = l_blue + 16;

        if(mouseX >= (double)k_red && mouseY >= (double)l_red && mouseX < (double)i1_red && mouseY < (double)j1_red)
        {
            currentCursor = 0;
            return true;
        }
        else if(mouseX >= (double)k_green && mouseY >= (double)l_green && mouseX < (double)i1_green && mouseY < (double)j1_green)
        {
            currentCursor = 1;
            return true;
        }
        else if(mouseX >= (double)k_blue && mouseY >= (double)l_blue && mouseX < (double)i1_blue && mouseY < (double)j1_blue)
        {
            currentCursor = 2;
            return true;
        }

        return false;
    }
}
