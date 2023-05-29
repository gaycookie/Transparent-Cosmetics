package moe.kawaaii.TransparentCosmetics;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
		Registry.register(Registry.ITEM, new Identifier(MODID, "transparent_ingot"), INGOT);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helmet"), HELMET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "chestplate"), CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "leggings"), LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MODID, "boots"), BOOTS);
	}

	public static void createItemGroup() {
		FabricItemGroupBuilder.create(new Identifier(MODID, "items"))
			.icon(() -> new ItemStack(CHESTPLATE))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(INGOT));
				itemStacks.add(new ItemStack(HELMET));
				itemStacks.add(new ItemStack(CHESTPLATE));
				itemStacks.add(new ItemStack(LEGGINGS));
				itemStacks.add(new ItemStack(BOOTS));
			}).build();
	}
}
