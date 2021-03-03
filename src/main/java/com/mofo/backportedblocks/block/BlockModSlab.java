package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.BackportedBlocks;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockModSlab extends BlockSlab implements IBlock {

    public BlockModSlab(IForgeRegistry<Block> registry, String name) {
        this(registry, name, Material.ROCK, 1.5f, 6f);
    }

    public BlockModSlab(IForgeRegistry<Block> registry, String name, Material materialIn, float hardness, float resistance) {
        super(materialIn);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(BackportedBlocks.creativeTab);
        useNeighborBrightness = true;
        registry.register(this);
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return null;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return 0;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HALF);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        if (!this.isDouble())
            state = state.withProperty(HALF, (meta) == 1 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 1 : 0;
    }
}
