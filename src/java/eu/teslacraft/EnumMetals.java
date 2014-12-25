package eu.teslacraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eu.teslacraft.blocks.BlockOre;
import eu.teslacraft.items.ItemIngot;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public enum EnumMetals {
    COPPER("Copper"),
    ALUMINIUM("Aluminium"),
    TIN("Tin"),
    LEAD("Lead");

    public static final EnumMetals[] VALID = values();

    public final String name;
    public final int meta = this.ordinal();
    public IIcon iconOre, iconNetherOre, iconBlock, iconIngot, iconDust, iconNugget;

    private EnumMetals(String name) {
        this.name = name;
    }

    public String getUnlocalizedName() {
        return name;
    }

    public ItemStack getIS(BlockOre block, int amount) {
        return new ItemStack(block, amount, meta);
    }

    public ItemStack getItemIS(ItemIngot item, int amount) {
        return new ItemStack(item, amount, meta);
    }

    @SideOnly(Side.CLIENT)
    public void registerIconOre(IIconRegister ir) {
        iconOre = ir.registerIcon(References.MOD_ID + ":ore" + name);
    }

    @SideOnly(Side.CLIENT)
    public void registerIconNetherOre(IIconRegister ir) {
        iconNetherOre = ir.registerIcon(References.MOD_ID + ":netherOre" + name);
    }

    @SideOnly(Side.CLIENT)
    public void registerIconBlock(IIconRegister ir) {
        iconBlock = ir.registerIcon(References.MOD_ID + ":block" + name);
    }

    @SideOnly(Side.CLIENT)
    public void registerIconIngot(IIconRegister ir) {
        iconIngot = ir.registerIcon(References.MOD_ID + ":ingot" + name);
    }

    public void registerIconDust(IIconRegister ir) {
        iconDust = ir.registerIcon(References.MOD_ID + ":dust" + name);
    }

    public void registerIconNugget(IIconRegister ir) {
        iconNugget = ir.registerIcon(References.MOD_ID + ":nugget" + name);
    }
}
