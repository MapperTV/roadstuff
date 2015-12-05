package net.killermapper.roadstuff.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTrafficLigth extends ModelBase
{
    public ModelRenderer top;
    public ModelRenderer base;
    public ModelRenderer rod;
    public ModelRenderer topLigth;
    public ModelRenderer middleLigth;
    public ModelRenderer bottomLigth;

    public ModelTrafficLigth() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.top = new ModelRenderer(this, 0, 0);
        this.top.mirror = true;
        this.top.addBox(0F, -60F, -7F, 4, 32, 14);
        this.top.setRotationPoint(0F, 10F, 0F);
        this.top.setTextureSize(64, 32);
        setRotation(this.top, 0F, 0F, 0F);

        this.base = new ModelRenderer(this, 0, 19);
        this.base.mirror = true;
        this.base.addBox(-6F, 0F, -6F, 12, 1, 12);
        this.base.setRotationPoint(0F, 23F, 0F);
        this.base.setTextureSize(64, 32);
        setRotation(this.base, 0F, 0F, 0F);

        this.rod = new ModelRenderer(this, 56, 16);
        this.rod.mirror = true;
        this.rod.addBox(-1F, -80F, -1F, 2, 80, 2);
        this.rod.setRotationPoint(0F, 23F, 0F);
        this.rod.setTextureSize(64, 32);
        setRotation(this.rod, 0F, 0F, 0F);
        
        this.topLigth = new ModelRenderer(this, 0, 0);
        this.topLigth.mirror = true;
        this.topLigth.addBox(4F, -58F, -4F, 2, 8, 8);
        this.topLigth.setRotationPoint(0F, 10F, 0F);
        this.topLigth.setTextureSize(64, 32);
        setRotation(this.topLigth, 0F, 0F, 0F);
        
        this.middleLigth = new ModelRenderer(this, 0, 0);
        this.middleLigth.mirror = true;
        this.middleLigth.addBox(4F, -48F, -4F, 2, 8, 8);
        this.middleLigth.setRotationPoint(0F, 10F, 0F);
        this.middleLigth.setTextureSize(64, 32);
        setRotation(this.middleLigth, 0F, 0F, 0F);

        this.bottomLigth = new ModelRenderer(this, 0, 0);
        this.bottomLigth.mirror = true;
        this.bottomLigth.addBox(4F, -38F, -4F, 2, 8, 8);
        this.bottomLigth.setRotationPoint(0F, 10F, 0F);
        this.bottomLigth.setTextureSize(64, 32);
        setRotation(this.bottomLigth, 0F, 0F, 0F);
    }

    public void renderAll() {
        this.top.render(0.0625F);
        this.base.render(0.0625F);
        this.rod.render(0.0625F);
        this.topLigth.render(0.0625F);
        this.middleLigth.render(0.0625F);
        this.bottomLigth.render(0.0625F);
    }
    
    public void renderStructure() {
    	this.top.render(0.0625F);
        this.base.render(0.0625F);
        this.rod.render(0.0625F);
    }

    public static void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
