package eu.teslacraft.items;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.Item;

public class ItemLogo extends Item {

    public ItemLogo() {
        super();
        setUnlocalizedName(References.MOD_ID.toLowerCase() + ".logo");
        setCreativeTab(TeslaCraft.teslaTab);
        setTextureName("teslacraft:logo");
    }
}
