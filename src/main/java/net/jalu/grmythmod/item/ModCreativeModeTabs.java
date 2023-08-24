package net.jalu.grmythmod.item;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    /**
     * Again a deferred register to store Creative Tabs
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MythMod.MOD_ID);

    /**
     * The myth tab
      */
    public static final RegistryObject<CreativeModeTab> MYTH_TAB = CREATIVE_MODE_TABS.register("myth_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creative.myth_tab"))
            .displayItems(((pParameters, pOutput) -> {
                //ADD ALL MOD ITEMS HERE SO IT APPEARS IN TAB, can also add vanilla items
                pOutput.accept(ModItems.NECTAR.get());
                pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                pOutput.accept(ModItems.RAW_RUBY.get());
                pOutput.accept(ModItems.RUBY.get());
                pOutput.accept(ModItems.METAL_DETECTOR.get());
                pOutput.accept(ModBlocks.RUBY_ORE.get());
                pOutput.accept(ModBlocks.END_STONE_RUBY_ORE.get());
                pOutput.accept(ModBlocks.NETHER_RUBY_ORE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                pOutput.accept(ModItems.STRAWBERRY.get());
                pOutput.accept(ModItems.PINE_CONE.get());
                pOutput.accept(ModBlocks.RUBY_DOOR.get());
                pOutput.accept(ModBlocks.RUBY_STAIRS.get());
                pOutput.accept(ModBlocks.RUBY_BUTTON.get());
                pOutput.accept(ModBlocks.RUBY_SLAB.get());
                pOutput.accept(ModBlocks.RUBY_FENCE.get());
                pOutput.accept(ModBlocks.RUBY_FENCE_GATE.get());
                pOutput.accept(ModBlocks.RUBY_WALL.get());
                pOutput.accept(ModBlocks.RUBY_PRESSURE_PLATE.get());
                pOutput.accept(ModBlocks.RUBY_TRAPDOOR.get());
                pOutput.accept(ModItems.RUBY_STAFF.get());

            })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
