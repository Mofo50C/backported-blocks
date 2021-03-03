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
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import com.mofo.backportedblocks.block.BlockCopper.EnumWeathered;

public class BlockCutCopper extends BlockModGeneric {

    public static final PropertyEnum<EnumWeathered> VARIANT = PropertyEnum.create("variant", EnumWeathered.class);

    public BlockCutCopper(IForgeRegistry<Block> registry) {
        super(registry, "cut_copper", Material.IRON, 3f, 6f, SoundType.METAL, "pickaxe", 2);
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
}
