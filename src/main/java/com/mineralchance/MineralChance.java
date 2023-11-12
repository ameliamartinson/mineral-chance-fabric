package com.mineralchance;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class MineralChance implements ModInitializer {

    public static final Identifier STONE_LOOT_ID = new Identifier("minecraft", "blocks/stone");
    public static final Identifier NETHERRACK_LOOT_ID = new Identifier("minecraft", "blocks/netherrack");
    public static final float lootChance = 0.02f;

    @Override
    public void onInitialize() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (STONE_LOOT_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder();

                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.DIAMOND));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.REDSTONE));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.LAPIS_LAZULI));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.COAL));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.EMERALD));


                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, settler) -> {
            if (NETHERRACK_LOOT_ID.equals(id)) 
            {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder();
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.GOLD_NUGGET));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.QUARTZ));
                poolBuilder.rolls(BinomialLootTableRange.create(1, lootChance)).with(ItemEntry.builder(Items.NETHERITE_SCRAP));

                supplier.pool(poolBuilder);
            }
        });
    }

}
