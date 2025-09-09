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
  recipe = {
    "type" => "minecraft:crafting_shaped",
    "pattern" => [
      "E#E",
      "#S#",
      "E#E"
    ],
    "key" => {
      "E" => { "item" => "minecraft:#{mob}_spawn_egg" },
      "S" => { "item" => "reaped:spirit_box" },
      "#" => { "item" => "reaped:soul_steel_ingot" }
    },
    "result" => {
      "id" => "minecraft:spawner",
      "count" => 1
    }
  }
  File.write("./#{mob}_spawner.json", JSON.pretty_generate(recipe))
end