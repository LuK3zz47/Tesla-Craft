package eu.teslacraft;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import eu.teslacraft.blocks.*;
import eu.teslacraft.items.*;
import eu.teslacraft.items.tools.*;
import eu.teslacraft.proxy.CommonProxy;
import eu.teslacraft.worldgen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;


@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class TeslaCraft {

    @Mod.Instance(References.MOD_ID)
    public static TeslaCraft INSTANCE;

    public static CreativeTabs teslaTab = new TeslaTab("TeslaCraft");

    public static BlockOre ore, netherOre, block;
    public static ItemIngot ingot, dust, nugget;

    public static Item logo;

    public static Item copperPickaxe;
    public static Item copperAxe;
    public static Item copperShovel;
    public static Item copperHoe;
    public static Item copperSword;

    public static Item copperHelmet;
    public static Item copperChestplate;
    public static Item copperLeggings;
    public static Item copperBoots;

    public static Block blockWindmill;
    public static Block blockWindmillground;

    public static Item itemWindmill;

    @SidedProxy(clientSide ="eu.teslacraft.proxy.ClientProxy", serverSide ="eu.teslacraft.proxy.CommonProxy")
    public static CommonProxy proxy;

    private Item worldEater;

    public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("copperToolMaterial", 1, 199, 4.5F, 1.0F, 30);
    public static final ItemArmor.ArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmorMaterial", 5000, new int[]{1, 5, 6, 1}, 30);
    public static OreGenerator copperGenerator, tinGenerator, aluminiumGenerator, leadGenerator;

    public static void initializeBlocks() {
        ore = new BlockOre();
        GameRegistry.registerBlock(ore, ItemBlockOre.class, ore.getUnlocalizedName());

        netherOre = new BlockNetherOre();
        GameRegistry.registerBlock(netherOre, ItemBlockNetherOre.class, netherOre.getUnlocalizedName());

        block = new BlockBlock();
        GameRegistry.registerBlock(block, ItemBlockBlock.class, block.getUnlocalizedName());
    }

    public static void initializeItems() {
        logo = new ItemLogo();
        GameRegistry.registerItem(logo, logo.getUnlocalizedName());

        ingot = new ItemIngot();
        GameRegistry.registerItem(ingot, ingot.getUnlocalizedName());

        dust = new ItemDust();
        GameRegistry.registerItem(dust, dust.getUnlocalizedName());

        nugget = new ItemNugget();
        GameRegistry.registerItem(nugget, nugget.getUnlocalizedName());
    }

    public static void registerSmelts() {
        GameRegistry.addSmelting(EnumMetals.COPPER.getIS(ore, 1), EnumMetals.COPPER.getItemIS(ingot, 1), 3.0F);
        GameRegistry.addSmelting(EnumMetals.TIN.getIS(ore, 1), EnumMetals.TIN.getItemIS(ingot, 1), 3.0F);
        GameRegistry.addSmelting(EnumMetals.ALUMINIUM.getIS(ore, 1), EnumMetals.ALUMINIUM.getItemIS(ingot, 1), 3.0F);
        GameRegistry.addSmelting(EnumMetals.LEAD.getIS(ore, 1), EnumMetals.LEAD.getItemIS(ingot, 1), 3.0F);
    }

    public static void registerOreDict() {
        for(EnumMetals metal : EnumMetals.VALID) {
            OreDictionary.registerOre("ore" + metal.name, EnumMetals.COPPER.getIS(ore, 1));
            OreDictionary.registerOre("netherOre" + metal.name, EnumMetals.COPPER.getIS(netherOre, 1));
            OreDictionary.registerOre("dust" + metal.name, EnumMetals.COPPER.getItemIS(dust, 1));
            OreDictionary.registerOre("block" + metal.name, EnumMetals.COPPER.getIS(block, 1));
        }
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        initializeBlocks();
        initializeItems();
        registerSmelts();
        registerOreDict();

        copperGenerator = new OreGenerator(EnumMetals.COPPER, 0, 60, 5, 4);
        GameRegistry.registerWorldGenerator(copperGenerator, 1);

        tinGenerator = new OreGenerator(EnumMetals.TIN, 0, 60, 5, 4);
        GameRegistry.registerWorldGenerator(tinGenerator, 1);

        aluminiumGenerator = new OreGenerator(EnumMetals.ALUMINIUM, 0, 60, 5, 4);
        GameRegistry.registerWorldGenerator(aluminiumGenerator, 1);

        leadGenerator = new OreGenerator(EnumMetals.LEAD, 0, 60, 5, 4);
        GameRegistry.registerWorldGenerator(leadGenerator, 1);

        copperPickaxe = new ItemCopperPickaxe(copperToolMaterial);
        GameRegistry.registerItem(copperPickaxe, copperPickaxe.getUnlocalizedName());

        copperAxe = new ItemCopperAxe(copperToolMaterial);
        GameRegistry.registerItem(copperAxe, copperAxe.getUnlocalizedName());

        copperShovel = new ItemCopperShovel(copperToolMaterial);
        GameRegistry.registerItem(copperShovel, copperShovel.getUnlocalizedName());

        copperHoe = new ItemCopperHoe(copperToolMaterial);
        GameRegistry.registerItem(copperHoe, copperHoe.getUnlocalizedName());

        copperSword = new ItemCopperSword(copperToolMaterial);
        GameRegistry.registerItem(copperSword, copperSword.getUnlocalizedName());

        copperHelmet = new ItemCopperArmor(copperArmorMaterial, 0, 0).setUnlocalizedName("copperHelmet");
        GameRegistry.registerItem(copperHelmet, copperHelmet.getUnlocalizedName());

        copperChestplate = new ItemCopperArmor(copperArmorMaterial, 0, 1).setUnlocalizedName("copperChestplate");
        GameRegistry.registerItem(copperChestplate, copperChestplate.getUnlocalizedName());

        copperLeggings = new ItemCopperArmor(copperArmorMaterial, 0, 2).setUnlocalizedName("copperLeggings");
        GameRegistry.registerItem(copperLeggings, copperLeggings.getUnlocalizedName());

        copperBoots = new ItemCopperArmor(copperArmorMaterial, 0, 3).setUnlocalizedName("copperBoots");
        GameRegistry.registerItem(copperBoots, copperBoots.getUnlocalizedName());

        worldEater = new WorldEater();
        GameRegistry.registerItem(worldEater, "itemWorldEater");

        blockWindmill = new BlockWindmill(Material.rock);
        GameRegistry.registerBlock(blockWindmill, "BlockWindmill");

        blockWindmillground = new BlockWindmillground(Material.ground);
        GameRegistry.registerBlock(blockWindmillground, "blockWindmillground");

        itemWindmill = new ItemWindmill().setTextureName("diamond").setCreativeTab(teslaTab);
        GameRegistry.registerItem(itemWindmill, "ItemWindmill");
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        for(EnumMetals metal : EnumMetals.VALID) {
            GameRegistry.addRecipe(metal.getIS(block, 1), "CCC", "CCC", "CCC", 'C', metal.getItemIS(ingot, 1));
            GameRegistry.addRecipe(metal.getItemIS(ingot, 1), "CCC", "CCC", "CCC", 'C', metal.getItemIS(nugget, 1));
            GameRegistry.addShapelessRecipe(metal.getItemIS(nugget, 9), EnumMetals.COPPER.getItemIS(ingot, 1));
            GameRegistry.addShapelessRecipe(metal.getItemIS(ingot, 9), EnumMetals.COPPER.getIS(block, 1));
        }

        GameRegistry.addRecipe(new ItemStack(copperPickaxe), "CCC", " S ", " S ", 'C', EnumMetals.COPPER.getIS(block, 1), 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(copperShovel), " C ", " S ", " S ", 'C', EnumMetals.COPPER.getIS(block, 1), 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(copperAxe), "CC ", "CS ", " S ", 'C', EnumMetals.COPPER.getIS(block, 1), 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(copperHoe), "CC ", " S ", " S ", 'C', EnumMetals.COPPER.getIS(block, 1), 'S', Items.stick);
        GameRegistry.addRecipe(new ItemStack(copperSword), " C ", " C ", " S ", 'C', EnumMetals.COPPER.getIS(block, 1), 'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(copperHelmet), "CCC", "C C", 'C', EnumMetals.COPPER.getItemIS(ingot, 1));
        GameRegistry.addRecipe(new ItemStack(copperChestplate), "C C", "CCC", "CCC", 'C', EnumMetals.COPPER.getItemIS(ingot, 1));
        GameRegistry.addRecipe(new ItemStack(copperLeggings), "CCC", "C C", "C C", 'C', EnumMetals.COPPER.getItemIS(ingot, 1));
        GameRegistry.addRecipe(new ItemStack(copperBoots), "C C", "C C", 'C', EnumMetals.COPPER.getItemIS(ingot, 1));

        GameRegistry.registerTileEntity(TileEntityWindmill.class, "Windmill");

        proxy.registerProxies();
    }
}
