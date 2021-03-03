package com.mofo.backportedblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockCopper extends BlockModGeneric {

    public static final PropertyEnum<EnumWeathered> VARIANT = PropertyEnum.create("variant", EnumWeathered.class);

    public BlockCopper(IForgeRegistry<Block> registry) {
        super(registry, "copper_block", Material.IRON, 3f, 6f, SoundType.METAL, "pickaxe", 2);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWeathered.NORMAL));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumWeathered type : EnumWeathered.values())
            items.add(new ItemStack(this, 1, type.getMetadata()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumWeathered.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        for (EnumWeathered type : EnumWeathered.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),
                    type.getMetadata(),
                    new ModelResourceLocation(getRegistryName(), "variant="+type.getName()));
        }
    }

    public enum EnumWeathered implements IStringSerializable {
        NORMAL(0, "normal", "normal"),
        LIGHTLY(1, "lightly_weathered", "lightly_weathered"),
        SEMI(2, "semi_weathered", "semi_weathered"),
        FULLY(3, "weathered", "weathered");

        private static final BlockCopper.EnumWeathered[] META_LOOKUP = new BlockCopper.EnumWeathered[values().length];
        private final int meta;
        private final String serializedName;
        private final String unlocalizedName;

        EnumWeathered(int meta, String name, String unlocalizedName) {
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

        public static BlockCopper.EnumWeathered byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static String[] getTypeNames() {
            String[] names = new String[BlockCopper.EnumWeathered.values().length];
            for (int i = 0; i < BlockCopper.EnumWeathered.values().length; i++) {
                names[i] = BlockCopper.EnumWeathered.byMetadata(i).getName();
            }
            return names;
        }

        public String getName()
        {
            return this.serializedName;
        }

        static {
            for (BlockCopper.EnumWeathered netherBrickType : values()) {
                META_LOOKUP[netherBrickType.getMetadata()] = netherBrickType;
            }
        }
    }
}
