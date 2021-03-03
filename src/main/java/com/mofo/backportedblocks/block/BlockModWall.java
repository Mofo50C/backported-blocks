package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.BackportedBlocks;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockModWall extends BlockWall implements IBlock {

    public BlockModWall(IForgeRegistry<Block> registry, String name, Block modelBlock) {
        super(modelBlock);
        setCreativeTab(BackportedBlocks.creativeTab);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false));
        registry.register(this);
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, 0));
    }

    public static <T extends Comparable<T>> BlockModWall createWallFromVariant(IForgeRegistry<Block> registry, String name, Block block, IProperty<T> property, T value) {
        return new BlockModWall(registry, name, block.getBlockState().getBaseState().withProperty(property, value).getBlock());
    }
}
