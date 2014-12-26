package eu.teslacraft.blocks;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import eu.teslacraft.TeslaTab;
import eu.teslacraft.tileentity.TileEntityWindmillFloor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by Lukin on 26.12.2014.
 */
public class BlockWindmillground extends BlockContainer {

    public BlockWindmillground(Material material) {
        super(material);

        this.setBlockBounds(0, 0, 0, 1, 0.3F, 1);
        setCreativeTab(TeslaCraft.teslaTab);
        setBlockName("Windmill Ground");
        setBlockTextureName(References.MOD_ID + ":blockWindmillground");
    }

    public int getRenderType(){
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
        updateMultiBlockStructure(world, x, y, z);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        updateMultiBlockStructure(world, x, y, z);
    }

    public void updateMultiBlockStructure(World world, int x, int y, int z) {
        isMultiBlockStructure(world, x, y, z);
    }

    public boolean isMultiBlockStructure(World world, int x1, int y1, int z1) {
        boolean mStructure = false;

        boolean currentCheckStructure = true;

        for (int x2 = 0; x2 < 3; x2++) {
            for (int z2 = 0; z2 < 3; z2++) {
                if (!mStructure) {
                    currentCheckStructure = true;
                    for (int x3 = 0; x3 < 3; x3++) {
                        for (int z3 = 0; z3 < 3; z3++) {
                           /*if(x2 == 1 && z3 ==0){
                               world.setBlock(x1+x2-x3, y1, z1-z3, Blocks.anvil);
                           }
                           */

                            if (currentCheckStructure && !world.getBlock(x1 + x3 - x2, y1, z1 + z2 - z3).equals(TeslaCraft.blockWindmillground)) {
                                currentCheckStructure = false;
                            }
                        }
                    }

                    if (currentCheckStructure) {
                        for (int x3 = 0; x3 < 3; x3++) {
                            for (int z3 = 0; z3 < 3; z3++) {
                                world.setBlockMetadataWithNotify(x1 + x2 - x3, y1, z1 + z2 - z3, x3 * 3 + z3, 2);
                                }
                            }
                        }
                    }
                    mStructure = currentCheckStructure;
                }
            }
          if(mStructure) return true;

        if(world.getBlockMetadata(x1, y1, z1) > 0) world.setBlockMetadataWithNotify(x1, y1, z1, 0, 3);

        return false;
    }

    public TileEntity createNewTileEntity(World var1, int var2){
        return new TileEntityWindmillFloor();
    }
}
