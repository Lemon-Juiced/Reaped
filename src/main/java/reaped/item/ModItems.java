package reaped.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reaped.Reaped;
import reaped.item.custom.item.ReaperArmorItem;
import reaped.item.custom.item.ScytheItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reaped.MOD_ID);

    public static final RegistryObject<Item> BLACK_CLOTH = ITEMS.register("black_cloth", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STEEL_ALLOY_STACK = ITEMS.register("nether_steel_alloy_stack", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STEEL_INGOT = ITEMS.register("nether_steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STEEL_NUGGET = ITEMS.register("nether_steel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_STAFF = ITEMS.register("wooden_staff", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCYTHE = ITEMS.register("scythe", () -> new ScytheItem(new Item.Properties()));

    public static final RegistryObject<Item> REAPER_HOOD = ITEMS.register("reaper_hood", () -> new ReaperArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REAPER_CLOAK = ITEMS.register("reaper_cloak", () -> new ReaperArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REAPER_GRIEVES = ITEMS.register("reaper_grieves", () -> new ReaperArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REAPER_BOOTS = ITEMS.register("reaper_boots", () -> new ReaperArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
