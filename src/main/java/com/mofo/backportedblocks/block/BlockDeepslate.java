package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.ModBlocks;
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
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Random;

public class BlockDeepslate extends BlockModGeneric {

    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant",EnumType.class);

    public BlockDeepslate(IForgeRegistry<Block> registry) {
        super(registry, "deepslate", Material.ROCK, 3f, 6f, SoundType.STONE, "pickaxe", 1);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.NORMAL));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumType type : EnumType.values())
            items.add(new ItemStack(this, 1, type.getMetadata()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return (state.getValue(VARIANT) == EnumType.NORMAL) ? Item.getItemFromBlock(ModBlocks.blockCobbledDeepslate) : Item.getItemFromBlock(this);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public void initModel() {
        for (EnumType type : EnumType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),
                    type.getMetadata(),
                    new ModelResourceLocation(getRegistryName(), "variant="+type.getName()));
        }
    }

    public enum EnumType implements IStringSerializable {
        NORMAL(0, "normal", "normal"),
        BRICKS(1, "bricks", "bricks"),
        TILES(2, "tiles", "tiles");

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
