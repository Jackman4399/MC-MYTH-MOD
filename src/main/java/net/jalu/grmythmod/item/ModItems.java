package net.jalu.grmythmod.item;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.item.custom.FuelItem;
import net.jalu.grmythmod.item.custom.MetalDetectorItem;
import net.jalu.grmythmod.item.custom.NectarItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    /**
     * Deferred register
     */
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, MythMod.MOD_ID);

    public static final RegistryObject<Item> NECTAR = ITEMS.register("nectar",
        () -> new NectarItem( new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
        () -> new Item( new Item.Properties()));

    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby",
        () -> new Item( new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
        () -> new MetalDetectorItem( new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
        () -> new Item( new Item.Properties().food(ModFoods.STRAWBERRY)));
    static final RegistryObject<Item> RUBY_STAFF = ITEMS.register("ruby_staff",
        () -> new Item( new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
        () -> new FuelItem( new Item.Properties(), 400));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
        () -> new SwordItem(ModToolTiers.RUBY, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 1, 1, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 7, 1, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, 0, 0, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
