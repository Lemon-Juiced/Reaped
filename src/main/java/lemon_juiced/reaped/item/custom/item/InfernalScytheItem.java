package lemon_juiced.reaped.item.custom.item;

import lemon_juiced.reaped.item.custom.tier.ReapedTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class InfernalScytheItem extends DurabilitylessSwordItem {

    public InfernalScytheItem(Item.Properties properties) {
        super(ReapedTiers.INFERNAL_SCYTHE_TIER, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_1").withStyle(ChatFormatting.RED));
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_2").withStyle(ChatFormatting.BLUE));
    }
}