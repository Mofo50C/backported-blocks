package com.mofo.backportedblocks.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBlock {

    @SideOnly(Side.CLIENT)
    default void initModel() {
        Block self = (Block) this;
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(self), 0, new ModelResourceLocation(self.getRegistryName(), "inventory"));
    }

}
