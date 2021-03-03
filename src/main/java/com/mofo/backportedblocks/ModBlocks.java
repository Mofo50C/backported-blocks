package com.mofo.backportedblocks;

import com.mofo.backportedblocks.block.*;
import com.mofo.backportedblocks.item.ItemModSlab;
import com.mofo.backportedblocks.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(BackportedBlocks.MODID)
public class ModBlocks {

    public static Block
            blockAmethyst,
            blockCalcite,
            blockTuff,
            blockSculk,
            blockCopper,
            blockCutCopper,
            blockCobbledDeepslate,
            blockDeepslate,
            blockBlackstone,
            blockQuartzBricks,
            blockBasalt,
            blockNetherBricks,
            blockCryingObsidian,
            blockLodestone,
            blockCobblestoneBricks;

    public static Block
            stairCutCopper0,
            stairCutCopper1,
            stairCutCopper2,
            stairCutCopper3,
            stairDeepslateCobbled,
            stairDeepslatePolished,
            stairDeepslateBricks,
            stairDeepslateTiles,
            stairBlackstone,
            stairPolishedBlackstone,
            stairBlackstoneBricks,
            stairCobblestoneBricks;

    public static Block
            wallDeepslateCobbled,
            wallDeepslatePolished,
            wallDeepslateBricks,
            wallDeepslateTiles,
            wallBlackstone,
            wallPolishedBlackstone,
            wallBlackstoneBricks,
            wallCobblestoneBricks;

    public static Block
            slabCutCopper0,
            slabCutCopper1,
            slabCutCopper2,
            slabCutCopper3,
            slabDeepslateCobbled,
            slabDeepslatePolished,
            slabDeepslateBricks,
            slabDeepslateTiles,
            slabBlackstone,
            slabPolishedBlackstone,
            slabBlackstoneBricks,
            slabCobblestoneBricks;

    public static Block
            doubleSlabCutCopper0,
            doubleSlabCutCopper1,
            doubleSlabCutCopper2,
            doubleSlabCutCopper3,
            doubleSlabDeepslateCobbled,
            doubleSlabDeepslatePolished,
            doubleSlabDeepslateBricks,
            doubleSlabDeepslateTiles,
            doubleSlabBlackstone,
            doubleSlabPolishedBlackstone,
            doubleSlabBlackstoneBricks,
            doubleSlabCobblestoneBricks;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ((IBlock)blockAmethyst).initModel();
        ((IBlock)blockCalcite).initModel();
        ((IBlock)blockTuff).initModel();
        ((IBlock)blockSculk).initModel();
        ((IBlock)blockCopper).initModel();
        ((IBlock)blockCutCopper).initModel();
        ((IBlock)blockCobbledDeepslate).initModel();
        ((IBlock)blockDeepslate).initModel();
        ((IBlock)blockBlackstone).initModel();
        ((IBlock)blockQuartzBricks).initModel();
        ((IBlock)blockBasalt).initModel();
        ((IBlock)blockNetherBricks).initModel();
        ((IBlock)blockCryingObsidian).initModel();
        ((IBlock)blockLodestone).initModel();
        ((IBlock)blockCobblestoneBricks).initModel();

        ((IBlock)stairDeepslateBricks).initModel();
        ((IBlock)stairDeepslateCobbled).initModel();
        ((IBlock)stairDeepslatePolished).initModel();
        ((IBlock)stairDeepslateTiles).initModel();
        ((IBlock)stairCutCopper0).initModel();
        ((IBlock)stairCutCopper1).initModel();
        ((IBlock)stairCutCopper2).initModel();
        ((IBlock)stairCutCopper3).initModel();
        ((IBlock)stairBlackstone).initModel();
        ((IBlock)stairPolishedBlackstone).initModel();
        ((IBlock)stairBlackstoneBricks).initModel();
        ((IBlock)stairCobblestoneBricks).initModel();

        ((IBlock)slabDeepslateBricks).initModel();
        ((IBlock)slabDeepslatePolished).initModel();
        ((IBlock)slabDeepslateTiles).initModel();
        ((IBlock)slabDeepslateCobbled).initModel();
        ((IBlock)slabCutCopper0).initModel();
        ((IBlock)slabCutCopper1).initModel();
        ((IBlock)slabCutCopper2).initModel();
        ((IBlock)slabCutCopper3).initModel();
        ((IBlock)slabBlackstone).initModel();
        ((IBlock)slabPolishedBlackstone).initModel();
        ((IBlock)slabBlackstoneBricks).initModel();
        ((IBlock)slabCobblestoneBricks).initModel();

        ((IBlock)doubleSlabDeepslateBricks).initModel();
        ((IBlock)doubleSlabDeepslatePolished).initModel();
        ((IBlock)doubleSlabDeepslateTiles).initModel();
        ((IBlock)doubleSlabDeepslateCobbled).initModel();
        ((IBlock)doubleSlabCutCopper0).initModel();
        ((IBlock)doubleSlabCutCopper1).initModel();
        ((IBlock)doubleSlabCutCopper2).initModel();
        ((IBlock)doubleSlabCutCopper3).initModel();
        ((IBlock)doubleSlabBlackstone).initModel();
        ((IBlock)doubleSlabPolishedBlackstone).initModel();
        ((IBlock)doubleSlabBlackstoneBricks).initModel();
        ((IBlock)doubleSlabCobblestoneBricks).initModel();

        ((IBlock)wallDeepslateBricks).initModel();
        ((IBlock)wallDeepslatePolished).initModel();
        ((IBlock)wallDeepslateTiles).initModel();
        ((IBlock)wallDeepslateCobbled).initModel();
        ((IBlock)wallBlackstone).initModel();
        ((IBlock)wallPolishedBlackstone).initModel();
        ((IBlock)wallBlackstoneBricks).initModel();
        ((IBlock)wallCobblestoneBricks).initModel();

    }

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        blockAmethyst = new BlockModGeneric(registry, "amethyst_block", Material.GLASS, 1.5f, 1.5f, SoundType.GLASS, "pickaxe", 3);
        blockCalcite = new BlockModGeneric(registry, "calcite", 0.75f, 0.75f);
        blockTuff = new BlockModGeneric(registry, "tuff");
        blockSculk = new BlockModGeneric(registry, "sculk_block", Material.GROUND, 0.5f, 0.5f, SoundType.SLIME, "hoe", 1);
        blockCopper = new BlockCopper(registry);
        blockCutCopper = new BlockCutCopper(registry);
        blockCobbledDeepslate = new BlockCobbledDeepslate(registry);
        blockDeepslate = new BlockDeepslate(registry);
        blockBlackstone = new BlockBlackstone(registry);
        blockQuartzBricks = new BlockModGeneric(registry, "quartz_bricks", Material.ROCK, 0.8f, 0.8f, SoundType.STONE, "pickaxe", 1);
        blockBasalt = new BlockBasalt(registry);
        blockNetherBricks = new BlockNetherBricks(registry);
        blockCryingObsidian = new BlockModGeneric(registry, "crying_obsidian", Material.ROCK, 50f, 1200f, SoundType.STONE, "pickaxe", 3);
        blockLodestone = new BlockModGeneric(registry, "lodestone");
        blockCobblestoneBricks = new BlockModGeneric(registry, "cobblestone_bricks");

        stairCutCopper0 = BlockModStairs.createStairFromVariant(registry, "cut_copper_stairs", blockCutCopper, BlockCutCopper.VARIANT, BlockCopper.EnumWeathered.NORMAL);
        stairCutCopper1 = BlockModStairs.createStairFromVariant(registry, "lightly_weathered_cut_copper_stairs", blockCutCopper, BlockCutCopper.VARIANT, BlockCopper.EnumWeathered.LIGHTLY);
        stairCutCopper2 = BlockModStairs.createStairFromVariant(registry, "semi_weathered_cut_copper_stairs", blockCutCopper, BlockCutCopper.VARIANT, BlockCopper.EnumWeathered.SEMI);
        stairCutCopper3 = BlockModStairs.createStairFromVariant(registry, "weathered_cut_copper_stairs", blockCutCopper, BlockCutCopper.VARIANT, BlockCopper.EnumWeathered.FULLY);
        stairDeepslateTiles = BlockModStairs.createStairFromVariant(registry, "deepslate_tile_stairs", blockDeepslate, BlockDeepslate.VARIANT, BlockDeepslate.EnumType.TILES);
        stairDeepslateBricks = BlockModStairs.createStairFromVariant(registry, "deepslate_brick_stairs", blockDeepslate, BlockDeepslate.VARIANT, BlockDeepslate.EnumType.BRICKS);
        stairDeepslatePolished = BlockModStairs.createStairFromVariant(registry, "polished_deepslate_stairs", blockCobbledDeepslate, BlockCobbledDeepslate.VARIANT, BlockCobbledDeepslate.EnumType.POLISHED);
        stairDeepslateCobbled = BlockModStairs.createStairFromVariant(registry, "cobbled_deepslate_stairs", blockCobbledDeepslate, BlockCobbledDeepslate.VARIANT, BlockCobbledDeepslate.EnumType.NORMAL);
        stairBlackstone = BlockModStairs.createStairFromVariant(registry, "blackstone_stairs", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.NORMAL);
        stairPolishedBlackstone = BlockModStairs.createStairFromVariant(registry, "polished_blackstone_stairs", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.POLISHED);
        stairBlackstoneBricks = BlockModStairs.createStairFromVariant(registry, "blackstone_brick_stairs", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.BRICKS);
        stairCobblestoneBricks = new BlockModStairs(registry, "cobblestone_brick_stairs", blockCobblestoneBricks);

        slabCutCopper0 = new BlockModSlab(registry, "cut_copper_slabs", Material.IRON, 1.5f, 6f);
        slabCutCopper1 = new BlockModSlab(registry, "lightly_weathered_cut_copper_slabs", Material.IRON, 1.5f, 6f);
        slabCutCopper2 = new BlockModSlab(registry, "semi_weathered_cut_copper_slabs", Material.IRON, 1.5f, 6f);
        slabCutCopper3 = new BlockModSlab(registry, "weathered_cut_copper_slabs", Material.IRON, 1.5f, 6f);
        slabDeepslateCobbled = new BlockModSlab(registry, "cobbled_deepslate_slabs");
        slabDeepslatePolished = new BlockModSlab(registry, "polished_deepslate_slabs");
        slabDeepslateTiles = new BlockModSlab(registry, "deepslate_tile_slabs");
        slabDeepslateBricks = new BlockModSlab(registry, "deepslate_brick_slabs");
        slabBlackstone = new BlockModSlab(registry, "blackstone_slabs");
        slabPolishedBlackstone = new BlockModSlab(registry, "polished_blackstone_slabs");
        slabBlackstoneBricks = new BlockModSlab(registry, "blackstone_brick_slabs");
        slabCobblestoneBricks = new BlockModSlab(registry, "cobblestone_brick_slabs");

        doubleSlabCutCopper0 = new BlockModDoubleSlab(registry, slabCutCopper0, Material.IRON, 1.5f, 6f);
        doubleSlabCutCopper1 = new BlockModDoubleSlab(registry, slabCutCopper1, Material.IRON, 1.5f, 6f);
        doubleSlabCutCopper2 = new BlockModDoubleSlab(registry, slabCutCopper2, Material.IRON, 1.5f, 6f);
        doubleSlabCutCopper3 = new BlockModDoubleSlab(registry, slabCutCopper3, Material.IRON, 1.5f, 6f);
        doubleSlabDeepslateCobbled = new BlockModDoubleSlab(registry, slabDeepslateCobbled);
        doubleSlabDeepslatePolished = new BlockModDoubleSlab(registry, slabDeepslatePolished);
        doubleSlabDeepslateBricks = new BlockModDoubleSlab(registry, slabDeepslateBricks);
        doubleSlabDeepslateTiles = new BlockModDoubleSlab(registry, slabDeepslateTiles);
        doubleSlabBlackstone = new BlockModDoubleSlab(registry, slabBlackstone);
        doubleSlabPolishedBlackstone = new BlockModDoubleSlab(registry, slabPolishedBlackstone);
        doubleSlabBlackstoneBricks = new BlockModDoubleSlab(registry, slabBlackstoneBricks);
        doubleSlabCobblestoneBricks = new BlockModDoubleSlab(registry, slabCobblestoneBricks);

        wallDeepslateCobbled = BlockModWall.createWallFromVariant(registry, "cobbled_deepslate_wall", blockCobbledDeepslate, BlockCobbledDeepslate.VARIANT, BlockCobbledDeepslate.EnumType.NORMAL);
        wallDeepslatePolished = BlockModWall.createWallFromVariant(registry, "polished_deepslate_wall", blockCobbledDeepslate, BlockCobbledDeepslate.VARIANT, BlockCobbledDeepslate.EnumType.POLISHED);
        wallDeepslateTiles = BlockModWall.createWallFromVariant(registry, "deepslate_tile_wall", blockDeepslate, BlockDeepslate.VARIANT, BlockDeepslate.EnumType.TILES);
        wallDeepslateBricks = BlockModWall.createWallFromVariant(registry, "deepslate_brick_wall", blockDeepslate, BlockDeepslate.VARIANT, BlockDeepslate.EnumType.BRICKS);
        wallBlackstone = BlockModWall.createWallFromVariant(registry, "blackstone_wall", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.NORMAL);
        wallPolishedBlackstone = BlockModWall.createWallFromVariant(registry, "polished_blackstone_wall", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.POLISHED);
        wallBlackstoneBricks = BlockModWall.createWallFromVariant(registry, "blackstone_brick_wall", blockBlackstone, BlockBlackstone.VARIANT, BlockBlackstone.EnumType.BRICKS);
        wallCobblestoneBricks = new BlockModWall(registry, "cobblestone_brick_wall", blockCobblestoneBricks);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(createItem(blockAmethyst));
        registry.register(createItem(blockCalcite));
        registry.register(createItem(blockTuff));
        registry.register(createItem(blockSculk));
        registry.register(createVariantItem(blockCopper, BlockCopper.EnumWeathered.getTypeNames()));
        registry.register(createVariantItem(blockCutCopper, BlockCopper.EnumWeathered.getTypeNames()));
        registry.register(createVariantItem(blockCobbledDeepslate, BlockCobbledDeepslate.EnumType.getTypeNames()));
        registry.register(createVariantItem(blockDeepslate, BlockDeepslate.EnumType.getTypeNames()));
        registry.register(createVariantItem(blockBlackstone, BlockBlackstone.EnumType.getTypeNames()));
        registry.register(createVariantItem(blockBasalt, BlockBasalt.EnumType.getTypeNames()));
        registry.register(createVariantItem(blockNetherBricks, BlockNetherBricks.EnumType.getTypeNames()));
        registry.register(createItem(blockQuartzBricks));
        registry.register(createItem(blockCryingObsidian));
        registry.register(createItem(blockLodestone));
        registry.register(createItem(blockCobblestoneBricks));

        registry.register(createItem(stairCutCopper0));
        registry.register(createItem(stairCutCopper1));
        registry.register(createItem(stairCutCopper2));
        registry.register(createItem(stairCutCopper3));
        registry.register(createItem(stairDeepslateCobbled));
        registry.register(createItem(stairDeepslateBricks));
        registry.register(createItem(stairDeepslatePolished));
        registry.register(createItem(stairDeepslateTiles));
        registry.register(createItem(stairBlackstone));
        registry.register(createItem(stairPolishedBlackstone));
        registry.register(createItem(stairBlackstoneBricks));
        registry.register(createItem(stairCobblestoneBricks));

        registry.register(createItem(wallDeepslateBricks));
        registry.register(createItem(wallDeepslateCobbled));
        registry.register(createItem(wallDeepslatePolished));
        registry.register(createItem(wallDeepslateTiles));
        registry.register(createItem(wallBlackstone));
        registry.register(createItem(wallPolishedBlackstone));
        registry.register(createItem(wallBlackstoneBricks));
        registry.register(createItem(wallCobblestoneBricks));

        registry.register(new ItemModSlab(slabCutCopper0, doubleSlabCutCopper0).setRegistryName(slabCutCopper0.getRegistryName()));
        registry.register(new ItemModSlab(slabCutCopper1, doubleSlabCutCopper1).setRegistryName(slabCutCopper1.getRegistryName()));
        registry.register(new ItemModSlab(slabCutCopper2, doubleSlabCutCopper2).setRegistryName(slabCutCopper2.getRegistryName()));
        registry.register(new ItemModSlab(slabCutCopper3, doubleSlabCutCopper3).setRegistryName(slabCutCopper3.getRegistryName()));
        registry.register(new ItemModSlab(slabDeepslateCobbled, doubleSlabDeepslateCobbled).setRegistryName(slabDeepslateCobbled.getRegistryName()));
        registry.register(new ItemModSlab(slabDeepslatePolished, doubleSlabDeepslatePolished).setRegistryName(slabDeepslatePolished.getRegistryName()));
        registry.register(new ItemModSlab(slabDeepslateBricks, doubleSlabDeepslateBricks).setRegistryName(slabDeepslateBricks.getRegistryName()));
        registry.register(new ItemModSlab(slabDeepslateTiles, doubleSlabDeepslateTiles).setRegistryName(slabDeepslateTiles.getRegistryName()));
        registry.register(new ItemModSlab(slabBlackstone, doubleSlabBlackstone).setRegistryName(slabBlackstone.getRegistryName()));
        registry.register(new ItemModSlab(slabPolishedBlackstone, doubleSlabPolishedBlackstone).setRegistryName(slabPolishedBlackstone.getRegistryName()));
        registry.register(new ItemModSlab(slabBlackstoneBricks, doubleSlabBlackstoneBricks).setRegistryName(slabBlackstoneBricks.getRegistryName()));
        registry.register(new ItemModSlab(slabCobblestoneBricks, doubleSlabCobblestoneBricks).setRegistryName(slabCobblestoneBricks.getRegistryName()));
    }

    public static ItemBlock createItem(Block block) {
        return (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
    }

    public static ItemColored createVariantItem(Block block, String[] subNames) {
        return (ItemColored) new ItemColored(block, true) {
            @Override
            public int getMetadata(int damage) {
                return damage;
            }
        }.setSubtypeNames(subNames).setRegistryName(block.getRegistryName());
    }


}
