package com.dynashetvala.edenbound;

import com.dynashetvala.edenbound.init.BlockInit;
import com.dynashetvala.edenbound.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("edenbound")
public class EdenBound
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "edenbound";
    public static EdenBound instance;

    public EdenBound()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    }

    public static class BlockTab extends ItemGroup
    {
        public static final BlockTab instance = new BlockTab(ItemGroup.GROUPS.length, "edenboundblocks");
        private BlockTab(int index, String label)
        {
            super(index, label);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BlockInit.large_generic_object);
        }
    }

    public static class ItemTab extends ItemGroup
    {
        public static final ItemTab instance = new ItemTab(ItemGroup.GROUPS.length, "edenbounditems");
        private ItemTab(int index, String label)
        {
            super(index, label);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ItemInit.perfectly_generic_object);
        }
    }
}
