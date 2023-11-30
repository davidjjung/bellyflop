package com.davigj.belly_flop.core.registry;

import com.davigj.belly_flop.core.BellyFlop;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class BFEntityTypeTags {
    public static final TagKey<EntityType<?>> UNAFFECTED_BY_SURFACE_TENSION = entityTypeTag("unaffected_by_surface_tension");

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagUtil.entityTypeTag(BellyFlop.MOD_ID, name);
    }
}
