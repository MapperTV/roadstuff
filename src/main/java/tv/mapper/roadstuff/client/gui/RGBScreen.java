package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import tv.mapper.roadstuff.RoadStuff;

public class RGBScreen extends Screen
{
    private GuiSignWorkshop previousScreen;

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

    private int redCursor = 0;
    private int greenCursor = 0;
    private int blueCursor = 0;

    private Button redPlus;
    private Button redMinus;
    private Button greenPlus;
    private Button greenMinus;
    private Button bluePlus;
    private Button blueMinus;

    protected RGBScreen(GuiSignWorkshop previousScreen)
    {
        super(title);
        this.previousScreen = previousScreen;
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

        this.addButton(new Button(guiLeft + 43, guiTop + 17, 20, 20, "-", (redMinus) ->
        {
            if(red > 0)
                red--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 17, 20, 20, "+", (redPlus) ->
        {
            if(red < 255)
                red++;
        }));
        this.addButton(new Button(guiLeft + 43, guiTop + 39, 20, 20, "-", (greenMinus) ->
        {
            if(green > 0)
                green--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 39, 20, 20, "+", (greenPlus) ->
        {
            if(green < 255)
                green++;
        }));
        this.addButton(new Button(guiLeft + 43, guiTop + 61, 20, 20, "-", (blueMinus) ->
        {
            if(blue > 0)
                blue--;
        }));
        this.addButton(new Button(guiLeft + 200, guiTop + 61, 20, 20, "+", (bluePlus) ->
        {
            if(blue < 255)
                blue++;
        }));

    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(RGB_SCREEN);

        this.blit(guiLeft, guiTop, 0, 160, WIDTH, HEIGHT);

        this.font.drawStringWithShadow("Select color:", 30, 80, new Color(255, 255, 255).getRGB());
        
        this.font.drawStringWithShadow("R:" + red, guiLeft + 11, guiTop + 23, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("G:" + green, guiLeft + 11, guiTop + 45, new Color(255, 255, 255).getRGB());
        this.font.drawStringWithShadow("B:" + blue, guiLeft + 11, guiTop + 67, new Color(255, 255, 255).getRGB());

        RGB = new Color(red, green, blue);
        fill(30, 190, 60, 205, RGB.getRGB());

        super.render(mouseX, mouseY, partialTicks);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 1 && mouseX > 30 && mouseX < 60 && mouseY > 190 && mouseY < 205)
        {

        }
        return super.mouseClicked(mouseX, mouseY, button);
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
}
