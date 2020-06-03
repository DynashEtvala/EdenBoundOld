package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.tileentity.GenericChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EdenboundTileEntityTypes
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Edenbound.MOD_ID);

    public static final RegistryObject<TileEntityType<GenericChestTileEntity>> PERFECTLY_GENERIC_CHEST = TILE_ENTITY_TYPES.register("perfectly_generic_chest", () -> TileEntityType.Builder.create(GenericChestTileEntity::new, BlockInit.PERFECTLY_GENERIC_CHEST.get()).build(null));
}
