package tv.mapper.roadstuff.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.inventory.container.SignWorkshopContainer;

public class GuiSignWorkshop extends ContainerScreen<SignWorkshopContainer>
{
    private ResourceLocation GUI = new ResourceLocation(RoadStuff.MODID, "textures/gui/sign_workshop.png");

    private static final int WIDTH = 180;
    private static final int HEIGHT = 216;

    private short currentTab;

    public GuiSignWorkshop(SignWorkshopContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        guiLeft = this.width / 2 - WIDTH / 2;
        guiTop = this.height / 2 - HEIGHT / 2;

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);

        this.blit(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);
        this.blit(guiLeft + 180, guiTop + 18, 180, 112, 20, 88);

        switch(currentTab)
        {
            case 0:
                this.blit(guiLeft + 177, guiTop + 18, 208, 112, 23, 22);
                break;
            case 1:
                this.blit(guiLeft + 177, guiTop + 40, 208, 134, 23, 22);
                this.blit(guiLeft + 83, guiTop + 16, 184, 0, 72, 108);
                this.blit(guiLeft + 155 , guiTop + 16, 237, 113, 18, 108);
                break;
            case 2:
                this.blit(guiLeft + 177, guiTop + 62, 208, 134, 23, 22);
                break;
            case 3:
                this.blit(guiLeft + 177, guiTop + 84, 208, 156, 23, 22);
                break;
        }

        this.font.drawStringWithShadow("Tab: " + currentTab, this.width / 2, this.height - this.height / 26, new Color(150, 150, 150).getRGB());
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
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

        return super.mouseClicked(mouseX, mouseY, button);
    }
}
