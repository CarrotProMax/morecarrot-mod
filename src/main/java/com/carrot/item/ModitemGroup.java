package com.carrot.item;

import com.carrot.MoreCarrotMod;
import com.carrot.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

//自己的一个物品栏

public class ModitemGroup {
	public static final ResourceKey<CreativeModeTab> RADISH_GROUP_KEY = ResourceKey.create(
			Registries.CREATIVE_MODE_TAB, MoreCarrotMod.id("radish_group"));

	public static final CreativeModeTab RADISH_GROUP = Registry.register(
			BuiltInRegistries.CREATIVE_MODE_TAB,
			RADISH_GROUP_KEY,
			FabricCreativeModeTab.builder()
					.title(Component.translatable("itemGroup.radish_group"))
					.icon(() -> new ItemStack(Moditem.CARROT))
					.displayItems((displayContext, entries) -> {
						entries.accept(Moditem.CARROT);
						entries.accept(ModBlocks.CARROT_BLOCK);
						entries.accept(ModBlocks.TWO_LEVEL_CARROT_BLOCK);
						entries.accept(ModBlocks.THREE_LEVEL_CARROT_BLOCK);
						entries.accept(ModBlocks.GOLD_CARROT_BLOCK);
						entries.accept(ModBlocks.TWO_LEVEL_GOLD_CARROT_BLOCK);
						entries.accept(ModBlocks.THREE_LEVEL_GOLD_CARROT_BLOCK);
						entries.accept(ModBlocks.GOLD_CARROT_BLOCK_ORE);
					})
					.build());

	public static void registerModItemGroup() {

	}
}
