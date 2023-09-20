package reaped.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import reaped.Reaped;
import reaped.item.ModItems;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reaped.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REAPED_ITEMS_TAB = CREATIVE_MODE_TABS.register("reaped_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.items"))
            .icon(() -> new ItemStack(ModItems.BLACK_CLOTH.get()))
            .build());

    public static final RegistryObject<CreativeModeTab> REAPED_ARSENAL_TAB = CREATIVE_MODE_TABS.register("reaped_arsenal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reaped.arsenal"))
            .icon(() -> new ItemStack(ModItems.SCYTHE.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == REAPED_ITEMS_TAB.get()) {
            event.accept(ModItems.BLACK_CLOTH.get());
            event.accept(ModItems.NETHER_STEEL_ALLOY_STACK.get());
            event.accept(ModItems.NETHER_STEEL_INGOT.get());
            event.accept(ModItems.NETHER_STEEL_NUGGET.get());
            event.accept(ModItems.WOODEN_STAFF.get());
        }
        else if (event.getTab() == REAPED_ARSENAL_TAB.get()) {
            event.accept(ModItems.SCYTHE.get());
            event.accept(ModItems.REAPER_HOOD.get());
            event.accept(ModItems.REAPER_CLOAK.get());
            event.accept(ModItems.REAPER_GRIEVES.get());
            event.accept(ModItems.REAPER_BOOTS.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
