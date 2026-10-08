package com.carrot;

import com.carrot.block.ModBlocks;
import com.carrot.item.Moditem;
import com.carrot.item.ModitemGroup;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreCarrotMod implements ModInitializer {
	/**
	 * 注册表 / 资源命名空间。
	 *
	 * <p>从 1.21 版本一直沿用 "morecarrotmod"（注意它不是 fabric.mod.json 里的模组 id
	 * "morecarrot-mod"）。Fabric 会扫描 jar 内 assets/ 与 data/ 下的目录名来决定可用的命名空间，
	 * 所以保持这个名字不变，已有存档里的方块 / 物品 id 才不会失效。
	 */
	public static final String MOD_ID = "morecarrotmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Moditem.registerModItem();
		ModitemGroup.registerModItemGroup();
		ModBlocks.registerModBlock();

		LOGGER.info("MoreCarrot Mod loaded!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
