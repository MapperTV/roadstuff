package net.killermapper.roadstuff.client.render;

import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.tiles.TileEntityBoundingBlock;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.killermapper.roadstuff.common.trafficLigth.TrafficLigthParameters;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TESRTrafficLigth extends TileEntitySpecialRenderer {

	public static ModelTrafficLigth MODEL = new ModelTrafficLigth();
	public static final ResourceLocation TEXTURE = new ResourceLocation(RoadStuff.MODID, "textures/blocks/asphalt/asphaltBase.png");
	public static final ResourceLocation GREEN = new ResourceLocation(RoadStuff.MODID, "textures/colors/green.jpg");
	public static final ResourceLocation ORANGE = new ResourceLocation(RoadStuff.MODID, "textures/colors/orange.jpg");
	public static final ResourceLocation RED = new ResourceLocation(RoadStuff.MODID, "textures/colors/red.jpg");


	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float prt) {
		if(tile instanceof TileEntityTrafficLigth)
		{
			TileEntityTrafficLigth t = (TileEntityTrafficLigth)tile;
			GL11.glPushMatrix();
			GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(90.0F * (t.getDirection() - 1), 0.0F, 1.0F, 0.0F);

			this.bindTexture(TEXTURE);
			MODEL.renderStructure();
			if(t.isStarted())
			{
				if(t.getState() == TrafficLigthParameters.GREEN)
				{
					MODEL.middleLigth.render(0.0625F);
					MODEL.topLigth.render(0.0625F);
					this.bindTexture(GREEN);
					MODEL.bottomLigth.render(0.0625F);
				}
				else if(t.getState() == TrafficLigthParameters.ORANGE)
				{
					MODEL.topLigth.render(0.0625F);
					MODEL.bottomLigth.render(0.0625F);
					this.bindTexture(ORANGE);
					MODEL.middleLigth.render(0.0625F);
				}
				else if(t.getState() == TrafficLigthParameters.RED)
				{
					MODEL.bottomLigth.render(0.0625F);
					MODEL.middleLigth.render(0.0625F);
					this.bindTexture(RED);
					MODEL.topLigth.render(0.0625F);
				}
			}
			else 
			{
				MODEL.renderAll(0.0625F);
			}
			GL11.glPopMatrix();
		}
		else if(tile instanceof TileEntityBoundingBlock)
		{
			for(int i = 1; i < 5; i++)
			{
				if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord - i, tile.zCoord) instanceof TileEntityTrafficLigth)
				{
					this.renderTileEntityAt(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord - i, tile.zCoord), x, y - i, z, prt);
				}
			}
		}
	}

	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -0.2F, 0.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScaled(0.3D, 0.3D, 0.3D);
		this.bindTexture(TEXTURE);
		MODEL.renderAll(0.0625F);
		GL11.glPopMatrix();
	}

}
