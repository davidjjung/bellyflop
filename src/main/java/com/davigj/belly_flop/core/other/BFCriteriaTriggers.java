package com.davigj.belly_flop.core.other;

import com.davigj.belly_flop.core.BellyFlop;
import com.teamabnormals.blueprint.common.advancement.EmptyTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BellyFlop.MOD_ID)
public class BFCriteriaTriggers {
    public static final EmptyTrigger VIKING_MODE = CriteriaTriggers.register(new EmptyTrigger(new ResourceLocation(BellyFlop.MOD_ID, "viking_mode")));
}
