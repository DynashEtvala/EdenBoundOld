package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.Edenbound.ItemTab;
import com.dynashetvala.edenbound.Edenbound.ArmorTab;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    //Perfectly Generic
    //Tools
        public static final Item perfectly_generic_sword = null;
        public static final Item perfectly_generic_pickaxe = null;
        public static final Item perfectly_generic_shovel = null;
        public static final Item perfectly_generic_axe = null;
        public static final Item perfectly_generic_hoe = null;
    //Armor
        public static final Item perfectly_generic_helmet = null;
        public static final Item perfectly_generic_chestplate = null;
        public static final Item perfectly_generic_leggings = null;
        public static final Item perfectly_generic_boots = null;
    //Perfectly Generic

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        //Materials
        event.getRegistry().register(new Item(new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_object"));
        event.getRegistry().register(new Item(new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_rod"));


        {//Perfectly Generic
            //Tools
            event.getRegistry().register(new SwordItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_sword"));
            event.getRegistry().register(new PickaxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_pickaxe"));
            event.getRegistry().register(new ShovelItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_shovel"));
            event.getRegistry().register(new AxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_axe"));
            event.getRegistry().register(new HoeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, new Item.Properties().group(ItemTab.instance)).setRegistryName("perfectly_generic_hoe"));
            //Armor
            event.getRegistry().register(new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorTab.instance)).setRegistryName("perfectly_generic_helmet"));
            event.getRegistry().register(new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.CHEST, new Item.Properties().group(ArmorTab.instance)).setRegistryName("perfectly_generic_chestplate"));
            event.getRegistry().register(new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.LEGS, new Item.Properties().group(ArmorTab.instance)).setRegistryName("perfectly_generic_leggings"));
            event.getRegistry().register(new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.FEET, new Item.Properties().group(ArmorTab.instance)).setRegistryName("perfectly_generic_boots"));
        }//Perfectly Generic
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

    public enum EdenboundArmorMaterial implements IArmorMaterial
    {
        PERFECTLY_GENERIC(Edenbound.MOD_ID + ":perfectly_generic", 5, new int[] {7,9,11,7}, 255, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.9f, () -> {return Ingredient.fromItems(ItemInit.perfectly_generic_object);});

        private static final  int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
        private final String name;
        private final int maxDamageFactor;
        private final int [] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private EdenboundArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial)
        {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn)
        {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn)
        {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability()
        {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent()
        {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName()
        {
            return this.name;
        }

        @Override
        public float getToughness()
        {
            return this.toughness;
        }
    }
}
