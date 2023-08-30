package cn.zhicheng233.chromablockfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;


public class MainMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String modid = "chroma-block-fabric";

	public static boolean welcome = true;
	//新方块
	public static final Block CBF_Green  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_Red = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_Yellow  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_Blue  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_Purple  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_Black  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
	public static final Block CBF_White  = new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f,1200.0f));
//	//学习原版方法获取CBF_GROUP_KEY，去TM的傻逼Fabric Wiki文档常年不更新 1.20+
//	public static final RegistryKey<ItemGroup> CBF_GROUP_KEY = register("chroma_block");
//
//	public static RegistryKey<ItemGroup> register(String id){
//		return RegistryKey.of(RegistryKeys.ITEM_GROUP,new Identifier(modid,id));
//	}

	//创建物品组并将物品添加到物品组
	private static final ItemGroup CBF_GROUP = FabricItemGroupBuilder.create(

			new Identifier(modid,"chroma_block"))
			.icon(() -> new ItemStack(CBF_Green))
			.appendItems(stack ->
			{
				stack.add(new ItemStack(CBF_Green));
				stack.add(new ItemStack(CBF_Red));
				stack.add(new ItemStack(CBF_Blue));
				stack.add(new ItemStack(CBF_Purple));
				stack.add(new ItemStack(CBF_Black));
				stack.add(new ItemStack(CBF_White));
				stack.add(new ItemStack(CBF_Yellow));
			})
			.build();


	//注册
	@Override
	public void onInitialize() {
		// 注册事件监听器
		ClientTickEvents.START_WORLD_TICK.register((client) -> {

			if (welcome){
				List playerList = client.getPlayers();
				// 获取玩家列表
				ClientPlayerEntity player = (ClientPlayerEntity) playerList.get(0);
				// 发送聊天栏消息
				player.sendMessage(new LiteralText("§a§l Donator:"), false);
				player.sendMessage(new LiteralText("§eATC_rock 20￥"), false);
				player.sendMessage(new LiteralText("§l----------------------------"), false);
				player.sendMessage(new LiteralText("§e欢迎使用Chroma Block Fabric"), false);
				player.sendMessage(new LiteralText("§c§l§n警告!您正在使用BETA版本这通常意味着该版本为 过渡版本 或者其功能是以较为 扭曲 的方式实现的，同时没有经过大规模的 生产环境 测试，可能会导致 不兼容 的情况!"), false);
				welcome = false;
			}


		});







		//注册方块/物品
		Registry.register(Registry.BLOCK, new Identifier(modid, "green_chroma_block"), CBF_Green);
		Registry.register(Registry.ITEM, new Identifier(modid, "green_chroma_block"), new BlockItem(CBF_Green, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "red_chroma_block"), CBF_Red);
		Registry.register(Registry.ITEM, new Identifier(modid, "red_chroma_block"), new BlockItem(CBF_Red, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "yellow_chroma_block"), CBF_Yellow);
		Registry.register(Registry.ITEM, new Identifier(modid, "yellow_chroma_block"), new BlockItem(CBF_Yellow, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "blue_chroma_block"), CBF_Blue);
		Registry.register(Registry.ITEM, new Identifier(modid, "blue_chroma_block"), new BlockItem(CBF_Blue, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "purple_chroma_block"), CBF_Purple);
		Registry.register(Registry.ITEM, new Identifier(modid, "purple_chroma_block"), new BlockItem(CBF_Purple, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "black_chroma_block"), CBF_Black);
		Registry.register(Registry.ITEM, new Identifier(modid, "black_chroma_block"), new BlockItem(CBF_Black, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier(modid, "white_chroma_block"), CBF_White);
		Registry.register(Registry.ITEM, new Identifier(modid, "white_chroma_block"), new BlockItem(CBF_White, new FabricItemSettings()));

	}


}