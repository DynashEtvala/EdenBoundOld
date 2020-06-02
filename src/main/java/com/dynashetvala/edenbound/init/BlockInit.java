package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.Edenbound.BlockTab;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class BlockInit
{
    public  static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Edenbound.MOD_ID);

    //Perfectly Generic
    public static final RegistryObject<Block> PERFECTLY_GENERIC_ORE = BLOCKS.register("perfectly_generic_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 5).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LARGE_GENERIC_OBJECT = BLOCKS.register("large_generic_object", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 5).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> PERFECTLY_GENERIC_STAIRS = BLOCKS.register("perfectly_generic_stairs", () -> new StairsBlock(() -> LARGE_GENERIC_OBJECT.get().getDefaultState(), Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> PERFECTLY_GENERIC_SLAB = BLOCKS.register("perfectly_generic_slab", () -> new SlabBlock(Block.Properties.create(Material.EARTH)));
    //Perfectly Generic
}
