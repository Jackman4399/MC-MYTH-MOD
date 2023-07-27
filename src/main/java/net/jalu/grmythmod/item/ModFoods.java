package net.jalu.grmythmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
        .saturationMod(0.2f)
        .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 2000), 0.1f).build();

}
