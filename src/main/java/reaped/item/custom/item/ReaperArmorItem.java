package reaped.item.custom.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import reaped.item.custom.tier.ModArmorMaterials;

import java.util.List;

public class ReaperArmorItem extends ArmorItem {
    public ReaperArmorItem(Type type, Properties properties) {
        super(ModArmorMaterials.REAPER, type, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.reaped.reaper_armor_1"));
        components.add(Component.translatable("tooltip.reaped.reaper_armor_2"));
    }
}
