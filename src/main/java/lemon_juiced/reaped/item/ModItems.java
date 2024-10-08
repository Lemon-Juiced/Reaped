package lemon_juiced.reaped.item;

import lemon_juiced.reaped.item.custom.item.InfernalScytheItem;
import lemon_juiced.reaped.item.custom.item.IronScytheItem;
import lemon_juiced.reaped.item.custom.item.ReaperArmorItem;
import lemon_juiced.reaped.item.custom.item.ReaperCloakItem;
import lemon_juiced.reaped.item.custom.tier.ModTiers;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static lemon_juiced.reaped.Reaped.MOD_ID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final Supplier<Item> BLACK_CLOTH = ITEMS.register("black_cloth", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_ALLOY_STACK = ITEMS.register("infernal_steel_alloy_stack", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_INGOT = ITEMS.register("infernal_steel_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_NUGGET = ITEMS.register("infernal_steel_nugget", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> WOODEN_STAFF = ITEMS.register("wooden_staff", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> IRON_SCYTHE = ITEMS.register("iron_scythe", () -> new IronScytheItem(new Item.Properties().attributes(IronScytheItem.createAttributes(Tiers.IRON, -2.0F, -1.0F))));
    public static final Supplier<Item> INFERNAL_SCYTHE = ITEMS.register("infernal_scythe", () -> new InfernalScytheItem(new Item.Properties().attributes(InfernalScytheItem.createAttributes(ModTiers.SCYTHE_TIER, 4, -2.7f)).fireResistant()));

    public static final Supplier<Item> REAPER_HOOD = ITEMS.register("reaper_hood", () -> new ReaperArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<Item> REAPER_CLOAK = ITEMS.register("reaper_cloak", () -> new ReaperCloakItem(new Item.Properties()));
    public static final Supplier<Item> REAPER_GRIEVES = ITEMS.register("reaper_grieves", () -> new ReaperArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Supplier<Item> REAPER_BOOTS = ITEMS.register("reaper_boots", () -> new ReaperArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
