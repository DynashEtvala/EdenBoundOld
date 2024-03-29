package com.dynashetvala.edenbound;

import com.dynashetvala.edenbound.init.BlockInit;
import com.dynashetvala.edenbound.init.ItemInit;
import com.dynashetvala.edenbound.world.gen.EdenboundOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("edenbound")
@Mod.EventBusSubscriber(modid = Edenbound.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Edenbound
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "edenbound";
    public static Edenbound instance;

    public Edenbound()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(BlockTab.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
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

    @SubscribeEvent
    public static void LoadCompleteEvent(FMLLoadCompleteEvent event){
        EdenboundOreGen.generateOre();
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
            return new ItemStack(BlockInit.LARGE_GENERIC_OBJECT.get());
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
            return new ItemStack(ItemInit.PERFECTLY_GENERIC_OBJECT.get());
        }
    }

    public static class ArmorTab extends ItemGroup
    {
        public static final ArmorTab instance = new ArmorTab(ItemGroup.GROUPS.length, "edenboundarmor");

        private ArmorTab(int index, String label)
        {
            super(index, label);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ItemInit.PERFECTLY_GENERIC_HELMET.get());
        }
    }

    public static class ToolTab extends ItemGroup
    {
        public static final ToolTab instance = new ToolTab(ItemGroup.GROUPS.length, "edenboundtools");

        private ToolTab(int index, String label)
        {
            super(index, label);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ItemInit.PERFECTLY_GENERIC_PICKAXE.get());
        }
    }
}
