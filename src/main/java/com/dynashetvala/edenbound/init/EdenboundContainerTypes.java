package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.container.GenericChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EdenboundContainerTypes
{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Edenbound.MOD_ID);

    public  static final RegistryObject<ContainerType<GenericChestContainer>> PERFECTLY_GENERIC_CHEST = CONTAINER_TYPES.register("perfectly_generic_chest", () -> IForgeContainerType.create(GenericChestContainer::new));
}
