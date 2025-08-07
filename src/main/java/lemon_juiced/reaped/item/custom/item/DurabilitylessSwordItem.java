package lemon_juiced.reaped.item.custom.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;

/**
 * A custom SwordItem subclass that has no durability.
 */
public class DurabilitylessSwordItem extends SwordItem {

    public DurabilitylessSwordItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true; // Allow attacking enemies without durability loss
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        return true; // Allow mining blocks without durability loss
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false; // Prevent durability
    }

}