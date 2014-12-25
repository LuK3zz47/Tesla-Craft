package eu.teslacraft.items;

import eu.teslacraft.EnumMetals;
import eu.teslacraft.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemDust extends ItemIngot {

    public ItemDust() {
        super();
        setUnlocalizedName(References.MOD_ID.toLowerCase() + ".dust");
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (EnumMetals metal : EnumMetals.VALID) {
            metal.registerIconDust(iconRegister);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return EnumMetals.VALID[meta].iconDust;
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return getUnlocalizedName() +  EnumMetals.VALID[is.getItemDamage()].name;
    }

}
