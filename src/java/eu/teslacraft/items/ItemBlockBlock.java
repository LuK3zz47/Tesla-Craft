package eu.teslacraft.items;

import eu.teslacraft.TeslaCraft;
import eu.teslacraft.EnumMetals;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Buk on 24/12/2014.
 */
public class ItemBlockBlock extends ItemBlock {

    public ItemBlockBlock(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return TeslaCraft.block.getUnlocalizedName() + ".block" + EnumMetals.VALID[is.getItemDamage()].getUnlocalizedName();
    }

}
