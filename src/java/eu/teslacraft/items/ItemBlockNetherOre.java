package eu.teslacraft.items;

import eu.teslacraft.TeslaCraft;
import eu.teslacraft.EnumMetals;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockNetherOre extends ItemBlockOre {

    public ItemBlockNetherOre(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return TeslaCraft.netherOre.getUnlocalizedName() + ".netherOre" + EnumMetals.VALID[is.getItemDamage()].getUnlocalizedName();
    }

}
