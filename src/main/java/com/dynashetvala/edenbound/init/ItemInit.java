package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.Edenbound.ItemTab;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import javax.swing.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Edenbound.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Edenbound.MOD_ID)
public class ItemInit
{
    //Materials
    public static final Item perfectly_generic_object = null;
    public static final Item perfectly_generic_rod = null;

    //Tools
    //Perfectly Generic Tools
        public static final Item perfectly_generic_sword = null;
        public static final Item perfectly_generic_pickaxe = null;
        public static final Item perfectly_generic_shovel = null;
        public static final Item perfectly_generic_axe = null;
        public static final Item perfectly_generic_hoe = null;
    //Perfectly Generic Tools

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        //Materials
        event.getRegistry().register(new Item(new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_object"));
        event.getRegistry().register(new Item(new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_rod"));

        //Tools
        {//Perfectly Generic Tools
            event.getRegistry().register(new SwordItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_sword"));
            event.getRegistry().register(new PickaxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_pickaxe"));
            event.getRegistry().register(new ShovelItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_shovel"));
            event.getRegistry().register(new AxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_axe"));
            event.getRegistry().register(new HoeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_hoe"));
        }//Perfectly Generic Tools
    }

    public enum EdenboundItemTier implements IItemTier
    {
        PERFECTLY_GENERIC(1, 500, 5, 4.5f, 255, () -> {return Ingredient.fromItems(ItemInit.perfectly_generic_object);});

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private EdenboundItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses()
        {
            return this.maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return this.repairMaterial.getValue();
        }
    }
}
