package com.davigj.belly_flop.core.other;

import com.davigj.belly_flop.core.BellyFlop;
import com.davigj.belly_flop.core.registry.BFDamageSources;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BellyFlop.MOD_ID)
public class BFEvents {
    @SubscribeEvent
    public static void onFlop (LivingAttackEvent event) {
        DamageSource source = event.getSource();
        if (event.getAmount() > 10 && source.toString().equals(BFDamageSources.BELLY_FLOP.toString()) && event.getEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() instanceof AxeItem && player.getOffhandItem().getItem() instanceof AxeItem && player instanceof ServerPlayer serverPlayer) {
                if (!player.getCommandSenderWorld().isClientSide()) {
                    BFCriteriaTriggers.VIKING_MODE.trigger((serverPlayer));
                }
            }
        }
    }

}