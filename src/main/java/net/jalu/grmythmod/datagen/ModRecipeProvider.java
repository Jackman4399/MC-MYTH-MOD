package net.jalu.grmythmod.datagen;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.block.ModBlocks;
import net.jalu.grmythmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    //A list to made for the custom ores
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY.get(),
        ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(),
        ModBlocks.NETHER_RUBY_ORE.get(), ModBlocks.END_STONE_RUBY_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");

        //Example of shaped recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.RUBY.get())
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        //Example of shapeless recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
            .requires(ModBlocks.RUBY_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
            .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NECTAR.get())
            .requires(Items.MILK_BUCKET)
            .requires(Items.HONEY_BOTTLE)
            .unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
            .pattern("R")
            .pattern("R")
            .pattern("S")
            .define('R', ModItems.RUBY.get())
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
            .pattern("RR")
            .pattern("SR")
            .pattern("S ")
            .define('R', ModItems.RUBY.get())
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
            .pattern("RRR")
            .pattern(" S ")
            .pattern(" S ")
            .define('R', ModItems.RUBY.get())
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
            .pattern("R")
            .pattern("S")
            .pattern("S")
            .define('R', ModItems.RUBY.get())
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
            .pattern("RR")
            .pattern("S ")
            .pattern("S ")
            .define('R', ModItems.RUBY.get())
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET.get())
            .pattern("RRR")
            .pattern("R R")
            .define('R', ModItems.RUBY.get())
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE.get())
            .pattern("R R")
            .pattern("RRR")
            .pattern("RRR")
            .define('R', ModItems.RUBY.get())
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS.get())
            .pattern("RRR")
            .pattern("R R")
            .pattern("R R")
            .define('R', ModItems.RUBY.get())
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS.get())
            .pattern("R R")
            .pattern("R R")
            .define('R', ModItems.RUBY.get())
            .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
            .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pFinishedRecipeConsumer, MythMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
