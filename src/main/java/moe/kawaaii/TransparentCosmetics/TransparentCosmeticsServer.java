package moe.kawaaii.TransparentCosmetics;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

public class TransparentCosmeticsServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        TransparentCosmetics.registerItems();
        TransparentCosmetics.createItemGroup();
        TransparentCosmetics.createDataPack();
    }
}
