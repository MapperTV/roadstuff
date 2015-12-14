package net.killermapper.roadstuff.client.gui;

import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.killermapper.roadstuff.common.trafficLigth.PacketTrafficChannel;
import net.killermapper.roadstuff.common.trafficLigth.TrafficLigthParamatersRegister;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.config.GuiCheckBox;

public class GuiTrafficLigth extends GuiScreen {

	private TileEntityTrafficLigth tile;
	private GuiTextField chanID;
	private GuiButton confirmButton;
	private GuiCheckBox isReversed;
	private GuiTextField chanDelay;

	public GuiTrafficLigth(TileEntityTrafficLigth tile)
	{
		this.tile = tile;
	}

	@Override
	public void updateScreen()
	{
		this.chanID.updateCursorCounter();
		this.chanDelay.updateCursorCounter();
	}

	@Override
	public void drawScreen(int width, int heigth, float scale)
	{
		this.chanID.drawTextBox();
		this.chanDelay.drawTextBox();
		this.drawString(this.fontRendererObj, "Channel : ", this.width / 10 - 48, this.height / 10 + 31, Integer.MAX_VALUE);
		this.drawString(this.fontRendererObj, "Delay   : ", this.width / 10 - 48, this.height / 10 + 56, Integer.MAX_VALUE);
		super.drawScreen(width, heigth, scale);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		Keyboard.enableRepeatEvents(true);
		this.chanID = new GuiTextField(this.fontRendererObj, this.width / 10 + 2, this.height / 10 + 25, 196, 20);
		this.chanID.setFocused(true);	
		this.chanID.setText(String.valueOf(this.tile.getChannel()));

		this.chanDelay = new GuiTextField(this.fontRendererObj, this.width / 10 + 2, this.height / 10 + 50, 196, 20);
		this.chanDelay.setFocused(false);
		this.chanDelay.setText(String.valueOf(TrafficLigthParamatersRegister.getDelayFrom(this.tile.getChannel())));

		this.confirmButton = new GuiButton(0, this.width / 10, this.height / 10, "Confirm");
		this.buttonList.add(confirmButton);

		this.isReversed = new GuiCheckBox(1, this.width / 10, this.height / 10 + 75, "Reverse", this.tile.isReversed());
		this.buttonList.add(this.isReversed);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(button.id == 0)
		{
			if(this.chanID.getText() != null && this.chanID.getText() != "")
			{
				if(this.chanDelay.getText() != null && this.chanDelay.getText() != "")
				{
					try {
						int id = Integer.parseInt(this.chanID.getText());
						int delay = Integer.parseInt(this.chanDelay.getText());
						RoadStuff.network.sendToServer(new PacketTrafficChannel(id, tile.xCoord, tile.yCoord, tile.zCoord, this.isReversed.isChecked(), delay));
						this.tile.setChannel(id);
						this.tile.setReversed(this.isReversed.isChecked());
						this.mc.thePlayer.closeScreen();
					} catch (NumberFormatException e) {
						this.chanID.setText(String.valueOf(this.tile.getChannel()));
						this.chanDelay.setText(String.valueOf(TrafficLigthParamatersRegister.getDelayFrom(this.tile.getChannel())));
					}
				}
			}
		}
	}

	protected void keyTyped(char caractere, int key)
	{
		if(key == 1) this.mc.thePlayer.closeScreen();
		this.chanID.textboxKeyTyped(caractere, key);
		this.chanDelay.textboxKeyTyped(caractere, key);
	}

	protected void mouseClicked(int x, int y, int state)
	{
		super.mouseClicked(x, y, state);
		this.chanID.mouseClicked(x, y, state);
		this.chanDelay.mouseClicked(x, y, state);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
