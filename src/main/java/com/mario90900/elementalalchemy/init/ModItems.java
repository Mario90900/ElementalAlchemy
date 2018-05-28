package com.mario90900.elementalalchemy.init;

import com.mario90900.elementalalchemy.items.BasicItems;
import com.mario90900.elementalalchemy.items.ItemEA;
import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.lizardlib.reference.IItemDataEnum;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ItemEA basicItems = new BasicItems();
	
	public static void init(){
		ForgeRegistries.ITEMS.register(basicItems);
	}
	
	/**
	 * This method is designed to register a single item, send just the item to register it
	 */
	public static void registerSingleItemRenders(ItemEA item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5).replace('.', '_'), "inventory"));
	}
	
	/**
	 * This method will register a sub item of the given item, send it an item that has sub items and the ItemDataEnum value for the
	 * sub item you are registering. See the client proxy for the registering of all basic items as an example.
	 * 
	 * @param item
	 * @param name
	 */
	public static void registerSubItemRenders(ItemEA item, IItemDataEnum name){
		int meta = name.getMeta();
		String unlocalizedName = name.getTextureName();
		ResourceLocation resourceLoc = new ResourceLocation(name.getTextureName());
		ModelBakery.registerItemVariants(item, resourceLoc);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(unlocalizedName, "inventory"));
	}
}
