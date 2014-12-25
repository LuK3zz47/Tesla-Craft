package eu.teslacraft.items;

import eu.teslacraft.EnumMetals;
import eu.teslacraft.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemNugget extends ItemIngot {

    public ItemNugget() {
        super();
        setUnlocalizedName(References.MOD_ID.toLowerCase() + ".nugget");
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (EnumMetals metal : EnumMetals.VALID) {
            metal.registerIconNugget(iconRegister);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return EnumMetals.VALID[meta].iconNugget;
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return getUnlocalizedName() + EnumMetals.VALID[is.getItemDamage()].name;
    }

}
