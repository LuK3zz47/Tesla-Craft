package eu.teslacraft.blocks;

import eu.teslacraft.TeslaCraft;
import eu.teslacraft.items.TileEntityWindmill;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Lukin on 25.12.2014.
 */
public class BlockWindmill extends BlockContainer {

    public  BlockWindmill(Material material){
        super(material);
        setCreativeTab(TeslaCraft.teslaTab);
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return  false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    public TileEntity createNewTileEntity(World var1, int var2){
        return new TileEntityWindmill();
    }
}
