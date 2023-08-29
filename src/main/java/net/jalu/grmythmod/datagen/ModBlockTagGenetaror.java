package net.jalu.grmythmod.datagen;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.block.ModBlocks;
import net.jalu.grmythmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenetaror extends BlockTagsProvider {

    public ModBlockTagGenetaror(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MythMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
            .add(ModBlocks.RUBY_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(
                ModBlocks.RUBY_ORE.get(),
                ModBlocks.NETHER_RUBY_ORE.get(),
                ModBlocks.DEEPSLATE_RUBY_ORE.get()
            );

        this.tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
            .add(
                ModBlocks.END_STONE_RUBY_ORE.get(),
                ModBlocks.SOUND_BLOCK.get()
            );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(
                ModBlocks.RUBY_ORE.get(),
                ModBlocks.NETHER_RUBY_ORE.get(),
                ModBlocks.END_STONE_RUBY_ORE.get(),
                ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                ModBlocks.SOUND_BLOCK.get()
            );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.RUBY_BLOCK.get());

        this.tag(BlockTags.FENCES)
            .add(ModBlocks.RUBY_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.RUBY_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
            .add(ModBlocks.RUBY_WALL.get());
    }
}
