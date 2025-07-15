package com.nickkick.nicksmod.data_map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nickkick.nicksmod.NicksMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

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
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    public static DataMapType<EntityType<?>, SkillData> SKILL_DATA;

}
