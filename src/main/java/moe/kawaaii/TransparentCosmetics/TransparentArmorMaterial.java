package moe.kawaaii.TransparentCosmetics;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TransparentArmorMaterial implements ArmorMaterial {
  @Override
  public int getDurability(EquipmentSlot slot) {
    return 0;
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
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
