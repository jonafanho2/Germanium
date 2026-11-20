package com.example.germaniummod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final RegistryKey<Item> GERMANIUM_INGOT_KEY = RegistryKey.of(
        RegistryKeys.ITEM, Identifier.of("germaniummod", "germanium_ingot")
    );

    public static final Item GERMANIUM_INGOT = Registry.register(
        Registries.ITEM,
        GERMANIUM_INGOT_KEY,
        new Item(new Item.Settings().registryKey(GERMANIUM_INGOT_KEY))
    );

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GERMANIUM_INGOT);
        });
    }
}
