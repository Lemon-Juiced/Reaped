package lemon_juiced.reaped.item.custom.tier;

import lemon_juiced.reaped.Reaped;
import lemon_juiced.reaped.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, Reaped.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> REAPER = REGISTRY.register("reaper", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
            }),
            7, SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ModItems.INFERNAL_STEEL_INGOT.get()),
            List.of(
                    new ArmorMaterial.Layer(Reaped.resource("reaper"), "", false)
            ),
            1.0F, 0.0F
    ));
}