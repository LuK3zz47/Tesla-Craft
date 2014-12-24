package net.Tesla_Craft.stuff.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.Tesla_Craft.stuff.TeslaCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCopperArmor extends ItemArmor {

	public ItemCopperArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) 
	{
		super(armorMaterial, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(TeslaCraft.CopperHelmet)|| stack.getItem().equals(TeslaCraft.CopperChestplate)|| stack.getItem().equals(TeslaCraft.CopperBoots)){
	return "armorCopper_l1";
	}
		if(stack.getItem().equals(TeslaCraft.CopperLeggings)){
	return "armorCopper_l2";
	}
	else return null;
	}
	@Override
	public void registerIcons(IIconRegister reg){
		if(this == TeslaCraft.CopperHelmet)
	this.itemIcon = reg.registerIcon("copperHelmet");
		if(this == TeslaCraft.CopperChestplate)
	this.itemIcon = reg.registerIcon("copperChestplate");
		if(this == TeslaCraft.CopperLeggings)
	this.itemIcon = reg.registerIcon("copperLeggings");
		if(this == TeslaCraft.CopperBoots)
	this.itemIcon = reg.registerIcon("copperBoots");
	}
}