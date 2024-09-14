package lemon_juiced.reaped.item.custom.tier;

import lemon_juiced.reaped.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;


/**
 * Contains the Tiers for Items specific to Reaped
 *
 * Vanilla Tiers (for comparison):
 * WOOD(0, 59, 2.0F, 0.0F, 15, () -> {return Ingredient.of(ItemTags.PLANKS);}),
 * STONE(1, 131, 4.0F, 1.0F, 5, () -> {return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);}),
 * IRON(2, 250, 6.0F, 2.0F, 14, () -> {return Ingredient.of(Items.IRON_INGOT);}),
 * DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {return Ingredient.of(Items.DIAMOND);}),
 * GOLD(0, 32, 12.0F, 0.0F, 22, () -> {return Ingredient.of(Items.GOLD_INGOT);}),
 * NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {return Ingredient.of(Items.NETHERITE_INGOT);});
 */
public class ModTiers {
    public static final Tier SCYTHE_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, Integer.MAX_VALUE, 8.0F, 5.0F, 15, () -> Ingredient.of(ModItems.INFERNAL_STEEL_INGOT.get()));
}
