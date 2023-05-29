package moe.kawaaii.TransparentCosmetics;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TransparentCosmeticsMain implements ModInitializer {
	public static final String MODID = "transparent_cosmetics";
	public static final Item INGOT = new Item(new FabricItemSettings().maxCount(64));

	public static final ArmorMaterial MATERIAL = new TransparentArmorMaterial();
	public static final Item HELMET = new ArmorItem(MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings().maxCount(1));
	public static final Item CHESTPLATE = new ArmorItem(MATERIAL, EquipmentSlot.CHEST, new FabricItemSettings().maxCount(1));
	public static final Item LEGGINGS = new ArmorItem(MATERIAL, EquipmentSlot.LEGS, new FabricItemSettings().maxCount(1));
	public static final Item BOOTS = new ArmorItem(MATERIAL, EquipmentSlot.FEET, new FabricItemSettings().maxCount(1));

	@Override
	public void onInitialize() {
		registerItems();
		createItemGroup();
	}

	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(MODID, "transparent_ingot"), INGOT);
		Registry.register(Registries.ITEM, new Identifier(MODID, "helmet"), HELMET);
		Registry.register(Registries.ITEM, new Identifier(MODID, "chestplate"), CHESTPLATE);
		Registry.register(Registries.ITEM, new Identifier(MODID, "leggings"), LEGGINGS);
		Registry.register(Registries.ITEM, new Identifier(MODID, "boots"), BOOTS);
	}

	public static void createItemGroup() {
		FabricItemGroup.builder(new Identifier(MODID, "items")).icon(() -> new ItemStack(CHESTPLATE)).build();
		ItemGroupEvents.modifyEntriesEvent(new Identifier(MODID, "items")).register(content -> {
			content.add(new ItemStack(INGOT));
			content.add(new ItemStack(HELMET));
			content.add(new ItemStack(CHESTPLATE));
			content.add(new ItemStack(LEGGINGS));
			content.add(new ItemStack(BOOTS));
		});
	}
}
