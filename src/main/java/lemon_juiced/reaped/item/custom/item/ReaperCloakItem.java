package lemon_juiced.reaped.item.custom.item;

import lemon_juiced.reaped.item.custom.tier.ReapedArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ReaperCloakItem extends ReaperArmorItem {
    public ReaperCloakItem(Properties properties) {
        super(Type.CHESTPLATE, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player) {
            if (slotId >= 36 && slotId <= 39) { // Check if the slot is one of the armor slots
                if (hasCorrectArmorOn(player)) {
                    if (hasFullSetOfArmorOn(player)) {
                        if (!player.isCreative() && !player.isSpectator()) {
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
                        }
                    }
                }
            }
        }
    }

    private boolean hasFullSetOfArmorOn(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Player player){
        DeferredHolder<ArmorMaterial, ArmorMaterial> material = ReapedArmorMaterials.REAPER;
        if(player.getInventory().getArmor(0).getItem() == Items.AIR ||
                (player.getInventory().getArmor(1).getItem() == Items.AIR) ||
                (player.getInventory().getArmor(2).getItem() == Items.AIR) ||
                (player.getInventory().getArmor(3).getItem() == Items.AIR)){
            return false; //Stop before hitting below and getting ClassCastException
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial().is(material) && chestplate.getMaterial().is(material) && leggings.getMaterial().is(material) && boots.getMaterial().is(material);
    }
}
