execute positioned ^ ^ ^0.1 if block ~ ~ ~ #minecraft:air run return run function creative_building_blocks:place_end_gateway/raytrace
execute positioned ^ ^ ^0.1 unless block ~ ~ ~ #minecraft:air positioned ^ ^ ^-0.1 run setblock ~ ~ ~ end_gateway
