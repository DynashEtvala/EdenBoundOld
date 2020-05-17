package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.EdenBound;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = EdenBound.MOD_ID, bus = Bus.MOD)
@ObjectHolder(EdenBound.MOD_ID)
public class ItemInit
{
    public static final Item perfectly_generic_object = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(EdenBound.ItemTab.instance)).setRegistryName("perfectly_generic_object"));
    }
}
