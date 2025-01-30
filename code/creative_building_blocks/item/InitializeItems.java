package com.example.docs.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import com.example.docs.FabricDocsReference;
import com.example.docs.item.armor.GuiditeArmorMaterial;
import com.example.docs.item.custom.LightningStick;
import com.example.docs.item.tool.GuiditeMaterial;

// :::1
public class ModItems {
	// :::1

	// :::6
	public static final Item END_GATEWAY_PLACER = register(new ArmorItem(GuiditeArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings()), "end_gateway_placer");
	// :::7
	// :::9
	public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(FabricDocsReference.MOD_ID, "item_group"));
	public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModItems.END_GATEWAY_PLACER))
			.displayName(Text.translatable("itemGroup.fabric_docs_reference"))
			.build();
	// :::9

	// :::1
	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = new Identifier(FabricDocsReference.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}

	// :::1

	// :::3
	public static void initialize() {
		// :::3
		// :::4
		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.

		// :::4

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
				.register((itemGroup) -> {
					itemGroup.add(ModItems.GUIDITE_HELMET);
				});

		// :::8
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
				.register((itemGroup) -> itemGroup.add(ModItems.GUIDITE_SWORD));
		// :::8

		// :::_12
		// Register the group.
		Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

		// Register items to the custom item group.
		ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
			itemGroup.add(ModItems.END_GATEWAY_PLACER);
			// ...
		});
		// :::_12

		// :::_10
		// Add the suspicious substance to the composting registry with a 30% chance of increasing the composter's level.
		//CompostingChanceRegistry.INSTANCE.add(ModItems.SUSPICIOUS_SUBSTANCE, 0.3f);
		// :::_10

		// :::_11
		// Add the suspicious substance to the flammable block registry with a burn time of 30 seconds.
		// Remember, Minecraft deals with logical based-time using ticks.
		// 20 ticks = 1 second.
		//FuelRegistry.INSTANCE.add(ModItems.GUIDITE_SWORD, 30 * 20);
		// :::_11
		// :::3
	}

	// :::3
}
// :::1
