package reaped.item.custom.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import reaped.item.custom.tier.ModTiers;

import java.util.List;

public class InfernalScytheItem extends SwordItem {

    public InfernalScytheItem(Properties properties) {
        super(ModTiers.SCYTHE_TIER, 4, -2.7f, properties);
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_1").withStyle(ChatFormatting.RED));
        components.add(Component.translatable("tooltip.reaped.infernal_scythe_2").withStyle(ChatFormatting.BLUE));
    }
}
