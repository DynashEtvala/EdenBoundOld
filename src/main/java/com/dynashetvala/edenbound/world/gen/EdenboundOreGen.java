package com.dynashetvala.edenbound.world.gen;

import com.dynashetvala.edenbound.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public class EdenboundOreGen
{
    public static void generateOre()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 5, 5, 64));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.perfectly_generic_ore.getDefaultState(), 2)).withPlacement(customConfig));
        }
    }
}
