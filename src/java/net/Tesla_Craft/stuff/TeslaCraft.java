package net.Tesla_Craft.stuff;

import net.Tesla_Craft.stuff.items.ItemCopperArmor;
import net.Tesla_Craft.stuff.items.ItemCopperAxe;
import net.Tesla_Craft.stuff.items.ItemCopperHoe;
import net.Tesla_Craft.stuff.items.ItemCopperLeggings;
import net.Tesla_Craft.stuff.items.ItemCopperPickaxe;
import net.Tesla_Craft.stuff.items.ItemCopperShovel;
import net.Tesla_Craft.stuff.items.ItemCopperSword;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.client.main.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid = TeslaCraft.modid, name = "TeslaCraft", version = "0.0.1")
public class TeslaCraft 
{
	public static final String modid = "TeslaCraft";
	
	static final String TEXTURE = "ores:";

	public static CreativeTabs scratchTab = new CreativeTabs("TeslaCraft")
	{

		@Override
		public Item getTabIconItem() {
			return logo;
		}
		
	};
	
	static Block copperOre = new BlockOre(),
								 tinOre = new BlockOre(),
								 copperBlock = new BlockOre(),
								 tinBlock = new BlockOre(),
								 aluminiumOre = new BlockOre(),
								 aluminiumBlock = new BlockOre(),
								 copperOre_Nether = new BlockOre(),
								 tinOre_Nether = new BlockOre(),
								 aluminiumOre_Nether = new BlockOre();
	
	
	static Item copperIngot = new Item(),
								  tinIngot = new Item(),
								  copperNugget = new Item(),
								  tinNugget = new Item(),
								  aluminiumIngot = new Item(),
								  aluminiumNugget = new Item(),
								  logo = new Item();

	public static Item CopperPickaxe;
	public static Item CopperAxe;
	public static Item CopperShovel;
	public static Item CopperHoe;
	public static Item CopperSword;
	
	public static Item CopperHelmet;
	public static Item CopperChestplate;
	public static Item CopperLeggings;
	public static Item CopperBoots;
	
    private Item worldEater;
	
	public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("copperToolMaterial", 5, 199, 5.0F, 1.0F, 30);
	public static final ItemArmor.ArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmorMaterial", 5000, new int[]{1,1,1,1}, 30);
	
	public static void initializeBlocks()
	{
		copperOre.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreCopper").setBlockName("oreCopper").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		tinOre.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreTin").setBlockName("oreTin").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		copperBlock.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("blockCopper").setBlockName("blockCopper").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		tinBlock.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("blockTin").setBlockName("blockTin").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		aluminiumOre.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreAluminium").setBlockName("oreAluminium").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		aluminiumBlock.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("blockAluminium").setBlockName("blockAluminium").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		copperOre_Nether.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreCopper_nether").setBlockName("oreCopper_nether").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		tinOre_Nether.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreTin_nether").setBlockName("oreTin_nether").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);
		aluminiumOre_Nether.setHardness(3.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("oreAluminium_nether").setBlockName("oreAluminium_nether").setCreativeTab(scratchTab).setHarvestLevel("pickaxe",1);

	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(copperOre, "oreCopper");
		GameRegistry.registerBlock(tinOre, "oreTin");	
		GameRegistry.registerBlock(copperBlock, "blockCopper");
		GameRegistry.registerBlock(tinBlock, "blockTin");
		GameRegistry.registerBlock(aluminiumOre, "oreAluminium");
		GameRegistry.registerBlock(aluminiumBlock, "blockAluminium");
		GameRegistry.registerBlock(copperOre_Nether, "copperOre_nether");
		GameRegistry.registerBlock(tinOre_Nether, "tinOre_Nether");
		GameRegistry.registerBlock(aluminiumOre_Nether, "aluminiumOre_Nether");
	}
	
	public static void initializeItems()
	{
		copperIngot.setUnlocalizedName("ingotCopper").setCreativeTab(scratchTab).setTextureName("ingotCopper");
		tinIngot.setUnlocalizedName("ingotTin").setCreativeTab(scratchTab).setTextureName("ingotTin");
		copperNugget.setUnlocalizedName("nuggetCopper").setCreativeTab(scratchTab).setTextureName("nuggetCopper");
		tinNugget.setUnlocalizedName("nuggetTin").setCreativeTab(scratchTab).setTextureName("nuggetTin");
		aluminiumIngot.setUnlocalizedName("ingotAluminium").setCreativeTab(scratchTab).setTextureName("ingotAluminium");
		aluminiumNugget.setUnlocalizedName("nuggetAluminium").setCreativeTab(scratchTab).setTextureName("nuggetAluminium");
		logo.setUnlocalizedName("logo").setCreativeTab(scratchTab).setTextureName("logo");
	}
	
	public static void registerItems()
	{
		GameRegistry.registerItem(copperIngot, "Copper Ingot");
		GameRegistry.registerItem(tinIngot, "Tin Ingot");
		GameRegistry.registerItem(tinNugget, "Tin Nugget");
		GameRegistry.registerItem(copperNugget, "Copper Nugget");
		GameRegistry.registerItem(aluminiumIngot, "Aluminium Ingot");
		GameRegistry.registerItem(aluminiumNugget, "Aluminium Nugget");
		GameRegistry.registerItem(logo, "logo");
	}
	
	public static void registerSmelts()
	{
		GameRegistry.addSmelting(copperOre, new ItemStack(copperIngot), 3.0F);
		GameRegistry.addSmelting(tinOre, new ItemStack(tinIngot), 3.0F);
		GameRegistry.addSmelting(aluminiumOre, new ItemStack(aluminiumIngot), 3.0F);
	}
	
	public static void registerOreDict()
	{
		OreDictionary.registerOre("oreCopper", copperOre);
		OreDictionary.registerOre("oreTin", tinOre);
		OreDictionary.registerOre("oreAluminium", aluminiumOre);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		initializeBlocks();
		registerBlocks();
		initializeItems();
		registerItems();
		registerSmelts();
		registerOreDict();
		GameRegistry.registerWorldGenerator(new CopperGenerator(), 1);
		GameRegistry.registerWorldGenerator(new TinGenerator(), 1);
		
		CopperPickaxe = new ItemCopperPickaxe(copperToolMaterial).setUnlocalizedName("copperPick").setTextureName("copperPick").setCreativeTab(scratchTab);
		CopperAxe = new ItemCopperAxe(copperToolMaterial).setUnlocalizedName("copperAxe").setTextureName("copperAxe").setCreativeTab(scratchTab);
		CopperShovel = new ItemCopperShovel(copperToolMaterial).setUnlocalizedName("copperShov").setTextureName("copperShovel").setCreativeTab(scratchTab);
		CopperHoe = new ItemCopperHoe(copperToolMaterial).setUnlocalizedName("copperHoe").setTextureName("copperHoe").setCreativeTab(scratchTab);
		CopperSword = new ItemCopperSword(copperToolMaterial).setUnlocalizedName("copperSword").setTextureName("copperSword").setCreativeTab(scratchTab);
		
		GameRegistry.registerItem(CopperPickaxe,"copperPick");
		GameRegistry.registerItem(CopperAxe,"copperAxe");
		GameRegistry.registerItem(CopperShovel,"copperShovel");
		GameRegistry.registerItem(CopperHoe,"copperHoe");
		GameRegistry.registerItem(CopperSword,"copperSword");
		
		CopperHelmet = new ItemCopperArmor(copperArmorMaterial, 0, 0).setUnlocalizedName("copperHelmet").setTextureName("copperHelmet").setCreativeTab(scratchTab);;
		CopperChestplate = new ItemCopperArmor(copperArmorMaterial, 0, 1).setUnlocalizedName("copperChestplate").setTextureName("copperChestplate").setCreativeTab(scratchTab);;
		CopperLeggings = new ItemCopperArmor(copperArmorMaterial, 0, 2).setUnlocalizedName("copperLeggings").setTextureName("copperLeggings").setCreativeTab(scratchTab);;
		CopperBoots = new ItemCopperArmor(copperArmorMaterial, 0, 3).setUnlocalizedName("copperBoots").setTextureName("copperBoots").setCreativeTab(scratchTab);;
	
		GameRegistry.registerItem(CopperHelmet, "copperHelmet");
		GameRegistry.registerItem(CopperChestplate, "copperChestplate");
		GameRegistry.registerItem(CopperLeggings, "copperLeggings");
		GameRegistry.registerItem(CopperBoots, "copperBoots");
	
	
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		GameRegistry.addRecipe(new ItemStack(copperBlock), new Object[]{"CCC","CCC","CCC", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{"C  ","   ","   ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{" C ","   ","   ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{"   ","C  ","   ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{"   "," C ","   ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{"   ","   ","C  ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperNugget, 8), new Object[]{"   ","   "," C ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{"C  ","   ","   ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{" C ","   ","   ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{"   ","C  ","   ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{"   "," C ","   ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{"   ","   ","C  ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot, 9), new Object[]{"   ","   "," C ", 'C', copperBlock});
		GameRegistry.addRecipe(new ItemStack(copperIngot), new Object[]{"CCC","CCC","CCC", 'C', copperNugget});
		GameRegistry.addRecipe(new ItemStack(tinBlock), new Object[]{"TTT","TTT","TTT", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{"T  ","   ","   ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{" T ","   ","   ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{"   ","T  ","   ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{"   "," T ","   ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{"   ","   ","T  ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinNugget, 8), new Object[]{"   ","   "," T ", 'T', tinIngot});
		GameRegistry.addRecipe(new ItemStack(tinIngot), new Object[]{"TTT","TTT","TTT", 'T',  tinNugget});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{"T  ","   ","   ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{" T ","   ","   ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{"   ","T  ","   ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{"   "," T ","   ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{"   ","   ","T  ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(tinIngot, 9), new Object[]{"   ","   "," T ", 'T',  tinBlock});
		GameRegistry.addRecipe(new ItemStack(CopperPickaxe), new Object[]{"CCC"," S "," S ", 'C', copperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(CopperShovel), new Object[]{" C "," S "," S ", 'C', copperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(CopperAxe), new Object[]{"CC ","CS "," S ", 'C', copperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(CopperHoe), new Object[]{"CC "," S "," S ", 'C', copperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(CopperSword), new Object[]{" C "," C "," S ", 'C', copperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(aluminiumBlock), new Object []{"AAA","AAA","AAA", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{"A  ","   ","   ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{" A ","   ","   ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{"   ","A  ","   ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{"   "," A ","   ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{"   ","   ","A  ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumNugget, 8), new Object []{"   ","   "," A ", 'A', aluminiumIngot});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{"A  ","   ","   ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{" A ","   ","   ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{"   ","A  ","   ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{"   "," A ","   ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{"   ","   ","A  ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot, 9), new Object []{"   ","   "," A ", 'A', aluminiumBlock});
		GameRegistry.addRecipe(new ItemStack(aluminiumIngot), new Object []{"AAA","AAA","AAA", 'A', aluminiumNugget});
		GameRegistry.addRecipe(new ItemStack(CopperHelmet), new Object[]{"CCC","C C","   ", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(CopperHelmet), new Object[]{"   ","CCC","C C", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(CopperChestplate), new Object[]{"C C","CCC","CCC", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(CopperLeggings), new Object[]{"CCC","C C","C C", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(CopperBoots), new Object[]{"   ","C C","C C", 'C', copperIngot});
		GameRegistry.addRecipe(new ItemStack(CopperBoots), new Object[]{"C C","C C","   ", 'C', copperIngot});
	}
	

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@EventHandler
    public void load(FMLPreInitializationEvent event) {
        worldEater = new WorldEater();
        GameRegistry.registerItem(worldEater, "itemWorldEater");
	}
}
