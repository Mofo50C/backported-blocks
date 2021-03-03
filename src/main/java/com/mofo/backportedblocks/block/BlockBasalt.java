package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockBasalt extends BlockModGeneric {

    public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class);
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockBasalt(IForgeRegistry<Block> registry) {
        super(registry, "basalt", 1.25f, 4.2f);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y).withProperty(VARIANT, EnumType.NORMAL));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumType type : EnumType.values())
           items.add(new ItemStack(this, 1, type.getMetadata()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(AXIS, facing.getAxis());
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing.Axis axisState = EnumFacing.Axis.Y;

        switch (meta & 12) {
            case 4:
                axisState = EnumFacing.Axis.X;
                break;
            case 8:
                axisState = EnumFacing.Axis.Z;
                break;
        }
        IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta & 3));
        return (meta == 2) ? state.withProperty(AXIS, EnumFacing.Axis.Y) : state.withProperty(AXIS, axisState);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = state.getValue(VARIANT).getMetadata();
        if (i != 2) {
            switch (state.getValue(AXIS)) {
                case X:
                    i |= 4;
                    break;
                case Z:
                    i |= 8;
                    break;
            }
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT, AXIS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        for (EnumType type : EnumType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),
                    type.getMetadata(),
                    new ModelResourceLocation(getRegistryName(), "axis=y,variant="+type.getName()));
        }
    }

    public enum EnumType implements IStringSerializable {
        NORMAL(0, "normal", "raw"),
        POLISHED(1, "polished", "polished"),
        SMOOTH(2, "smooth", "smooth");

        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String serializedName;
        private final String unlocalizedName;

        EnumType(int meta, String name, String unlocalizedName) {
            this.meta = meta;
            this.serializedName = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.unlocalizedName;
        }

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static String[] getTypeNames() {
            String[] names = new String[EnumType.values().length];
            for (int i = 0; i < EnumType.values().length; i++) {
                names[i] = EnumType.byMetadata(i).getName();
            }
            return names;
        }

        public String getName()
        {
            return this.serializedName;
        }

        static {
            for (EnumType type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
}
