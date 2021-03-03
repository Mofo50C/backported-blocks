package com.mofo.backportedblocks.item;

import com.mofo.backportedblocks.util.IItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModSlab extends ItemBlock implements IItem {

    private final Block doubleSlab;

    public ItemModSlab(Block halfSlab, Block doubleSlab) {
        super(halfSlab);
        this.doubleSlab = doubleSlab;
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitx, float hity, float hitz) {
        ItemStack stack = player.getHeldItem(hand);
        if (stack.getCount() == 0) {
            return EnumActionResult.FAIL;
        } else if (!player.canPlayerEdit(pos.offset(side), side, stack)) {
            return EnumActionResult.FAIL;
        } else {
            IBlockState iblockstate = world.getBlockState(pos);
            if (iblockstate.getBlock() == getBlock()) {
                BlockSlab.EnumBlockHalf enumblockhalf = iblockstate.getValue(BlockSlab.HALF);
                if ((side == EnumFacing.UP && enumblockhalf == BlockSlab.EnumBlockHalf.BOTTOM || side == EnumFacing.DOWN && enumblockhalf == BlockSlab.EnumBlockHalf.TOP)) {
                    IBlockState iblockstate1 = this.doubleSlab.getDefaultState();
                    if (world.checkNoEntityCollision(this.doubleSlab.getBoundingBox(iblockstate1, world, pos)) && world.setBlockState(pos, iblockstate1, 3)) {
                        world.playSound(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, this.doubleSlab.getSoundType().getPlaceSound(), SoundCategory.BLOCKS, (this.doubleSlab.getSoundType().getVolume() + 1.0F) / 2.0F, this.doubleSlab.getSoundType().getPitch() * 0.8F, true);
                        stack.shrink(1);
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
            return (this.check(stack, world, pos.offset(side)) || (super.onItemUse(player, world, pos, hand, side, hitx, hity, hitz) == EnumActionResult.SUCCESS ? true : false)) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing facing, EntityPlayer player, ItemStack stack) {
        BlockPos blockpos1 = pos;
        IBlockState iblockstate = world.getBlockState(pos);
        if (iblockstate.getBlock() == getBlock()) {
            boolean flag = iblockstate.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;
            if ((facing == EnumFacing.UP && !flag || facing == EnumFacing.DOWN && flag)) {
                return true;
            }
        }
        pos = pos.offset(facing);
        IBlockState iblockstate1 = world.getBlockState(pos);
        return iblockstate1.getBlock() == getBlock() || super.canPlaceBlockOnSide(world, blockpos1, facing, player, stack);
    }

    private boolean check(ItemStack stack, World world, BlockPos pos) {
        IBlockState iblockstate = world.getBlockState(pos);
        if (iblockstate.getBlock() == getBlock()) {
            IBlockState iblockstate1 = this.doubleSlab.getDefaultState();
            if (world.checkNoEntityCollision(this.doubleSlab.getBoundingBox(iblockstate1, world, pos)) && world.setBlockState(pos, iblockstate1, 3)) {
                world.playSound(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, this.doubleSlab.getSoundType().getPlaceSound(), SoundCategory.BLOCKS, (this.doubleSlab.getSoundType().getVolume() + 1.0F) / 2.0F, this.doubleSlab.getSoundType().getPitch() * 0.8F, true);
                stack.shrink(1);
            }
            return true;
        }
        return false;
    }
}
