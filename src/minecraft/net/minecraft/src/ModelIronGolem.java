package net.minecraft.src;

public class ModelIronGolem extends ModelBase
{
    /** The head model for the iron golem. */
    public ModelRenderer ironGolemHead;

    /** The body model for the iron golem. */
    public ModelRenderer ironGolemBody;

    /** The right arm model for the iron golem. */
    public ModelRenderer ironGolemRightArm;

    /** The left arm model for the iron golem. */
    public ModelRenderer ironGolemLeftArm;
    public ModelRenderer field_78175_e;
    public ModelRenderer field_78173_f;

    public ModelIronGolem()
    {
        this(0.0F);
    }

    public ModelIronGolem(float par1)
    {
        this(par1, -7.0F);
    }

    public ModelIronGolem(float par1, float par2)
    {
        short var3 = 128;
        short var4 = 128;
        this.ironGolemHead = (new ModelRenderer(this)).setTextureSize(var3, var4);
        this.ironGolemHead.setRotationPoint(0.0F, 0.0F + par2, -2.0F);
        this.ironGolemHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, par1);
        this.ironGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, par1);
        this.ironGolemBody = (new ModelRenderer(this)).setTextureSize(var3, var4);
        this.ironGolemBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.ironGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, par1);
        this.ironGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, par1 + 0.5F);
        this.ironGolemRightArm = (new ModelRenderer(this)).setTextureSize(var3, var4);
        this.ironGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, par1);
        this.ironGolemLeftArm = (new ModelRenderer(this)).setTextureSize(var3, var4);
        this.ironGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, par1);
        this.field_78175_e = (new ModelRenderer(this, 0, 22)).setTextureSize(var3, var4);
        this.field_78175_e.setRotationPoint(-4.0F, 18.0F + par2, 0.0F);
        this.field_78175_e.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, par1);
        this.field_78173_f = (new ModelRenderer(this, 0, 22)).setTextureSize(var3, var4);
        this.field_78173_f.mirror = true;
        this.field_78173_f.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + par2, 0.0F);
        this.field_78173_f.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, par1);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7);
        this.ironGolemHead.render(par7);
        this.ironGolemBody.render(par7);
        this.field_78175_e.render(par7);
        this.field_78173_f.render(par7);
        this.ironGolemRightArm.render(par7);
        this.ironGolemLeftArm.render(par7);
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        this.ironGolemHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.ironGolemHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.field_78175_e.rotateAngleX = -1.5F * this.func_78172_a(par1, 13.0F) * par2;
        this.field_78173_f.rotateAngleX = 1.5F * this.func_78172_a(par1, 13.0F) * par2;
        this.field_78175_e.rotateAngleY = 0.0F;
        this.field_78173_f.rotateAngleY = 0.0F;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        EntityIronGolem var5 = (EntityIronGolem)par1EntityLiving;
        int var6 = var5.getAttackTimer();

        if (var6 > 0)
        {
            this.ironGolemRightArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)var6 - par4, 10.0F);
            this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)var6 - par4, 10.0F);
        }
        else
        {
            int var7 = var5.getHoldRoseTick();

            if (var7 > 0)
            {
                this.ironGolemRightArm.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)var7, 70.0F);
                this.ironGolemLeftArm.rotateAngleX = 0.0F;
            }
            else
            {
                this.ironGolemRightArm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
                this.ironGolemLeftArm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
            }
        }
    }

    private float func_78172_a(float par1, float par2)
    {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }
}
