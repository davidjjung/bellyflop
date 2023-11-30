package com.davigj.belly_flop.core.registry;

import com.davigj.belly_flop.core.BellyFlop;
import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public class BFSounds {
    private static final SoundSubRegistryHelper HELPER = BellyFlop.REGISTRY_HELPER.getSoundSubHelper();

    public static final RegistryObject<SoundEvent> BELLY_FLOP = HELPER.createSoundEvent("entity.player.hurt_belly_flop");
}
