package moe.kawaaii.TransparentCosmetics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class TransparentCosmeticsClient implements ClientModInitializer {
    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        TransparentCosmeticsMain.createAssetPack();
    }
}
