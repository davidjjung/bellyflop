package com.davigj.belly_flop.core.registry;

import net.minecraft.world.damagesource.DamageSource;

public class BFDamageSources {
    public static final DamageSource BELLY_FLOP = new DamageSource("bellyFlop").bypassArmor().setIsFall();
    public static final DamageSource SURFACE_TENSION = new DamageSource("surfaceTension").bypassArmor().setIsFall();

}
