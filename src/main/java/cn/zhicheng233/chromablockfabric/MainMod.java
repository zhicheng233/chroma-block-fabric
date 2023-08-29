package cn.zhicheng233.chromablockfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String modid = "chroma-block-fabric";
	public static boolean welcome = true;
	public static final Logger LOGGER = LoggerFactory.getLogger(modid);

	//新方块
	public static final Block CBF_Green  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_Red = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_Yellow  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_Blue  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_Purple  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_Black  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	public static final Block CBF_White  = new Block(FabricBlockSettings.create().strength(0.1f,1200.0f).luminance(16));
	//学习原版方法获取CBF_GROUP_KEY，去TM的傻逼Fabric Wiki文档常年不更新
	public static final RegistryKey<ItemGroup> CBF_GROUP_KEY = register("chroma_block");

	public static RegistryKey<ItemGroup> register(String id){
		return RegistryKey.of(RegistryKeys.ITEM_GROUP,new Identifier(modid,id));
	}

	//创建物品组
	private static final ItemGroup CBF_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(CBF_Green))
			.displayName(Text.translatable("itemGroup.chroma-block-fabric.chroma_block"))
			.build();



	//注册
	@Override
	public void onInitialize() {
		// 注册事件监听器

		ServerTickEvents.START_WORLD_TICK.register((entity) -> {

			if (welcome){

				// 获取玩家列表
				List playerList = entity.getPlayers();
				if (playerList != null && playerList.size() > 0) {
					PlayerEntity player = (PlayerEntity) playerList.get(0);
					// 发送聊天栏消息
					player.sendMessage(Text.of("§a§l Donator:"));
					player.sendMessage(Text.of("§eATC_rock 30￥"));
					player.sendMessage(Text.of("§l----------------------------"));
					player.sendMessage(Text.of("§e欢迎使用Chroma Block Fabric"));
					welcome = false;
				}




				//player.sendMessage(Text.of("§c§l§n警告!您正在使用BETA版本这通常意味着该版本为 过渡版本 或者其功能是以较为 扭曲 的方式实现的，同时没有经过大规模的 生产环境 测试，可能会导致 不兼容 的情况!"));

			}


		});

		//添加物品到物品组
		ItemGroupEvents.modifyEntriesEvent(CBF_GROUP_KEY).register(content -> {
			content.add(CBF_Green);
			content.add(CBF_Red);
			content.add(CBF_Blue);
			content.add(CBF_Purple);
			content.add(CBF_Black);
			content.add(CBF_White);
			content.add(CBF_Yellow);
		});
		//注册方块/物品
		Registry.register(Registries.BLOCK, new Identifier(modid, "green_chroma_block"), CBF_Green);
		Registry.register(Registries.ITEM, new Identifier(modid, "green_chroma_block"), new BlockItem(CBF_Green, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "red_chroma_block"), CBF_Red);
		Registry.register(Registries.ITEM, new Identifier(modid, "red_chroma_block"), new BlockItem(CBF_Red, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "yellow_chroma_block"), CBF_Yellow);
		Registry.register(Registries.ITEM, new Identifier(modid, "yellow_chroma_block"), new BlockItem(CBF_Yellow, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "blue_chroma_block"), CBF_Blue);
		Registry.register(Registries.ITEM, new Identifier(modid, "blue_chroma_block"), new BlockItem(CBF_Blue, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "purple_chroma_block"), CBF_Purple);
		Registry.register(Registries.ITEM, new Identifier(modid, "purple_chroma_block"), new BlockItem(CBF_Purple, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "black_chroma_block"), CBF_Black);
		Registry.register(Registries.ITEM, new Identifier(modid, "black_chroma_block"), new BlockItem(CBF_Black, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier(modid, "white_chroma_block"), CBF_White);
		Registry.register(Registries.ITEM, new Identifier(modid, "white_chroma_block"), new BlockItem(CBF_White, new FabricItemSettings()));

	}

	static {
		Registry.register(Registries.ITEM_GROUP,CBF_GROUP_KEY,CBF_GROUP);
	}
}