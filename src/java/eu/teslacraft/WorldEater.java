package eu.teslacraft;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WorldEater extends Item {

		
	public WorldEater() {
        super();
        setMaxStackSize(1);
        setUnlocalizedName(References.MOD_ID.toLowerCase() + ".worldEater");
        setTextureName(References.MOD_ID + ":worldEater");
        setCreativeTab(TeslaCraft.teslaTab);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        for(int nowX = x - 4; nowX <= x + 4; nowX++){
            for(int nowZ = z - 4; nowZ <= z + 4; nowZ++){
                for(int nowY = y - 4; nowY <= y + 4; nowY++){
                    Block block = world.getBlock(nowX, nowY, nowZ);
                    if(block instanceof BlockStone || block instanceof BlockDirt || block instanceof BlockGrass || block instanceof BlockGravel || block instanceof BlockSand || block instanceof BlockLiquid) {
                        FMLClientHandler.instance().getServer().worldServerForDimension(player.dimension).setBlockToAir(nowX, nowY, nowZ);
                    }
                }
            }
        }
        return true;
    }
}
