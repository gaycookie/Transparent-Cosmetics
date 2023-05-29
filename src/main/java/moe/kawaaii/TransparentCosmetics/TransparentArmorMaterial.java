package moe.kawaaii.TransparentCosmetics;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TransparentArmorMaterial implements ArmorMaterial {
  @Override
  public int getDurability(ArmorItem.Type type) {
    return 0;
  }

  @Override
  public int getProtection(ArmorItem.Type type) {
    return 0;
  }

  @Override
  public int getEnchantability() {
    return 0;
  }

  @Override
  public SoundEvent getEquipSound() {
    return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
  }

  @Override
  public float getKnockbackResistance() {
    return 0;
  }

  @Override
  public String getName() {
    return "transparent";
  }

  @Override
  public Ingredient getRepairIngredient() {
    return null;
  }

  @Override
  public float getToughness() {
    return 0;
  }  
}
