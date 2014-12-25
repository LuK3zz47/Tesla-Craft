package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.ItemAxe;

public class ItemCopperAxe extends ItemAxe {

	public ItemCopperAxe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("copperAxe");
		setCreativeTab(TeslaCraft.teslaTab);
		setTextureName(References.MOD_ID + ":copperAxe");
	}

}
