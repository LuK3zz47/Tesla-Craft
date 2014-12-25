package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemCopperHoe extends ItemHoe {

	public ItemCopperHoe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("copperHoe");
		setCreativeTab(TeslaCraft.teslaTab);
		setTextureName(References.MOD_ID + ":copperHoe");
	}

}
