package reaped.item.custom.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import reaped.item.custom.tier.ModArmorMaterials;

public class ReaperCloakItem extends ReaperArmorItem {
    public ReaperCloakItem(Properties properties) {
        super(ArmorItem.Type.CHESTPLATE, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(hasCorrectArmorOn(player)){
            if(hasFullSetOfArmorOn(player)){
                if(!player.isCreative() && !player.isSpectator()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
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
        ArmorMaterial material = ModArmorMaterials.REAPER;
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

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
