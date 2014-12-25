package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.ItemSpade;

public class ItemCopperShovel extends ItemSpade {

	public ItemCopperShovel(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("copperShovel");
		setCreativeTab(TeslaCraft.teslaTab);
		setTextureName(References.MOD_ID + ":copperShovel");
	}
}	

