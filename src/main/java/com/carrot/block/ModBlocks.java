package com.carrot.block;

import java.util.Optional;

import com.carrot.MoreCarrotMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModBlocks {
	// 1.21 里的 FabricBlockSettings.copyOf(Blocks.X) 在 26.3 由 ofFullCopy 取代。
	// ofFullCopy 会连「战利品表」一起复制过去，所以下面再显式指回我们自己的
	// data/morecarrotmod/loot_table/blocks/<名字>.json，否则这些方块会掉原版方块
	// （比如卜块会掉地狱岩）。
	public static final Block CARROT_BLOCK = registerBlock("carrot_block", Blocks.NETHERRACK);
	public static final Block TWO_LEVEL_CARROT_BLOCK = registerBlock("two_level_carrot_block", Blocks.DIAMOND_BLOCK);
	public static final Block THREE_LEVEL_CARROT_BLOCK = registerBlock("three_level_carrot_block", Blocks.OBSIDIAN);
	public static final Block GOLD_CARROT_BLOCK = registerBlock("gold_carrot_block", Blocks.STONE);
	public static final Block TWO_LEVEL_GOLD_CARROT_BLOCK =
			registerBlock("two_level_gold_carrot_block", Blocks.DIAMOND_BLOCK);
	public static final Block THREE_LEVEL_GOLD_CARROT_BLOCK =
			registerBlock("three_level_gold_carrot_block", Blocks.OBSIDIAN);
	public static final Block GOLD_CARROT_BLOCK_ORE = registerBlock("gold_carrot_block_ore", Blocks.DIAMOND_BLOCK);

	private static Block registerBlock(String name, Block source) {
		// 26.3 起方块 / 物品在构造时就必须知道自己的注册表 id（否则抛 "Block id not set" / "Item id not set"）
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, MoreCarrotMod.id(name));

		BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(source)
				.setId(blockKey)
				.overrideLootTable(Optional.of(ResourceKey.create(Registries.LOOT_TABLE,
						MoreCarrotMod.id("blocks/" + name))));

		Block block = new Block(properties);
		registerBlockItem(name, block);

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static Item registerBlockItem(String name, Block block) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, MoreCarrotMod.id(name));

		// 26.3 起 BlockItem 不再自动用方块前缀（1.21 是它重写 getTranslationKey() 委托给方块），
		// 必须在 Properties 上显式声明 useBlockDescriptionPrefix()，
		// 否则物品名会去查 item.morecarrotmod.<名字>，而你 lang 里写的是 block.morecarrotmod.<名字>。
		// 原版 Items 注册方块物品时同样会调这个方法（原版的 key 也是 block.minecraft.xxx）。
		return Registry.register(BuiltInRegistries.ITEM, itemKey,
				new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix()));
	}

	public static void registerModBlock() {

	}
}
