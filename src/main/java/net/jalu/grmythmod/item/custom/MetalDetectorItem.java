package net.jalu.grmythmod.item.custom;

import net.jalu.grmythmod.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide) {

            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    outputValuableCoords(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }

            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuables found."));
            }

            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player1 ->
                player1.broadcastBreakEvent(player1.getUsedItemHand()));

        }

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoords(BlockPos blockPos, Player player, Block block) {

        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at (" +
         blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));

    }

    private boolean isValuableBlock(BlockState blockState) {
        //Can modify to change metals or add more metals
        return blockState.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

    //Adds tooltip

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.grmythmod.metal_detector_tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
