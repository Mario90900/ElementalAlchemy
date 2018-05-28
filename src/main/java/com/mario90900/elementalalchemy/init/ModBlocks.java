package com.mario90900.elementalalchemy.init;

import com.mario90900.elementalalchemy.blocks.BlockEA;
import com.mario90900.elementalalchemy.blocks.ItemBlockEA;
import com.mario90900.elementalalchemy.blocks.Rifts;
import com.mario90900.elementalalchemy.blocks.RiftsItemBlock;
import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.lizardlib.reference.IItemDataEnum;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	
	public static BlockEA rifts = new Rifts();
	public static ItemBlockEA riftsItemBlock = new RiftsItemBlock();
	
	public static void init(){
		ForgeRegistries.BLOCKS.register(rifts);
		ForgeRegistries.ITEMS.register(riftsItemBlock);
	}
	
	/**
	 * This method is designed to register a single item, send just the item to register it
	 */
	public static void registerSingleItemRenders(BlockEA block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnlocalizedName().substring(5).replace('.', '_'), "inventory"));
	}
	
	/**
	 * This method will register a sub item of the given item, send it an item that has sub items and the ItemDataEnum value for the
	 * sub item you are registering. See the client proxy for the registering of all basic items as an example.
	 * 
	 * @param block
	 * @param name
	 */
	public static void registerSubItemRenders(BlockEA block, IItemDataEnum name){
		int meta = name.getMeta();
		String unlocalizedName = name.getTextureName();
		ResourceLocation resourceLoc = new ResourceLocation(name.getTextureName());
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), resourceLoc);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(unlocalizedName, "inventory"));
	}
}
