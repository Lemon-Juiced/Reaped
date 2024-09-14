package lemon_juiced.reaped.creativetab;

import lemon_juiced.reaped.Reaped;
import lemon_juiced.reaped.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reaped.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REAPED_ITEMS_TAB = CREATIVE_MODE_TABS.register("reaped_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.items"))
            .icon(() -> new ItemStack(ModItems.BLACK_CLOTH.get()))
            .build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REAPED_ARSENAL_TAB = CREATIVE_MODE_TABS.register("reaped_arsenal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.arsenal"))
            .icon(() -> new ItemStack(ModItems.INFERNAL_SCYTHE.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == REAPED_ITEMS_TAB.get()) {
            event.accept(ModItems.BLACK_CLOTH.get());
            event.accept(ModItems.INFERNAL_STEEL_ALLOY_STACK.get());
            event.accept(ModItems.INFERNAL_STEEL_INGOT.get());
            event.accept(ModItems.INFERNAL_STEEL_NUGGET.get());
            event.accept(ModItems.WOODEN_STAFF.get());
        }
        else if (event.getTab() == REAPED_ARSENAL_TAB.get()) {
            event.accept(ModItems.INFERNAL_SCYTHE.get());
            event.accept(ModItems.IRON_SCYTHE.get());
            event.accept(ModItems.REAPER_HOOD.get());
            event.accept(ModItems.REAPER_CLOAK.get());
            event.accept(ModItems.REAPER_GRIEVES.get());
            event.accept(ModItems.REAPER_BOOTS.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
