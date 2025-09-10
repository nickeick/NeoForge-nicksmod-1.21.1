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

    public record BonusData(String name, String skill, int cost) implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<BonusData> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "bonus_data"));

        public static final Codec<BonusData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("name").forGetter(BonusData::name),
                Codec.STRING.fieldOf("skill").forGetter(BonusData::skill),
                Codec.INT.fieldOf("cost").forGetter(BonusData::cost)
        ).apply(instance, BonusData::new));

        public static final StreamCodec<ByteBuf, BonusData> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8,
                        BonusData::name,
                        ByteBufCodecs.STRING_UTF8,
                        BonusData::skill,
                        ByteBufCodecs.VAR_INT,
                        BonusData::cost,
                        BonusData::new
                );

        @Override
        public @NotNull Type<? extends CustomPacketPayload> type() { return TYPE; }
    }

    public record ToggleAbilityPayload() implements CustomPacketPayload {
        public static final Type<ToggleAbilityPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "toggle_area_mode_ability"));

        public static final StreamCodec<FriendlyByteBuf, ToggleAbilityPayload> CODEC =
                StreamCodec.unit(new ToggleAbilityPayload());

        @Override
        public Type<ToggleAbilityPayload> type() { return TYPE; }
    }
}
