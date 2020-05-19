package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.Edenbound.BlockTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Edenbound.MOD_ID)
@Mod.EventBusSubscriber(modid = Edenbound.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit
{
    public static final Block large_generic_object = null;
    public static final Block perfectly_generic_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 5).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("large_generic_object"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 5).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("perfectly_generic_ore"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(large_generic_object, new Item.Properties().group(BlockTab.instance)).setRegistryName("large_generic_object"));
        event.getRegistry().register(new BlockItem(perfectly_generic_ore, new Item.Properties().group(BlockTab.instance)).setRegistryName("perfectly_generic_ore"));
    }

}
