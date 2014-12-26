package eu.teslacraft.items.tools;

import eu.teslacraft.TeslaCraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Lukin on 25.12.2014.
 */
public class ItemWindmill extends Item {

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float z2, float y2) {
        if (!world.isRemote) {
                if(side==3)
                    world.setBlock(x, y, z+1, TeslaCraft.blockWindmill);
                if(side==4)
                    world.setBlock(x-1, y, z, TeslaCraft.blockWindmill);
                if(side==5)
                    world.setBlock(x+1, y, z, TeslaCraft.blockWindmill);
                if(side==2)
                    world.setBlock(x, y, z-1, TeslaCraft.blockWindmill);
                if(side==1)
                    world.setBlock(x, y+1, z, TeslaCraft.blockWindmill);
            return true;
        }
        return false;
    }
}


