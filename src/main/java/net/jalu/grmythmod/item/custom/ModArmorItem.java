package net.jalu.grmythmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.jalu.grmythmod.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    //To add more effects, just call .put more than once
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
        (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
            .put(ModArmorMaterials.RUBY, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1,
                false, false, true)).build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()) {
            if(fullArmorOn(player)) {
               evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {

        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            MobEffectInstance effectInstance = entry.getValue();

            if (hasCorrectSetOn(armorMaterial, player)) {
                addStatusEffectForMaterial(player, armorMaterial, effectInstance);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial armorMaterial,
                                            MobEffectInstance effectInstance) {

        boolean hasEffect = player.hasEffect(effectInstance.getEffect());

        if(hasCorrectSetOn(armorMaterial, player) && !hasEffect) {
            player.addEffect(new MobEffectInstance(effectInstance));
        }

    }

    private boolean hasCorrectSetOn(ArmorMaterial armorMaterial, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        var boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        var leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        var chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        var helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        var output = helmet.getMaterial() == armorMaterial && chestplate.getMaterial() == armorMaterial &&
            leggings.getMaterial() == armorMaterial && boots.getMaterial() == armorMaterial;

        return output;
    }


    private boolean fullArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
}
