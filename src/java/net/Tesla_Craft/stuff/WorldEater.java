package net.Tesla_Craft.stuff;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.Tesla_Craft.stuff.*;

public class WorldEater extends Item {

		
	public WorldEater() {
        super();
        setMaxStackSize(1);
        setUnlocalizedName("chunkEater");
        setTextureName("chunkEater");
        setCreativeTab(TeslaCraft.scratchTab);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        System.out.println(world.getBlock(x, y, z).toString());
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
