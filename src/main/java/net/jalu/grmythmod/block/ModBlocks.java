package net.jalu.grmythmod.block;

import net.jalu.grmythmod.MythMod;
import net.jalu.grmythmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, MythMod.MOD_ID);

    public static final RegistryObject<Block> SAMPLE_BLOCK = registerBlock("sample_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))); //Use copy for a pre-existing block and 'of' a fully custom one

    //To add a new block, add another registry object ^, then add it to the tabs in the main class

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
