package com.mofo.backportedblocks;

import com.mofo.backportedblocks.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BackportedBlocks.MODID, name = BackportedBlocks.MODNAME, version = BackportedBlocks.MODVERSION, dependencies = "required-after:forge@[14.23.5.2847,)", useMetadata = true)
public class BackportedBlocks {

    public static final String MODID = "backportedblocks";
    public static final String MODNAME = "Backported Blocks";
    public static final String MODVERSION= "1.0";

    @SidedProxy(clientSide = "com.mofo.backportedblocks.proxy.ClientProxy", serverSide = "com.mofo.backportedblocks.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.blockCopper);
        }
    };

    @Mod.Instance
    public static BackportedBlocks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
