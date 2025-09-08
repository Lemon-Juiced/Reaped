package lemon_juiced.reaped.creativetab;

import lemon_juiced.reaped.Reaped;
import lemon_juiced.reaped.item.ReapedItems;
import lemon_juiced.reaped.item.custom.item.SoulItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ReapedCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reaped.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REAPED_ITEMS_TAB = CREATIVE_MODE_TABS.register("reaped_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.items"))
            .icon(() -> new ItemStack(ReapedItems.BLACK_CLOTH.get()))
            .build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REAPED_ARSENAL_TAB = CREATIVE_MODE_TABS.register("reaped_arsenal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.arsenal"))
            .icon(() -> new ItemStack(ReapedItems.INFERNAL_SCYTHE.get()))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REAPED_SOULS_TAB = CREATIVE_MODE_TABS.register("reaped_souls", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.souls"))
            .icon(() -> new ItemStack(ReapedItems.SOUL_SCYTHE.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == REAPED_ITEMS_TAB.get()) {
            event.accept(ReapedItems.BLACK_CLOTH.get());
            event.accept(ReapedItems.GOLDEN_EGG.get());
            event.accept(ReapedItems.INFERNAL_STEEL_ALLOY_STACK.get());
            event.accept(ReapedItems.INFERNAL_STEEL_INGOT.get());
            event.accept(ReapedItems.INFERNAL_STEEL_NUGGET.get());
            event.accept(ReapedItems.SOUL_STEEL_INGOT.get());
            event.accept(ReapedItems.SOUL_STEEL_NUGGET.get());
            event.accept(ReapedItems.WOODEN_STAFF.get());
        }
        else if (event.getTab() == REAPED_ARSENAL_TAB.get()) {
            event.accept(ReapedItems.INFERNAL_SCYTHE.get());
            event.accept(ReapedItems.IRON_SCYTHE.get());
            event.accept(ReapedItems.SOUL_SCYTHE.get());
            event.accept(ReapedItems.REAPER_HOOD.get());
            event.accept(ReapedItems.REAPER_CLOAK.get());
            event.accept(ReapedItems.REAPER_GRIEVES.get());
            event.accept(ReapedItems.REAPER_BOOTS.get());
        } else if (event.getTab() == REAPED_SOULS_TAB.get()) {
            for (DeferredHolder<Item, ? extends Item> item : ReapedItems.ITEMS.getEntries())
                if (item.get() instanceof SoulItem) event.accept(item.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
