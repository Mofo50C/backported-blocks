package com.mofo.backportedblocks.block;

import com.mofo.backportedblocks.BackportedBlocks;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockModGeneric extends Block implements IBlock {

    public BlockModGeneric(IForgeRegistry<Block> registry, String name) {
        this(registry, name, 1.5f, 6f);
    }

    public BlockModGeneric(IForgeRegistry<Block> registry, String name, float hardness, float resistance) {
        this(registry, name, Material.ROCK, hardness, resistance, SoundType.STONE, "pickaxe", 1);
    }

    public BlockModGeneric(IForgeRegistry<Block> registry, String name, Material material, float hardness, float resistance, SoundType soundType, String tool, int toolLevel) {
        super(material);
        setCreativeTab(BackportedBlocks.creativeTab);
        setRegistryName(new ResourceLocation(BackportedBlocks.MODID, name));
        setUnlocalizedName(BackportedBlocks.MODID + "." + name);
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(soundType);
        setHarvestLevel(tool, toolLevel);
        registry.register(this);
    }

}
