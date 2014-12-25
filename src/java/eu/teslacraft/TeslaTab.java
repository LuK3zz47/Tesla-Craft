package eu.teslacraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Buk on 24/12/2014.
 */
public class TeslaTab extends CreativeTabs {

    public TeslaTab(String lable) {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return TeslaCraft.logo;
    }
}
