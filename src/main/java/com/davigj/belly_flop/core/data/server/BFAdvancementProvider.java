package com.davigj.belly_flop.core.data.server;

import com.davigj.belly_flop.core.BellyFlop;
import com.davigj.belly_flop.core.other.BFCriteriaTriggers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class BFAdvancementProvider extends AdvancementProvider {
    public BFAdvancementProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        createAdvancement("viking_mode", "adventure", new ResourceLocation("adventure/root"), Items.GOLDEN_AXE, FrameType.TASK, true, true, true)
                .addCriterion("viking_mode", BFCriteriaTriggers.VIKING_MODE.createInstance())
                .save(consumer, BellyFlop.MOD_ID + ":adventure/viking_mode");
    }

    private static Advancement.Builder createAdvancement(String name, String category, ResourceLocation parent, ItemLike icon, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(Advancement.Builder.advancement().build(parent)).display(icon,
                Component.translatable("advancements." + BellyFlop.MOD_ID + "." + category + "." + name + ".title"),
                Component.translatable("advancements." + BellyFlop.MOD_ID + "." + category + "." + name + ".description"),
                null, frame, showToast, announceToChat, hidden);
    }
}
