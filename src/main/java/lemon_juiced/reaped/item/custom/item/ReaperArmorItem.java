package lemon_juiced.reaped.item.custom.item;

import lemon_juiced.reaped.item.custom.tier.ModArmorMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ReaperArmorItem extends ArmorItem {
    public ReaperArmorItem(Type type, Properties properties) {
        super(ModArmorMaterials.REAPER, type, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.reaped.reaper_armor_1"));
        components.add(Component.translatable("tooltip.reaped.reaper_armor_2"));
    }
}
