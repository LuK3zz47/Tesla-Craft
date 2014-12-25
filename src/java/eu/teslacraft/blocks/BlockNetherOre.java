package eu.teslacraft.blocks;

import eu.teslacraft.EnumMetals;
import eu.teslacraft.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockNetherOre extends BlockOre {

    public BlockNetherOre() {
        super();
        setBlockName(References.MOD_ID.toLowerCase() + ".netherOre");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return EnumMetals.VALID[meta].iconNetherOre;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (EnumMetals ore : EnumMetals.VALID) {
            ore.registerIconNetherOre(iconRegister);
        }
    }
}
