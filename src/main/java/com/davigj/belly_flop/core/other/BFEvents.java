package com.davigj.belly_flop.core.other;

import com.davigj.belly_flop.core.BellyFlop;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BellyFlop.MOD_ID)
public class BFEvents {
    public static void onFlop (LivingFallEvent event) {
        float fallDistance = event.getEntity().fallDistance;
    }

}