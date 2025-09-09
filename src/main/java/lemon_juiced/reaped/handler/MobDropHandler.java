package lemon_juiced.reaped.handler;

import lemon_juiced.reaped.item.ReapedItems;
import lemon_juiced.reaped.item.custom.item.InfernalScytheItem;
import lemon_juiced.reaped.item.custom.item.SoulScytheItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
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

            // Infernal Scythe (Mob Heads)
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
            }

            // Soul Scythe (Mob Souls)
            else if (itemInHand instanceof SoulScytheItem){
                if(checkMobDropConditions(entity, Allay.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ALLAY_SOUL.get())));
                if(checkMobDropConditions(entity, Armadillo.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ARMADILLO_SOUL.get())));
                if(checkMobDropConditions(entity, Axolotl.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.AXOLOTL_SOUL.get())));
                if(checkMobDropConditions(entity, Bat.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.BAT_SOUL.get())));
                if(checkMobDropConditions(entity, Bee.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.BEE_SOUL.get())));
                if(checkMobDropConditions(entity, Blaze.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.BLAZE_SOUL.get())));
                if(checkMobDropConditions(entity, Bogged.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.BOGGED_SOUL.get())));
                if(checkMobDropConditions(entity, Breeze.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.BREEZE_SOUL.get())));
                if(checkMobDropConditions(entity, Camel.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.CAMEL_SOUL.get())));
                if(checkMobDropConditions(entity, Cat.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.CAT_SOUL.get())));
                if(checkMobDropConditions(entity, CaveSpider.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.CAVE_SPIDER_SOUL.get())));
                if(checkMobDropConditions(entity, Chicken.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.CHICKEN_SOUL.get())));
                if(checkMobDropConditions(entity, Cod.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.COD_SOUL.get())));
                if(checkMobDropConditions(entity, Cow.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.COW_SOUL.get())));
                if(checkMobDropConditions(entity, Creeper.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.CREEPER_SOUL.get())));
                if(checkMobDropConditions(entity, Dolphin.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.DOLPHIN_SOUL.get())));
                if(checkMobDropConditions(entity, Donkey.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.DONKEY_SOUL.get())));
                if(checkMobDropConditions(entity, Drowned.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.DROWNED_SOUL.get())));
                if(checkMobDropConditions(entity, ElderGuardian.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ELDER_GUARDIAN_SOUL.get())));
                if(checkMobDropConditions(entity, EnderMan.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ENDERMAN_SOUL.get())));
                if(checkMobDropConditions(entity, Endermite.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ENDERMITE_SOUL.get())));
                if(checkMobDropConditions(entity, Evoker.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.EVOKER_SOUL.get())));
                if(checkMobDropConditions(entity, Fox.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.FOX_SOUL.get())));
                if(checkMobDropConditions(entity, Ghast.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.GHAST_SOUL.get())));
                if(checkMobDropConditions(entity, GlowSquid.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.GLOW_SQUID_SOUL.get())));
                if(checkMobDropConditions(entity, Goat.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.GOAT_SOUL.get())));
                if(checkMobDropConditions(entity, Guardian.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.GUARDIAN_SOUL.get())));
                if(checkMobDropConditions(entity, Hoglin.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.HOGLIN_SOUL.get())));
                if(checkMobDropConditions(entity, Horse.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.HORSE_SOUL.get())));
                if(checkMobDropConditions(entity, Husk.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.HUSK_SOUL.get())));
                if(checkMobDropConditions(entity, IronGolem.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.IRON_GOLEM_SOUL.get())));
                if(checkMobDropConditions(entity, Llama.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.LLAMA_SOUL.get())));
                if(checkMobDropConditions(entity, MagmaCube.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.MAGMA_CUBE_SOUL.get())));
                if(checkMobDropConditions(entity, MushroomCow.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.MOOSHROOM_SOUL.get())));
                if(checkMobDropConditions(entity, Mule.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.MULE_SOUL.get())));
                if(checkMobDropConditions(entity, Ocelot.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.OCELOT_SOUL.get())));
                if(checkMobDropConditions(entity, Panda.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PANDA_SOUL.get())));
                if(checkMobDropConditions(entity, Parrot.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PARROT_SOUL.get())));
                if(checkMobDropConditions(entity, Phantom.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PHANTOM_SOUL.get())));
                if(checkMobDropConditions(entity, Pig.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PIG_SOUL.get())));
                if(checkMobDropConditions(entity, Piglin.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PIGLIN_SOUL.get())));
                if(checkMobDropConditions(entity, PiglinBrute.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PIGLIN_BRUTE_SOUL.get())));
                if(checkMobDropConditions(entity, Pillager.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PILLAGER_SOUL.get())));
                if(checkMobDropConditions(entity, PolarBear.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.POLAR_BEAR_SOUL.get())));
                if(checkMobDropConditions(entity, Pufferfish.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.PUFFERFISH_SOUL.get())));
                if(checkMobDropConditions(entity, Rabbit.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.RABBIT_SOUL.get())));
                if(checkMobDropConditions(entity, Ravager.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.RAVAGER_SOUL.get())));
                if(checkMobDropConditions(entity, Salmon.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SALMON_SOUL.get())));
                if(checkMobDropConditions(entity, Sheep.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SHEEP_SOUL.get())));
                if(checkMobDropConditions(entity, Shulker.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SHULKER_SOUL.get())));
                if(checkMobDropConditions(entity, Silverfish.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SILVERFISH_SOUL.get())));
                if(checkMobDropConditions(entity, SkeletonHorse.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SKELETON_HORSE_SOUL.get())));
                if(checkMobDropConditions(entity, Skeleton.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SKELETON_SOUL.get())));
                if(checkMobDropConditions(entity, Slime.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SLIME_SOUL.get())));
                if(checkMobDropConditions(entity, Sniffer.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SNIFFER_SOUL.get())));
                if(checkMobDropConditions(entity, SnowGolem.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SNOW_GOLEM_SOUL.get())));
                if(checkMobDropConditions(entity, Spider.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SPIDER_SOUL.get())));
                if(checkMobDropConditions(entity, Squid.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.SQUID_SOUL.get())));
                if(checkMobDropConditions(entity, Stray.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.STRAY_SOUL.get())));
                if(checkMobDropConditions(entity, Strider.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.STRIDER_SOUL.get())));
                if(checkMobDropConditions(entity, Tadpole.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.TADPOLE_SOUL.get())));
                if(checkMobDropConditions(entity, TropicalFish.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.TROPICAL_FISH_SOUL.get())));
                if(checkMobDropConditions(entity, Turtle.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.TURTLE_SOUL.get())));
                if(checkMobDropConditions(entity, Vex.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.VEX_SOUL.get())));
                if(checkMobDropConditions(entity, Villager.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.VILLAGER_SOUL.get())));
                if(checkMobDropConditions(entity, Vindicator.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.VINDICATOR_SOUL.get())));
                if(checkMobDropConditions(entity, WanderingTrader.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.WANDERING_TRADER_SOUL.get())));
                if(checkMobDropConditions(entity, Warden.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.WARDEN_SOUL.get())));
                if(checkMobDropConditions(entity, Witch.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.WITCH_SOUL.get())));
                if(checkMobDropConditions(entity, WitherSkeleton.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.WITHER_SKELETON_SOUL.get())));
                if(checkMobDropConditions(entity, Wolf.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.WOLF_SOUL.get())));
                if(checkMobDropConditions(entity, Zoglin.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ZOGLIN_SOUL.get())));
                if(checkMobDropConditions(entity, Zombie.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ZOMBIE_SOUL.get())));
                if(checkMobDropConditions(entity, ZombifiedPiglin.class, mobDropChance))
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ReapedItems.ZOMBIFIED_PIGLIN_SOUL.get())));
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
