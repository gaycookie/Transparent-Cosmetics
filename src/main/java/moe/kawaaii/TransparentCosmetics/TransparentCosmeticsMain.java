package moe.kawaaii.TransparentCosmetics;

import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		createDataPack();
	}

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "transparent_ingot"), INGOT);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helmet"), HELMET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "chestplate"), CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "leggings"), LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MODID, "boots"), BOOTS);
	}

	public static void createAssetPack() {
		Artifice.registerAssetPack(new Identifier(MODID), pack -> {
			pack.addItemModel(Registry.ITEM.getId(INGOT), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/transparent_ingot"));
			});
			pack.addItemModel(Registry.ITEM.getId(HELMET), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/transparent_helmet"));
			});
			pack.addItemModel(Registry.ITEM.getId(CHESTPLATE), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/transparent_chestplate"));
			});
			pack.addItemModel(Registry.ITEM.getId(LEGGINGS), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/transparent_leggings"));
			});
			pack.addItemModel(Registry.ITEM.getId(BOOTS), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/transparent_boots"));
			});
		});
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

	public static void createDataPack() {
		Artifice.registerDataPack(new Identifier(MODID), pack -> {
			pack.addBlastingRecipe(new Identifier(MODID, "ingot"), processor -> {
				processor.ingredientItem(new Identifier("minecraft", "glass"));
				processor.experience(0.10);
				processor.cookingTime(600);
				processor.result(Registry.ITEM.getId(INGOT));
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "transparent_helmet"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("GGG", "G G");
				processor.result(Registry.ITEM.getId(HELMET), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "transparent_chestplate"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("G G", "GGG", "GGG");
				processor.result(Registry.ITEM.getId(CHESTPLATE), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "transparent_leggings"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("GGG", "G G", "G G");
				processor.result(Registry.ITEM.getId(LEGGINGS), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "transparent_boots"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("   ", "G G", "G G");
				processor.result(Registry.ITEM.getId(BOOTS), 1);
				processor.build();
			});
		});
	}
}
