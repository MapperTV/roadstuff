package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
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
    private static final int HEIGHT = 216;

    // GUI variables
    private short currentTab;
    private int shapeRotationTextX;

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

        this.addButton(new Button(guiLeft + 9, guiTop + 80, 18, 20, "▼", (makeItem) ->
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
        this.blit(guiLeft + 180, guiTop + 18, 180, 112, 20, 88);

        switch(currentTab)
        {
            case 0:
                this.blit(guiLeft + 177, guiTop + 18, 208, 112, 23, 22); // Tab
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 83, guiTop + 16, 0, 0, 90, 112); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);

                // Draws hover square above slots
                if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 112)
                {
                    posX = Math.toIntExact(Math.round((mouseX - guiLeft - 11) / 24) * 24) + guiLeft + 12;
                    posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 24) * 24) + guiTop + 17;
                    fill(posX, posY, posX + 22, posY + 22, new Color(255, 255, 255, 128).getRGB());
                }

                // Draws rotation amount

                if(shapeRotation == 0)
                    shapeRotationTextX = guiLeft + 130;
                else if(shapeRotation == 90)
                    shapeRotationTextX = guiLeft + 127;
                else
                    shapeRotationTextX = guiLeft + 124;
                this.font.drawStringWithShadow("" + shapeRotation, shapeRotationTextX, guiTop + 118, new Color(255, 255, 255).getRGB());

                break;
            case 1:
                this.blit(guiLeft + 177, guiTop + 40, 208, 134, 23, 22); // Tab
                this.blit(guiLeft + 155, guiTop + 16, 237, 113, 18, 108); // Scrollbar
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 82, guiTop + 16, 90, 0, 91, 108); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);

                // Draws hover square above slots
                if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16 && mouseY < guiTop + 106)
                {
                    posX = Math.toIntExact(Math.round((mouseX - guiLeft - 11) / 18) * 18) + guiLeft + 12;
                    posY = Math.toIntExact(Math.round((mouseY - guiTop - 17) / 18) * 18) + guiTop + 17;
                    fill(posX, posY, posX + 16, posY + 16, new Color(255, 255, 255, 128).getRGB());
                }

                fill(guiLeft + 83, guiTop + 112, guiLeft + 107, guiTop + 124, new Color(255, 0, 0, 128).getRGB());

                break;
            case 2:
                this.blit(guiLeft + 177, guiTop + 62, 208, 134, 23, 22); // Tab
                this.minecraft.getTextureManager().bindTexture(GUI_TABS);
                this.blit(guiLeft + 83, guiTop + 16, 181, 0, 72, 108); // Grid
                this.minecraft.getTextureManager().bindTexture(GUI);
                break;
            case 3:
                this.blit(guiLeft + 177, guiTop + 84, 208, 156, 23, 22);
                break;
        }

        // Tabs symbols
        this.blit(guiLeft + 182, guiTop + 21, 240, 224, 16, 16);
        this.blit(guiLeft + 182, guiTop + 43, 240, 240, 16, 16);
        this.blit(guiLeft + 182, guiTop + 65, 224, 224, 16, 16);
        this.blit(guiLeft + 182, guiTop + 87, 224, 240, 16, 16);

        // DEBUG
        this.font.drawStringWithShadow("Tab: " + currentTab, this.width / 2, this.height - this.height / 26, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Current shape: " + shape, 10, 10, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Current symbol: " + symbol, 10, 25, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("mouse: " + mouseX + ";" + mouseY, 10, 40, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Pos: " + posX + ";" + posY, 10, 55, new Color(150, 150, 150).getRGB());
        this.font.drawStringWithShadow("Shape rotation: " + shapeRotation, 10, 70, new Color(150, 150, 150).getRGB());

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if(currentTab == 1 && mouseX > guiLeft + 83 && mouseX < guiLeft + 107 && mouseY > guiTop + 112 && mouseY < guiTop + 124)
        {
            if(button == 0)
            {
                Minecraft.getInstance().displayGuiScreen(new RGBScreen(this, 0));
            }
        }

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
            else if(mouseY > guiTop + 84 && mouseY < guiTop + 106)
            {
                currentTab = 3;
                return true;
            }
        }

        else if(mouseX > guiLeft + 83 && mouseX < guiLeft + 155 && mouseY > guiTop + 16)
        {
            if(currentTab == 0 && mouseY < guiTop + 112)
            {
                if(button == 0)
                {
                    int choice = (posX - guiLeft - 83) / 22 + ((posY - guiTop - 16) / 22) * 3;
                    if(choice < 12)
                    {
                        shape = choice;
                    }
                    return true;
                }
            }
            else if(currentTab == 1 && mouseY < guiTop + 106)
            {
                if(button == 0)
                {
                    int choice = (posX - guiLeft - 83) / 16 + ((posY - guiTop - 16) / 16) * 4;
                    if(choice < 20)
                    {
                        symbol = choice;
                    }
                    return true;
                }
            }
        }

        if(mouseX > guiLeft + 112 && mouseX < guiLeft + 124 && mouseY > guiTop + 116 && mouseY < guiTop + 130)
        {
            shapeRotation += 90;
            if(shapeRotation > 270)
                shapeRotation = 0;
        }
        else if(mouseX > guiLeft + 143 && mouseX < guiLeft + 155 && mouseY > guiTop + 116 && mouseY < guiTop + 130)
        {
            if(shapeRotation == 0)
                shapeRotation = 270;
            else
                shapeRotation -= 90;
        }

        return super.mouseClicked(mouseX, mouseY, button);
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
