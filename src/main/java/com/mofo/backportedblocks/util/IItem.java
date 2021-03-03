package com.mofo.backportedblocks.util;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItem {

    @SideOnly(Side.CLIENT)
    default void initModel() {
        Item self = (Item) this;
        ModelLoader.setCustomModelResourceLocation(self, 0, new ModelResourceLocation(self.getRegistryName().toString()));
    }
}
