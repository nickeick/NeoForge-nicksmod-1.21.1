package com.nickkick.nicksmod.data_map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nickkick.nicksmod.NicksMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import org.jetbrains.annotations.NotNull;

public class ModDataMapTypes {

    public record SkillData(String name, int skill) implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<SkillData> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "skill_data"));

        public static final Codec<SkillData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("name").forGetter(SkillData::name),
                Codec.INT.fieldOf("skill").forGetter(SkillData::skill)
        ).apply(instance, SkillData::new));

        public static final StreamCodec<ByteBuf, SkillData> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8,
                        SkillData::name,
                        ByteBufCodecs.VAR_INT,
                        SkillData::skill,
                        SkillData::new
                );

        @Override
        public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() { return TYPE; }
    }

    public static DataMapType<EntityType<?>, SkillData> SKILL_DATA;

    public record BonusData(String name, String skill, int cost, boolean has) implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<BonusData> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "bonus_data"));

        public static final Codec<BonusData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("name").forGetter(BonusData::name),
                Codec.STRING.fieldOf("skill").forGetter(BonusData::skill),
                Codec.INT.fieldOf("cost").forGetter(BonusData::cost),
                Codec.BOOL.fieldOf("has").forGetter(BonusData::has)
        ).apply(instance, BonusData::new));

        public static final StreamCodec<ByteBuf, BonusData> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8,
                        BonusData::name,
                        ByteBufCodecs.STRING_UTF8,
                        BonusData::skill,
                        ByteBufCodecs.VAR_INT,
                        BonusData::cost,
                        ByteBufCodecs.BOOL,
                        BonusData::has,
                        BonusData::new
                );

        @Override
        public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() { return TYPE; }

        public boolean equals(BonusData bonusData) { return bonusData.name.equals(this.name) && bonusData.has() == this.has() && bonusData.skill().equals(this.skill) && bonusData.toString().equals(this.toString()) && bonusData.cost() == this.cost(); }
    }

    public static DataMapType<EntityType<?>, BonusData> BONUS_DATA;

    public record ToggleAreaAbilityPayload() implements CustomPacketPayload {
        public static final Type<ToggleAreaAbilityPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "toggle_area_mode_ability"));

        public static final StreamCodec<FriendlyByteBuf, ToggleAreaAbilityPayload> CODEC =
                StreamCodec.unit(new ToggleAreaAbilityPayload());

        @Override
        public @NotNull Type<ToggleAreaAbilityPayload> type() { return TYPE; }
    }

    public record ToggleFellerAbilityPayload() implements CustomPacketPayload {
        public static final Type<ToggleFellerAbilityPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "toggle_feller_mode_ability"));

        public static final StreamCodec<FriendlyByteBuf, ToggleFellerAbilityPayload> CODEC =
                StreamCodec.unit(new ToggleFellerAbilityPayload());

        @Override
        public @NotNull Type<ToggleFellerAbilityPayload> type() { return TYPE; }
    }
}
