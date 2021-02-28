package moe.kawaaii.TransparentCosmetics;

import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TransparentCosmetics implements ModInitializer {

	public static final String MODID = "transparent_cosmetics";
	private static final Item INGOT = new Item(new FabricItemSettings().maxCount(64));
	private static final Item HELMET = new Item(new FabricItemSettings().maxCount(1));
	private static final Item CHESTPLATE = new Item(new FabricItemSettings().maxCount(1));
	private static final Item LEGGINGS = new Item(new FabricItemSettings().maxCount(1));
	private static final Item BOOTS = new Item(new FabricItemSettings().maxCount(1));

	@Override
	public void onInitialize() {
		registerItems();
		createAssetPack();
		createItemGroup();
		createDataPack();
	}

	public void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "transparent_ingot"), INGOT);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helmet"), HELMET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "chestplate"), CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "leggings"), LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MODID, "boots"), BOOTS);
	}

	public void createAssetPack() {
		Artifice.registerAssetPack(new Identifier(MODID, "transparent_asset_pack"), pack -> {
			pack.addItemModel(Registry.ITEM.getId(INGOT), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/ingot"));
			});
			pack.addItemModel(Registry.ITEM.getId(HELMET), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/helmet"));
			});
			pack.addItemModel(Registry.ITEM.getId(CHESTPLATE), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/chestplate"));
			});
			pack.addItemModel(Registry.ITEM.getId(LEGGINGS), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/leggings"));
			});
			pack.addItemModel(Registry.ITEM.getId(BOOTS), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/boots"));
			});
		});
	}

	public void createItemGroup() {
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

	public void createDataPack() {
		Artifice.registerDataPack(new Identifier(MODID, "transparent_pack"), pack -> {
			pack.addItemTag(new Identifier("curios", "cosmetic_helmet"), tag -> tag.value(Registry.ITEM.getId(HELMET)));
			pack.addItemTag(new Identifier("curios", "cosmetic_chestplate"), tag -> tag.value(Registry.ITEM.getId(CHESTPLATE)));
			pack.addItemTag(new Identifier("curios", "cosmetic_leggings"), tag -> tag.value(Registry.ITEM.getId(LEGGINGS)));
			pack.addItemTag(new Identifier("curios", "cosmetic_boots"), tag -> tag.value(Registry.ITEM.getId(BOOTS)));

			pack.addBlastingRecipe(new Identifier(MODID, "ingot_recipe"), processor -> {
				processor.ingredientItem(new Identifier("minecraft", "glass"));
				processor.experience(0.10);
				processor.cookingTime(600);
				processor.result(Registry.ITEM.getId(INGOT));
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_helmet"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("GGG", "G G");
				processor.result(Registry.ITEM.getId(HELMET), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_chestplate"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("G G", "GGG", "GGG");
				processor.result(Registry.ITEM.getId(CHESTPLATE), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_leggings"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("GGG", "G G", "G G");
				processor.result(Registry.ITEM.getId(LEGGINGS), 1);
				processor.build();
			});

			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_boots"), processor -> {
				processor.ingredientItem('G', Registry.ITEM.getId(INGOT));
				processor.pattern("   ", "G G", "G G");
				processor.result(Registry.ITEM.getId(BOOTS), 1);
				processor.build();
			});
		});
	}
}
