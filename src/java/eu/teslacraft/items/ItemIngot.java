package eu.teslacraft.items;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import eu.teslacraft.EnumMetals;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemIngot extends Item {

    public ItemIngot() {
        super();
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName(References.MOD_ID.toLowerCase() + ".ingot");
        setCreativeTab(TeslaCraft.teslaTab);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (EnumMetals metal : EnumMetals.VALID) {
            metal.registerIconIngot(iconRegister);
        }
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return EnumMetals.VALID[meta].iconIngot;
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return getUnlocalizedName() + EnumMetals.VALID[is.getItemDamage()].getUnlocalizedName();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < EnumMetals.VALID.length; i++) {
            list.add(EnumMetals.VALID[i].getItemIS(this, 1));
        }
    }

}
