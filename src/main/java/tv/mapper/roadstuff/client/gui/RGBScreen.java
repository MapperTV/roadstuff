package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import tv.mapper.roadstuff.RoadStuff;

public class RGBScreen extends Screen
{
    private GuiSignWorkshop previousScreen;

    private static final int WIDTH = 180;
    private static final int HEIGHT = 216;

    private int guiLeft;
    private int guiTop;

    private Color RGB = new Color(0, 0, 0);
    public static final ITextComponent title = new StringTextComponent("Color Picker");
    private ResourceLocation RGB_SCREEN = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign_workshop_tabs.png");

    private TextFieldWidget redAmount, greenAmount, blueAmount;

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

        this.minecraft.keyboardListener.enableRepeatEvents(true);

        this.redAmount = new TextFieldWidget(this.font, 30, 100, 30, 15, "");
        this.redAmount.setCanLoseFocus(true);
        this.redAmount.setTextColor(new Color(255, 255, 255).hashCode());
        this.redAmount.setEnableBackgroundDrawing(true);
        this.redAmount.setMaxStringLength(3);
        this.children.add(this.redAmount);

        this.greenAmount = new TextFieldWidget(this.font, 30, 130, 30, 15, "");
        this.greenAmount.setCanLoseFocus(true);
        this.greenAmount.setTextColor(new Color(255, 255, 255).hashCode());
        this.greenAmount.setEnableBackgroundDrawing(true);
        this.greenAmount.setMaxStringLength(3);
        this.children.add(this.greenAmount);

        this.blueAmount = new TextFieldWidget(this.font, 30, 160, 30, 15, "");
        this.blueAmount.setCanLoseFocus(true);
        this.blueAmount.setTextColor(new Color(255, 255, 255).hashCode());
        this.blueAmount.setEnableBackgroundDrawing(true);
        this.blueAmount.setMaxStringLength(3);
        this.children.add(this.blueAmount);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(RGB_SCREEN);

        this.blit(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);

        this.redAmount.render(mouseX, mouseY, partialTicks);
        this.greenAmount.render(mouseX, mouseY, partialTicks);
        this.blueAmount.render(mouseX, mouseY, partialTicks);

        this.font.drawStringWithShadow("Select color:", 30, 80, new Color(255, 255, 255).getRGB());

        fill(30, 190, 60, 205, RGB.getRGB());

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(button == 1 && mouseX > 30 && mouseX < 60 && mouseY > 190 && mouseY < 205)
        {
            try
            {
                int red = Integer.parseInt(redAmount.getText());
                int green = Integer.parseInt(greenAmount.getText());
                int blue = Integer.parseInt(blueAmount.getText());

                if(red >= 0 && red < 256 && green >= 0 && green < 256 && blue >= 0 && blue < 256)
                    RGB = new Color(red, green, blue);
            }
            catch(NumberFormatException e)
            {
                // NO OP
                System.out.println("not a number");
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(p_keyPressed_1_ == 256)
        {
            minecraft.displayGuiScreen(previousScreen);
            return true;
        }
//        else if(p_keyPressed_1_ == 69 && !this.redAmount.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_) && !this.redAmount.func_212955_f() && !this.greenAmount.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_) && !this.greenAmount.func_212955_f() && !this.blueAmount.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_) && !this.blueAmount.func_212955_f())
//        {
//            minecraft.displayGuiScreen(previousScreen);
//            return true;
//        }

        return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
    }
}
