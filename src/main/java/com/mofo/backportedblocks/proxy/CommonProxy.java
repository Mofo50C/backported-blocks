package com.mofo.backportedblocks.proxy;

import com.mofo.backportedblocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber
public class CommonProxy {

    @GameRegistry.ObjectHolder("minecraft:nether_brick")
    public static Block netherBrick;

    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        OreDictionary.registerOre("cobblestone", new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 0));
        OreDictionary.registerOre("cobblestone", new ItemStack(ModBlocks.blockBlackstone, 1, 0));
        OreDictionary.registerOre("stone", ModBlocks.blockDeepslate);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 0), new ItemStack(ModBlocks.blockDeepslate, 1, 0), 0.1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.blockBasalt, 1, 0), new ItemStack(ModBlocks.blockBasalt, 1, 2), 0.1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.blockBlackstone, 1, 3), new ItemStack(ModBlocks.blockBlackstone, 1, 4), 0.1f);
        GameRegistry.addSmelting(new ItemStack(netherBrick, 1, 0), new ItemStack(ModBlocks.blockNetherBricks, 1, 0), 0.1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 3), new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 5), 0.1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 4), new ItemStack(ModBlocks.blockCobbledDeepslate, 1, 6), 0.1f);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.registerBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModBlocks.registerItemBlocks(event.getRegistry());
    }
}
