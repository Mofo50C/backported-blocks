package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.BackportedBlocks;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;


public class BlockModDoubleSlab extends BlockSlab implements IBlock {

    private final Block baseSlab;

    public BlockModDoubleSlab(IForgeRegistry<Block> registry, Block baseSlab,  Material material, float hardness, float resistance) {
        this(registry, baseSlab, baseSlab.getRegistryName().toString().replace(BackportedBlocks.MODID + ":", "double_"), material, hardness, resistance);
    }

    public BlockModDoubleSlab(IForgeRegistry<Block> registry, Block baseSlab) {
        this(registry, baseSlab, Material.ROCK, 1.5f, 6f);
    }

    public BlockModDoubleSlab(IForgeRegistry<Block> registry, Block baseSlab, String name, Material material, float hardness, float resistance) {
        super(material);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(BackportedBlocks.creativeTab);
        this.baseSlab = baseSlab;
        registry.register(this);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(Item.getItemFromBlock(this.baseSlab), 1));
        drops.add(new ItemStack(Item.getItemFromBlock(this.baseSlab), 1));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this.baseSlab));
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        if (!this.isDouble()) {
            state = state.withProperty(HALF, (meta) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 0 : 1;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HALF);
    }

    @SideOnly(Side.CLIENT)
    protected static boolean isHalfSlab(IBlockState state) {
        return true;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return null;
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return 0;
    }
}
