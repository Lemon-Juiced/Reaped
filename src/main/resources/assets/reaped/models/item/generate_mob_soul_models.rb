require 'json'

mob_souls = %w[
  allay armadillo axolotl bat camel cat chicken cod cow donkey frog glow_squid
  horse mooshroom mule ocelot parrot pig pufferfish rabbit salmon sheep skeleton_horse
  sniffer snow_golem squid strider tadpole tropical_fish turtle villager wandering_trader
  bee cave_spider dolphin enderman fox goat iron_golem llama panda piglin polar_bear
  spider wolf zombified_piglin blaze bogged breeze creeper drowned elder_guardian
  endermite evoker ghast guardian hoglin husk magma_cube phantom piglin_brute pillager
  ravager shulker silverfish skeleton slime stray vex vindicator warden witch
  wither_skeleton zoglin zombie
]

mob_souls.each do |mob|
  model = {
    "parent" => "item/generated",
    "textures" => {
      "layer0" => "reaped:item/mob_soul_background",
      "layer1" => "minecraft:item/#{mob}_spawn_egg"
    }
  }
  File.write("./#{mob}_soul.json", JSON.pretty_generate(model))
end
