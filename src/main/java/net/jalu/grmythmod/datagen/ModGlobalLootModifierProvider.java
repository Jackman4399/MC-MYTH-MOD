package net.jalu.grmythmod.datagen;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.item.ModItems;
import net.jalu.grmythmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, MythMod.MOD_ID);
    }

    @Override
    protected void start() {

        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[]{
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
            LootItemRandomChanceCondition.randomChance(0.35f).build()},
            ModItems.PINE_CONE.get()
        ));

        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()},
            ModItems.PINE_CONE.get()
        ));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build()},
            ModItems.METAL_DETECTOR.get()
        ));

    }
}
