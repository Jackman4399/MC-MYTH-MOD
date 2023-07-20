package net.jalu.grmythmod.block;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    /**
     * The deferred register
     */
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, MythMod.MOD_ID);

    /**
     * A sample block for the mod, change later
     */
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.AMETHYST))); //Use copy for a pre-existing block and 'of' a fully custom one

    public static final RegistryObject<Block> RAW_RUBY_ORE = registerBlock("raw_ruby_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.AMETHYST)));
    // To add a new block, add another registry object ^, then add it to the tabs in the main class //

    /**
     * Function called above to register a block
     * @param name
     * @param block
     * @return
     * @param <T>
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Manually registers a block item
     * @param name
     * @param block
     * @return
     * @param <T>
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
