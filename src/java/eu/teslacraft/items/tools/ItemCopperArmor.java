package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCopperArmor extends ItemArmor {

	public ItemCopperArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) 
	{
		super(armorMaterial, renderIndex, armorType);
		setUnlocalizedName("armorCopper");
		setCreativeTab(TeslaCraft.teslaTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(TeslaCraft.copperHelmet)|| stack.getItem().equals(TeslaCraft.copperChestplate)|| stack.getItem().equals(TeslaCraft.copperBoots)){
			return References.MOD_ID + ":textures/armor/armorCopper_l1.png";
		}
		if(stack.getItem().equals(TeslaCraft.copperLeggings)){
			return References.MOD_ID + ":textures/armor/armorCopper_l2.png";
		}
		return null;
	}
	@Override
	public void registerIcons(IIconRegister reg){
		if(this == TeslaCraft.copperHelmet) this.itemIcon = reg.registerIcon(References.MOD_ID + ":copperHelmet");
		if(this == TeslaCraft.copperChestplate) this.itemIcon = reg.registerIcon(References.MOD_ID + ":copperChestplate");
		if(this == TeslaCraft.copperLeggings) this.itemIcon = reg.registerIcon(References.MOD_ID + ":copperLeggings");
		if(this == TeslaCraft.copperBoots) this.itemIcon = reg.registerIcon(References.MOD_ID + ":copperBoots");
	}
}