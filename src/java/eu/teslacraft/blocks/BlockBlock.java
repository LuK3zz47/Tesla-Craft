package eu.teslacraft.blocks;

import eu.teslacraft.EnumMetals;
import eu.teslacraft.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBlock extends BlockOre {

    public BlockBlock() {
        super();
        setBlockName(References.MOD_ID.toLowerCase() + ".block");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return EnumMetals.VALID[meta].iconBlock;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (EnumMetals ore : EnumMetals.VALID) {
            ore.registerIconBlock(iconRegister);
        }
    }
}
