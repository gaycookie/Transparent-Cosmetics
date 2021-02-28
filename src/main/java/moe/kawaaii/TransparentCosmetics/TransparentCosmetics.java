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
		createRecipePack();
	}

	public void createAssetPack() {
		Artifice.registerAssetPack(new Identifier(MODID, "transparent_asset_pack"), pack -> {
			pack.addItemModel(new Identifier(MODID, "helmet"), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/helmet"));
			});
			pack.addItemModel(new Identifier(MODID, "chestplate"), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/chestplate"));
			});
			pack.addItemModel(new Identifier(MODID, "leggings"), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/leggings"));
			});
			pack.addItemModel(new Identifier(MODID, "boots"), model -> {
				model.parent(new Identifier("minecraft:item/generated"));
				model.texture("layer0", new Identifier(MODID, "item/boots"));
			});
		});
	}

	public void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "helmet"), HELMET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "chestplate"), CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "leggings"), LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MODID, "boots"), BOOTS);
	}

	public void createItemGroup() {
		FabricItemGroupBuilder.create(new Identifier(MODID, "items"))
				.icon(() -> new ItemStack(CHESTPLATE))
				.appendItems(itemStacks -> {
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
		});
	}

	public void createRecipePack() {
		Artifice.registerDataPack(new Identifier(MODID, "transparent_recipe_pack"), pack -> {
			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_helmet"), processor -> {
				processor.ingredientItem('G', new Identifier("minecraft", "glass_pane"));
				processor.pattern("GGG", "G G");
				processor.result(new Identifier(MODID, "helmet"), 1);
				processor.build();
			});
			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_chestplate"), processor -> {
				processor.ingredientItem('G', new Identifier("minecraft", "glass_pane"));
				processor.pattern("G G", "GGG", "GGG");
				processor.result(new Identifier(MODID, "chestplate"), 1);
				processor.build();
			});
			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_leggings"), processor -> {
				processor.ingredientItem('G', new Identifier("minecraft", "glass_pane"));
				processor.pattern("GGG", "G G", "G G");
				processor.result(new Identifier(MODID, "leggings"), 1);
				processor.build();
			});
			pack.addShapedRecipe(new Identifier(MODID, "recipe_transparent_boots"), processor -> {
				processor.ingredientItem('G', new Identifier("minecraft", "glass_pane"));
				processor.pattern("   ", "G G", "G G");
				processor.result(new Identifier(MODID, "boots"), 1);
				processor.build();
			});
		});
	}
}
