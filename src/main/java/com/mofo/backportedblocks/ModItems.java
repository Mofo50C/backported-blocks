package com.mofo.backportedblocks;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(BackportedBlocks.MODID)
public class ModItems {

    @SideOnly(Side.CLIENT)
    public static void initModels() {

    }

    public static void registerItems(IForgeRegistry<Item> registry) {

    }


}
