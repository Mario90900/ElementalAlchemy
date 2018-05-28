package com.mario90900.elementalalchemy;

import com.mario90900.elementalalchemy.handler.ConfigHandler;
import com.mario90900.elementalalchemy.init.ModBlocks;
import com.mario90900.elementalalchemy.init.ModItems;
import com.mario90900.elementalalchemy.init.ModRecipes;
import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.lizardlib.proxy.IProxy;
import com.mario90900.lizardlib.utility.LogHelper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.tools.nsc.doc.model.Object;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:lizardlib")
public class ElementalAlchemy {
    
    @Instance
    public static ElementalAlchemy instance = new ElementalAlchemy();
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	LogHelper.info(Reference.MOD_NAME, "Started Pre-Init Phase");
    	
    	//Load configs, init network handler, keybinds, init blocks + items here
    	ConfigHandler.init(e.getSuggestedConfigurationFile());
    	MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		
    	ModItems.init();
		ModBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	LogHelper.info(Reference.MOD_NAME, "Started Init Phase");
    	
    	//Setup GUI handler, Tile Ents, and General Event Handlers, and recipes here
    	proxy.registerTileEntities();
		proxy.registerRenderers();
		
		ModRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	LogHelper.info(Reference.MOD_NAME, "Started Post-Init Phase");
    	
    	//Wrap things up, and mod integration here
    	
    }
}
