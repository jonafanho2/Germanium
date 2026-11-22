package com.example.germaniummod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class GermaniumClient implements ClientModInitializer {
    public static final String MOD_ID = "germaniummod";

    // 1. Define the modern EntityModelLayer
    public static final EntityModelLayer GERMANIUM_GOLEM_LAYER =
        new EntityModelLayer(Identifier.of(MOD_ID, "germanium_golem"), "main");

    @Override
    public void onInitializeClient() {
        // 2. Register the model layer & geometry
        EntityModelLayerRegistry.registerModelLayer(
            GERMANIUM_GOLEM_LAYER,
            GermaniumEntityModel::getTexturedModelData
        );
    }

    // 3. Modern EntityModel using EntityRenderState (1.21.2+ / 26.x)
    public static class GermaniumEntityModel extends EntityModel<LivingEntityRenderState> {
        private final ModelPart root;

        public GermaniumEntityModel(ModelPart root) {
            super(root);
            this.root = root.getChild("root");
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData partData = modelData.getRoot();
            partData.addChild(
                "root",
                ModelPartBuilder.create()
                    .uv(0, 0)
                    .cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, Dilation.NONE),
                ModelTransform.origin(0.0F, 24.0F, 0.0F)
            );
            return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(LivingEntityRenderState state) {
            super.setAngles(state);
            // Apply modern state-driven animations here
        }
    }
}
