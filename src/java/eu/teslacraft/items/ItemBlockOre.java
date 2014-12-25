package eu.teslacraft.items;

import eu.teslacraft.TeslaCraft;
import eu.teslacraft.EnumMetals;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock {

    public ItemBlockOre(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName("teslacraft");
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return TeslaCraft.ore.getUnlocalizedName() + ".ore" + EnumMetals.VALID[is.getItemDamage()].getUnlocalizedName();
    }
}
