package net.jalu.grmythmod.datagen.loot;

import net.jalu.grmythmod.block.ModBlocks;
import net.jalu.grmythmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.RUBY_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));

        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));

        this.add(ModBlocks.END_STONE_RUBY_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));

        this.add(ModBlocks.NETHER_RUBY_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        //Every block in the mod that does not have the .noLootTable() called on it will be added
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
