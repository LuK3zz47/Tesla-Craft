package eu.teslacraft.items.tools;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCopperSword extends ItemSword {

	public ItemCopperSword(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("copperSword");
		setCreativeTab(TeslaCraft.teslaTab);
		setTextureName(References.MOD_ID + ":copperSword");
	}

}
