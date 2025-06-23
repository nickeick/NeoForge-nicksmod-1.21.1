package com.nickkick.nicksmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties HOT_DOG = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodProperties HOT_DOG_WITH_KETCHUP = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1).build();
    public static final FoodProperties HOT_DOG_WITH_MUSTARD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400), 1).build();
    public static final FoodProperties HOT_DOG_WITH_KETCHUP_AND_MUSTARD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400), 1).build();

    public static final FoodProperties PIZZA_SLICE = new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 1).build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build();
}
