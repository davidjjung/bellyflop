package com.davigj.belly_flop.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BFConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Double> surfaceTensionMultiplier;
        public final ForgeConfigSpec.ConfigValue<Double> bellyFlopMultiplier;
        public final ForgeConfigSpec.ConfigValue<Boolean> onlyPlayersAffected;

        Common (ForgeConfigSpec.Builder builder) {
            builder.push("changes");
            surfaceTensionMultiplier = builder.comment("Damage multiplier for falling in water-like fluids").define("Surface tension damage multiplier", 0.7D);
            bellyFlopMultiplier = builder.comment("Damage multiplier for falling in water-like fluids while in a crawling/swimming pose").define("Belly flop damage multiplier", 1.5D);
            onlyPlayersAffected = builder.comment("Only players are affected by falling into fluids from great heights").define("Surface tension affects players only", false);
            builder.pop();
        }
    }

    static final ForgeConfigSpec COMMON_SPEC;
    public static final BFConfig.Common COMMON;


    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(BFConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
