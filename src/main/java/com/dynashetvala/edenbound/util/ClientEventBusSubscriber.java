package com.dynashetvala.edenbound.util;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.client.gui.GenericChestScreen;
import com.dynashetvala.edenbound.init.EdenboundContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Edenbound.MOD_ID, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.registerFactory(EdenboundContainerTypes.PERFECTLY_GENERIC_CHEST.get(), GenericChestScreen::new);
    }
}
