package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.BackportedBlocks;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockModStairs extends BlockStairs implements IBlock {

    public BlockModStairs(IForgeRegistry<Block> registry, String name, IBlockState baseState) {
        super(baseState);
        setCreativeTab(BackportedBlocks.creativeTab);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        useNeighborBrightness = true;
        registry.register(this);
    }

    public BlockModStairs(IForgeRegistry<Block> registry, String name, Block base) {
        super(base.getDefaultState());
        setCreativeTab(BackportedBlocks.creativeTab);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        useNeighborBrightness = true;
        registry.register(this);
    }

    public static <T extends Comparable<T>> BlockModStairs createStairFromVariant(IForgeRegistry<Block> registry, String name, Block block, IProperty<T> property, T value) {
        return new BlockModStairs(registry, name, block.getBlockState().getBaseState().withProperty(property, value));
    }


}
