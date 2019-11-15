package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.inventory.container.SignWorkshopContainer;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.network.TrafficSignPacket;

public class SignWorkshopScreen extends ContainerScreen<SignWorkshopContainer> implements IContainerListener
{
    private ResourceLocation GUI = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign_workshop.png");
    private ResourceLocation GUI_TABS = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign_workshop_tabs.png");

    // GUI actual size
    private static final int WIDTH = 180;
    private static final int HEIGHT = 220;

    // GUI variables
    private short currentTab;
    private int shapeRotationTextX;
    private int symbolRotationTextX;
    private boolean rotClockPressed = false;
    private boolean rotCClockPressed = false;

    // Sign parameters

    private int shape = 0;
    private int shapeRotation = 0;
    private int symbol = 0;
    protected Color symbolColor = new Color(0, 0, 0);
    private int symbolRotation = 0;
    private boolean symbolMirror = false;
    protected Color bgColor = new Color(0, 0, 0);
    protected Color borderColor = new Color(0, 0, 0);
    private boolean borderThin = false;
    private int detail = 0;
    protected Color detailColor = new Color(255, 0, 0);

    // private String signText = "";

    // GUI text fields
    // private TextFieldWidget signTextField;

    private int posX;
    private int posY;

    public SignWorkshopScreen(SignWorkshopContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    protected void init()
    {
        super.init();

        guiLeft = this.width / 2 - WIDTH / 2;
        guiTop = this.height / 2 - HEIGHT / 2;

        // this.minecraft.keyboardListener.enableRepeatEvents(true);
        // this.signTextField = new TextFieldWidget(this.font, guiLeft - 30, guiTop + 107, 30, 15, "Test");
        // this.signTextField.setCanLoseFocus(true);
        // this.signTextField.setTextColor(new Color(255, 255, 255).hashCode());
        // this.signTextField.setEnableBackgroundDrawing(true);
        // this.signTextField.setMaxStringLength(3);
        // this.children.add(this.signTextField);
        // this.container.addListener(this);

        this.addButton(new Button(guiLeft + 9, guiTop + 84, 18, 20, "▼", (makeItem) ->
        {
            RSNetwork.ROADSTUFF_CHANNEL.sendToServer(new TrafficSignPacket(shape, shapeRotation, symbol, symbolColor.getRGB(), symbolRotation, symbolMirror, bgColor.getRGB(), borderColor.getRGB(), borderThin, detail, detailColor.getRGB()));

        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        // this.signTextField.render(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);

        this.blit(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);

        // Tabs
        this.blit(guiLeft + 180, guiTop + 18, 180, 112, 20, 66);

        switch(currentTab)
        {
            case 0:
                this.blit(guiLeft + 177, guiTop + 18, 208, 112, 23, 22); // Tab
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 83, guiTop + 16, 0, 0, 90, 112); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);

                // Draw rotation buttons being pressed
                if(rotClockPressed)
                    this.blit(guiLeft + 112, guiTop + 116, 200, 244, 12, 12);
                else if(rotCClockPressed)
                    this.blit(guiLeft + 143, guiTop + 116, 212, 244, 12, 12);

                // Draws hover square above slots
                if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 112)
                {
                    posX = Math.toIntExact(Math.round((mouseX - guiLeft - 11) / 24) * 24) + guiLeft + 12;
                    posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 24) * 24) + guiTop + 17;
                    fill(posX, posY, posX + 22, posY + 22, new Color(255, 255, 255, 128).getRGB());
                }

                // Draws selection box around the selected pattern
                int boxX = shape - (shape / 3) * 3;
                int boxY = shape / 3;

                blit(guiLeft + 82 + boxX * 24, guiTop + 15 + boxY * 24, 180, 182, 26, 26);

                // Draws rotation amount

                if(shapeRotation == 0)
                    shapeRotationTextX = guiLeft + 130;
                else if(shapeRotation == 90)
                    shapeRotationTextX = guiLeft + 127;
                else
                    shapeRotationTextX = guiLeft + 125;

                if(symbolRotation == 0)
                    symbolRotationTextX = guiLeft + 130;
                else if(symbolRotation == 90)
                    symbolRotationTextX = guiLeft + 127;
                else
                    symbolRotationTextX = guiLeft + 125;

                break;
            case 1:
                this.blit(guiLeft + 177, guiTop + 40, 208, 134, 23, 22); // Tab
                // this.blit(guiLeft + 155, guiTop + 16, 237, 113, 18, 108); // Scrollbar
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 83, guiTop + 16, 90, 0, 90, 112); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);

                // Draw rotation buttons being pressed
                if(rotClockPressed)
                    this.blit(guiLeft + 112, guiTop + 116, 200, 244, 12, 12);
                else if(rotCClockPressed)
                    this.blit(guiLeft + 143, guiTop + 116, 212, 244, 12, 12);

                // Draws hover square above slots
                if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 88)
                {
                    posX = Math.toIntExact(Math.round((mouseX - guiLeft - 11) / 18) * 18) + guiLeft + 11;
                    posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 18) * 18) + guiTop + 17;
                    fill(posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
                }

                fill(guiLeft + 120, guiTop + 91, guiLeft + 153, guiTop + 100, symbolColor.getRGB());
                GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

                break;
            case 2:
                this.blit(guiLeft + 177, guiTop + 62, 208, 134, 23, 22); // Tab
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 83, guiTop + 16, 180, 0, 72, 108); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);
                break;
        }

        // Tabs symbols
        this.blit(guiLeft + 182, guiTop + 21, 240, 224, 16, 16);
        this.blit(guiLeft + 182, guiTop + 43, 240, 240, 16, 16);
        this.blit(guiLeft + 182, guiTop + 65, 224, 224, 16, 16);

        if(currentTab == 0)
            this.font.drawStringWithShadow("" + shapeRotation, shapeRotationTextX, guiTop + 118, new Color(255, 255, 255).getRGB());
        if(currentTab == 1)
        {
            String hex = String.format("#%02X%02X%02X", symbolColor.getRed(), symbolColor.getGreen(), symbolColor.getBlue());
            this.font.drawStringWithShadow("Color" + hex, guiLeft + 83, guiTop + 92, new Color(255, 255, 255).getRGB());
            this.font.drawStringWithShadow("Mirror", guiLeft + 83, guiTop + 105, new Color(255, 255, 255).getRGB());
            if(symbolMirror)
                this.font.drawStringWithShadow("x", guiLeft + 146, guiTop + 104, new Color(255, 255, 255).getRGB());
            this.font.drawStringWithShadow("" + symbolRotation, symbolRotationTextX, guiTop + 118, new Color(255, 255, 255).getRGB());

        }

        // DEBUG
        this.font.drawStringWithShadow("Tab: " + currentTab, this.width / 2, this.height - this.height / 26, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Current shape: " + shape, 10, 10, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Current symbol: " + symbol, 10, 25, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("mouse: " + mouseX + ";" + mouseY, 10, 40, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Pos: " + posX + ";" + posY, 10, 55, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Shape rotation: " + shapeRotation, 10, 70, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Symbol rotation: " + symbolRotation, 10, 85, new Color(150, 150, 150).getRGB());

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        // Tab selection
        if(mouseX > guiLeft + WIDTH && mouseX < guiLeft + WIDTH + 20)
        {
            if(mouseY > guiTop + 18 && mouseY < guiTop + 40)
            {
                currentTab = 0;
                return true;
            }
            else if(mouseY > guiTop + 40 && mouseY < guiTop + 62)
            {
                currentTab = 1;
                return true;
            }
            else if(mouseY > guiTop + 62 && mouseY < guiTop + 84)
            {
                currentTab = 2;
                return true;
            }
        }

        switch(currentTab)
        {
            case 0:
                if(button == 0)
                {
                    if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 112)
                    {
                        int choice = (posX - guiLeft - 83) / 22 + ((posY - guiTop - 16) / 22) * 3;
                        if(choice < 12)
                        {
                            shape = choice;
                        }
                        return true;
                    }
                    else if(mouseX > guiLeft + 112 && mouseX < guiLeft + 124 && mouseY > guiTop + 116 && mouseY < guiTop + 128)
                    {
                        rotClockPressed = true;
                        this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                        shapeRotation += 90;
                        if(shapeRotation > 270)
                            shapeRotation = 0;
                    }
                    else if(mouseX > guiLeft + 143 && mouseX < guiLeft + 155 && mouseY > guiTop + 116 && mouseY < guiTop + 128)
                    {
                        rotCClockPressed = true;
                        this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 0.75F));
                        if(shapeRotation == 0)
                            shapeRotation = 270;
                        else
                            shapeRotation -= 90;
                    }
                }
                break;

            case 1:
                if(button == 0)
                {
                    if(mouseX > guiLeft + 120 && mouseX < guiLeft + 153 && mouseY > guiTop + 91 && mouseY < guiTop + 100)
                    {
                        this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                        Minecraft.getInstance().displayGuiScreen(new RGBScreen(this, 0, symbolColor));
                    }
                    else if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 88)
                    {
                        int choice = (posX - guiLeft - 82) / 16 + ((posY - guiTop - 16) / 16) * 4;
                        if(choice < 16)
                        {
                            symbol = choice;
                        }
                        return true;
                    }
                    else if(mouseX > guiLeft + 112 && mouseX < guiLeft + 124 && mouseY > guiTop + 116 && mouseY < guiTop + 128)
                    {
                        rotClockPressed = true;
                        this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                        symbolRotation += 90;
                        if(symbolRotation > 270)
                            symbolRotation = 0;
                    }
                    else if(mouseX > guiLeft + 143 && mouseX < guiLeft + 155 && mouseY > guiTop + 116 && mouseY < guiTop + 128)
                    {
                        rotCClockPressed = true;
                        this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 0.75F));
                        if(symbolRotation == 0)
                            symbolRotation = 270;
                        else
                            symbolRotation -= 90;
                    }
                    else if(mouseX > guiLeft + 142 && mouseX < guiLeft + 154 && mouseY > guiTop + 103 && mouseY < guiTop + 115)
                    {
                        if(symbolMirror)
                        {
                            this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 0.75F));
                            symbolMirror = false;
                        }
                        else
                        {
                            this.minecraft.getSoundHandler().play(SimpleSound.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                            symbolMirror = true;
                        }
                    }
                }
                break;
            case 2:
                break;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int p_mouseReleased_5_)
    {
        if(p_mouseReleased_5_ == 0)
        {
            this.rotClockPressed = false;
            this.rotCClockPressed = false;
        }

        return super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, p_mouseReleased_5_);
    }

    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
    {
        if(p_keyPressed_1_ == 256)
        {
            this.minecraft.player.closeScreen();
        }
        return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
        // return !this.signTextField.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_) && !this.signTextField.func_212955_f() ? super.keyPressed(p_keyPressed_1_, p_keyPressed_2_,
        // p_keyPressed_3_) : true;
    }

    @Override
    public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList)
    {

    }

    @Override
    public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack)
    {

    }

    @Override
    public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue)
    {

    }
}
