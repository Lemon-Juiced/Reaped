package lemon_juiced.reaped.item.custom.item;

import lemon_juiced.reaped.item.custom.tier.ModTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class InfernalScytheItem extends SwordItem {

    public InfernalScytheItem(Properties properties) {
        super(ModTiers.SCYTHE_TIER, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_1").withStyle(ChatFormatting.RED));
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_2").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Do nothing so that the scythe doesn't take damage
    }
}
