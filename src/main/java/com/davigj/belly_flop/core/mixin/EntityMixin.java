package com.davigj.belly_flop.core.mixin;

import com.davigj.belly_flop.core.BFConfig;
import com.davigj.belly_flop.core.registry.BFDamageSources;
import com.davigj.belly_flop.core.registry.BFEntityTypeTags;
import com.davigj.belly_flop.core.registry.BFSounds;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;lengthSqr()D"))
    private void beforeResetFallDistance(MoverType p_19973_, Vec3 p_19974_, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (!(entity instanceof WaterAnimal || entity.getType().is(BFEntityTypeTags.UNAFFECTED_BY_SURFACE_TENSION))) {
            if (entity.fallDistance != 0.0F && entity.collide(p_19974_).lengthSqr() >= 0.90D) {
                BlockHitResult blockhitresult = entity.level.clip(new ClipContext(entity.position(), entity.position().add(entity.collide(p_19974_)),
                        ClipContext.Block.FALLDAMAGE_RESETTING, ClipContext.Fluid.ANY, entity));
                if (blockhitresult.getType() != HitResult.Type.MISS) {
                    if (entity instanceof Player player && player.getPose().equals(Pose.SWIMMING)) {
                        entity.causeFallDamage((float) (BFConfig.COMMON.bellyFlopMultiplier.get() * entity.fallDistance), 1.0F, BFDamageSources.BELLY_FLOP);
                        entity.playSound(BFSounds.BELLY_FLOP.get(), 1.0F, (float) (1.0F + (player.getRandom().nextGaussian() * 0.2)));
                    } else {
                        if (!entity.getType().is(BFEntityTypeTags.UNAFFECTED_BY_SURFACE_TENSION)) {
                            entity.causeFallDamage((float) (BFConfig.COMMON.surfaceTensionMultiplier.get() * entity.fallDistance), 1.0F, BFDamageSources.SURFACE_TENSION);
                        }
                    }
                    entity.resetFallDistance();
                }
            }
        }
    }
}
