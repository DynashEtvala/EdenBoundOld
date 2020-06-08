package com.dynashetvala.edenbound.init;

import com.dynashetvala.edenbound.Edenbound;
import com.dynashetvala.edenbound.Edenbound.ItemTab;
import com.dynashetvala.edenbound.Edenbound.ArmorTab;
import com.dynashetvala.edenbound.Edenbound.ToolTab;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemInit
{
    public  static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Edenbound.MOD_ID);

    //Materials
    public static final RegistryObject<Item> PERFECTLY_GENERIC_OBJECT = ITEMS.register("perfectly_generic_object", () -> new Item(new Item.Properties().group(ItemTab.instance)));
    public static final RegistryObject<Item> PERFECTLY_GENERIC_ROD = ITEMS.register("perfectly_generic_rod", () -> new Item(new Item.Properties().group(ItemTab.instance)));

    //Perfectly Generic
    //Tools
        public static final RegistryObject<Item> PERFECTLY_GENERIC_SWORD = ITEMS.register("perfectly_generic_sword", () -> new SwordItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ToolTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_PICKAXE = ITEMS.register("perfectly_generic_pickaxe", () -> new PickaxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ToolTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_SHOVEL = ITEMS.register("perfectly_generic_shovel", () -> new ShovelItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ToolTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_AXE = ITEMS.register("perfectly_generic_axe", () -> new AxeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, 0, new Item.Properties().group(ToolTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_HOE = ITEMS.register("perfectly_generic_hoe", () -> new HoeItem(EdenboundItemTier.PERFECTLY_GENERIC, 0, new Item.Properties().group(ToolTab.instance)));
        //Armor
        public static final RegistryObject<Item> PERFECTLY_GENERIC_HELMET = ITEMS.register("perfectly_generic_helmet", () -> new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_CHESTPLATE = ITEMS.register("perfectly_generic_chestplate", () -> new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.CHEST, new Item.Properties().group(ArmorTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_LEGGINGS = ITEMS.register("perfectly_generic_leggings", () -> new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.LEGS, new Item.Properties().group(ArmorTab.instance)));
        public static final RegistryObject<Item> PERFECTLY_GENERIC_BOOTS = ITEMS.register("perfectly_generic_boots", () -> new ArmorItem(EdenboundArmorMaterial.PERFECTLY_GENERIC, EquipmentSlotType.FEET, new Item.Properties().group(ArmorTab.instance)));
        //Perfectly Generic

    public enum EdenboundItemTier implements IItemTier
    {
        PERFECTLY_GENERIC(1, 500, 5, 4.5f, 255, () -> {return Ingredient.fromItems(ItemInit.PERFECTLY_GENERIC_OBJECT.get());});

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
        PERFECTLY_GENERIC(Edenbound.MOD_ID + ":perfectly_generic", 50, new int[] {4,10,8,4}, 255, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 5f, () -> {return Ingredient.fromItems(ItemInit.PERFECTLY_GENERIC_OBJECT.get());});

        private static final  int[] MAX_DAMAGE_ARRAY = new int[] {11,16,15,13};
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
