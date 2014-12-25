package eu.teslacraft.blocks;

import eu.teslacraft.EnumMetals;
import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockOre extends Block {

    public BlockOre() {
        super(Material.rock);
        setBlockName(References.MOD_ID.toLowerCase() + ".ore");
        setHardness(3.0F);
        setResistance(3.0F);
        setCreativeTab(TeslaCraft.teslaTab);
        setHarvestLevel("pickaxe", 1);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return EnumMetals.VALID[meta].iconOre;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (EnumMetals ore : EnumMetals.VALID) {
            ore.registerIconOre(iconRegister);
        }
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < EnumMetals.VALID.length; i++) {
            list.add(EnumMetals.VALID[i].getIS(this, 1));
        }
    }
}
