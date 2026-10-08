package com.carrot.item;

import com.carrot.MoreCarrotMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class Moditem {
	public static final Item ICE_ETHER = registerItems("ice_ether", new Item.Properties());
	public static final Item CARROT = registerItems("carrot", new Item.Properties());

	// 1.21 的 ItemGroups.INGREDIENTS 在 26.3 变成了不公开的字段，
	// 现在用「创造模式标签页的 ResourceKey」来定位（fabric-creative-tab-api-v1）。
	private static final ResourceKey<CreativeModeTab> INGREDIENTS_TAB = ResourceKey.create(
			Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("minecraft", "ingredients"));

	private static void addItemToIG0(FabricCreativeModeTabOutput output) {
		// output.accept(ICE_ETHER);
	}

	private static void addItemToIG1(FabricCreativeModeTabOutput output) {
		// output.accept(CARROT);
	}

	// 26.3 起 Item 在构造时就要知道自己的注册表 id（否则抛 "Item id not set"），
	// 所以这里先建 ResourceKey，用 setId 塞进 Properties 再 new Item。
	private static Item registerItems(String name, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, MoreCarrotMod.id(name));

		return Registry.register(BuiltInRegistries.ITEM, key, new Item(properties.setId(key)));
	}

	public static void registerModItem() {
		CreativeModeTabEvents.modifyOutputEvent(INGREDIENTS_TAB).register(Moditem::addItemToIG0);
		CreativeModeTabEvents.modifyOutputEvent(INGREDIENTS_TAB).register(Moditem::addItemToIG1);
	}
}
