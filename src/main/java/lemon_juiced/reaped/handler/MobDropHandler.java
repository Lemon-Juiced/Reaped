package lemon_juiced.reaped.handler;

import lemon_juiced.reaped.item.ReapedItems;
import lemon_juiced.reaped.item.custom.item.InfernalScytheItem;
import lemon_juiced.reaped.item.custom.item.SoulScytheItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class MobDropHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event){
        var entity = event.getEntity();
        var level = event.getEntity().level();

        if(!level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) return;

        var drops = event.getDrops();
        var attacker = event.getSource().getEntity();
        int mobDropChance = 0; // Out of 100
        Random random = new Random();

        if(attacker instanceof Player playerEntity){
            Item itemInHand = playerEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();

            // Increments the mobDropChance by 5% per Reaper Armor Piece
            if (playerEntity.getInventory().getArmor(3).getItem() == ReapedItems.REAPER_HOOD.get()) mobDropChance += 5;
            if (playerEntity.getInventory().getArmor(2).getItem() == ReapedItems.REAPER_CLOAK.get()) mobDropChance += 5;
            if (playerEntity.getInventory().getArmor(1).getItem() == ReapedItems.REAPER_GRIEVES.get()) mobDropChance += 5;
            if (playerEntity.getInventory().getArmor(0).getItem() == ReapedItems.REAPER_BOOTS.get()) mobDropChance += 5;

            if (itemInHand instanceof InfernalScytheItem){
                if(checkMobDropConditions(entity, Creeper.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.CREEPER_HEAD)));

                if(checkMobDropConditions(entity, Piglin.class, mobDropChance) || checkMobDropConditions(entity, PiglinBrute.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.PIGLIN_HEAD)));

                if(checkMobDropConditions(entity, Skeleton.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.SKELETON_SKULL)));

                if(checkMobDropConditions(entity, WitherSkeleton.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.WITHER_SKELETON_SKULL)));

                if(checkMobDropConditions(entity, Zombie.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.ZOMBIE_HEAD)));

            } else if (itemInHand instanceof SoulScytheItem){
                if(checkMobDropConditions(entity, Zombie.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ZOMBIE_SOUL.get())));
            }
        }
    }

    /**
     * Check if a few conditions are true:
     * 1. The entity is an instance of the given mob class
     * 2. A random integer between 0 and 100 is less than the mobHeadDropChance
     *
     * @param entity The entity that was killed
     * @param mobClass The mob class to check against
     * @param mobHeadDropChance The chance out of 100 that the mob head will drop
     * @return true if the mob drop conditions are met, false otherwise
     */
    public static boolean checkMobDropConditions(LivingEntity entity, Class<? extends LivingEntity> mobClass, int mobHeadDropChance){
        Random random = new Random();
        return mobClass.isInstance(entity) && random.nextInt(0, 100) < mobHeadDropChance;
    }
}
