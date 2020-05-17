package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.EdenBound;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(EdenBound.MOD_ID)
@Mod.EventBusSubscriber(modid = EdenBound.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit
{
    public static final Block large_generic_object = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 5).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("large_generic_object"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(large_generic_object, new Item.Properties().group(EdenBound.BlockTab.instance)).setRegistryName("large_generic_object"));
    }

}
