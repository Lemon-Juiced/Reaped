package lemon_juiced.reaped.item;

import lemon_juiced.reaped.item.custom.item.*;
import lemon_juiced.reaped.item.custom.item.SoulItem;
import lemon_juiced.reaped.item.custom.tier.ReapedTiers;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static lemon_juiced.reaped.Reaped.MOD_ID;

public class ReapedItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final Supplier<Item> BLACK_CLOTH = ITEMS.register("black_cloth", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLDEN_EGG = ITEMS.register("golden_egg", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_ALLOY_STACK = ITEMS.register("infernal_steel_alloy_stack", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_INGOT = ITEMS.register("infernal_steel_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> INFERNAL_STEEL_NUGGET = ITEMS.register("infernal_steel_nugget", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SOUL_STEEL_INGOT = ITEMS.register("soul_steel_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SOUL_STEEL_NUGGET = ITEMS.register("soul_steel_nugget", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SPIRIT_BOX = ITEMS.register("spirit_box", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> WOODEN_STAFF = ITEMS.register("wooden_staff", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> IRON_SCYTHE = ITEMS.register("iron_scythe", () -> new IronScytheItem(new Item.Properties().attributes(IronScytheItem.createAttributes(Tiers.IRON, -2.0F, -1.0F))));
    public static final Supplier<Item> INFERNAL_SCYTHE = ITEMS.register("infernal_scythe", () -> new InfernalScytheItem(new Item.Properties().attributes(InfernalScytheItem.createAttributes(ReapedTiers.INFERNAL_SCYTHE_TIER, 4, -2.7f)).fireResistant()));
    public static final Supplier<Item> SOUL_SCYTHE = ITEMS.register("soul_scythe", () -> new SoulScytheItem(new Item.Properties().attributes(SoulScytheItem.createAttributes(ReapedTiers.SOUL_SCYTHE_TIER, 4, -2.7f))));

    public static final Supplier<Item> REAPER_HOOD = ITEMS.register("reaper_hood", () -> new ReaperArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<Item> REAPER_CLOAK = ITEMS.register("reaper_cloak", () -> new ReaperCloakItem(new Item.Properties()));
    public static final Supplier<Item> REAPER_GRIEVES = ITEMS.register("reaper_grieves", () -> new ReaperArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Supplier<Item> REAPER_BOOTS = ITEMS.register("reaper_boots", () -> new ReaperArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    // Souls
    public static final Supplier<Item> ALLAY_SOUL = ITEMS.register("allay_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ARMADILLO_SOUL = ITEMS.register("armadillo_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> AXOLOTL_SOUL = ITEMS.register("axolotl_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> BAT_SOUL = ITEMS.register("bat_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> BEE_SOUL = ITEMS.register("bee_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> BLAZE_SOUL = ITEMS.register("blaze_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> BOGGED_SOUL = ITEMS.register("bogged_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> BREEZE_SOUL = ITEMS.register("breeze_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> CAMEL_SOUL = ITEMS.register("camel_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> CAT_SOUL = ITEMS.register("cat_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> CAVE_SPIDER_SOUL = ITEMS.register("cave_spider_soul", () -> new SoulItem(new Item.Properties()));
    // public static final Supplier<Item> COPPER_GOLEM_SOUL = ITEMS.register("copper_golem_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> CHICKEN_SOUL = ITEMS.register("chicken_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> COD_SOUL = ITEMS.register("cod_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> COW_SOUL = ITEMS.register("cow_soul", () -> new SoulItem(new Item.Properties()));
    // public static final Supplier<Item> CREAKING_SOUL = ITEMS.register("creaking_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> CREEPER_SOUL = ITEMS.register("creeper_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> DOLPHIN_SOUL = ITEMS.register("dolphin_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> DONKEY_SOUL = ITEMS.register("donkey_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> DROWNED_SOUL = ITEMS.register("drowned_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ELDER_GUARDIAN_SOUL = ITEMS.register("elder_guardian_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ENDERMAN_SOUL = ITEMS.register("enderman_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ENDERMITE_SOUL = ITEMS.register("endermite_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> EVOKER_SOUL = ITEMS.register("evoker_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> FOX_SOUL = ITEMS.register("fox_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> FROG_SOUL = ITEMS.register("frog_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> GHAST_SOUL = ITEMS.register("ghast_soul", () -> new SoulItem(new Item.Properties()));
    // public static final Supplier<Item> GHASTLING_SOUL = ITEMS.register("ghastling_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> GLOW_SQUID_SOUL = ITEMS.register("glow_squid_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> GOAT_SOUL = ITEMS.register("goat_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> GUARDIAN_SOUL = ITEMS.register("guardian_soul", () -> new SoulItem(new Item.Properties()));
    // public static final Supplier<Item> HAPPY_GHAST_SOUL = ITEMS.register("happy_ghast_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> HOGLIN_SOUL = ITEMS.register("hoglin_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> HORSE_SOUL = ITEMS.register("horse_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> HUSK_SOUL = ITEMS.register("husk_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> IRON_GOLEM_SOUL = ITEMS.register("iron_golem_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> LLAMA_SOUL = ITEMS.register("llama_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> MAGMA_CUBE_SOUL = ITEMS.register("magma_cube_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> MOOSHROOM_SOUL = ITEMS.register("mooshroom_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> MULE_SOUL = ITEMS.register("mule_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> OCELOT_SOUL = ITEMS.register("ocelot_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PANDA_SOUL = ITEMS.register("panda_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PARROT_SOUL = ITEMS.register("parrot_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PHANTOM_SOUL = ITEMS.register("phantom_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PIG_SOUL = ITEMS.register("pig_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PIGLIN_SOUL = ITEMS.register("piglin_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PIGLIN_BRUTE_SOUL = ITEMS.register("piglin_brute_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PILLAGER_SOUL = ITEMS.register("pillager_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> POLAR_BEAR_SOUL = ITEMS.register("polar_bear_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> PUFFERFISH_SOUL = ITEMS.register("pufferfish_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> RABBIT_SOUL = ITEMS.register("rabbit_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> RAVAGER_SOUL = ITEMS.register("ravager_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SALMON_SOUL = ITEMS.register("salmon_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SHEEP_SOUL = ITEMS.register("sheep_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SHULKER_SOUL = ITEMS.register("shulker_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SILVERFISH_SOUL = ITEMS.register("silverfish_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SKELETON_SOUL = ITEMS.register("skeleton_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SKELETON_HORSE_SOUL = ITEMS.register("skeleton_horse_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SLIME_SOUL = ITEMS.register("slime_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SNIFFER_SOUL = ITEMS.register("sniffer_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SNOW_GOLEM_SOUL = ITEMS.register("snow_golem_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SPIDER_SOUL = ITEMS.register("spider_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> SQUID_SOUL = ITEMS.register("squid_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> STRAY_SOUL = ITEMS.register("stray_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> STRIDER_SOUL = ITEMS.register("strider_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> TADPOLE_SOUL = ITEMS.register("tadpole_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> TROPICAL_FISH_SOUL = ITEMS.register("tropical_fish_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> TURTLE_SOUL = ITEMS.register("turtle_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> VEX_SOUL = ITEMS.register("vex_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> VILLAGER_SOUL = ITEMS.register("villager_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> VINDICATOR_SOUL = ITEMS.register("vindicator_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> WANDERING_TRADER_SOUL = ITEMS.register("wandering_trader_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> WARDEN_SOUL = ITEMS.register("warden_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> WITCH_SOUL = ITEMS.register("witch_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> WITHER_SKELETON_SOUL = ITEMS.register("wither_skeleton_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> WOLF_SOUL = ITEMS.register("wolf_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ZOGLIN_SOUL = ITEMS.register("zoglin_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ZOMBIE_SOUL = ITEMS.register("zombie_soul", () -> new SoulItem(new Item.Properties()));
    public static final Supplier<Item> ZOMBIFIED_PIGLIN_SOUL = ITEMS.register("zombified_piglin_soul", () -> new SoulItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
