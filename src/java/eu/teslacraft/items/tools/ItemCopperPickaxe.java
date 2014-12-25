package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemCopperPickaxe extends ItemPickaxe {

	public ItemCopperPickaxe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("copperPick");
		setCreativeTab(TeslaCraft.teslaTab);
		setTextureName(References.MOD_ID + ":copperPick");
	}

}
