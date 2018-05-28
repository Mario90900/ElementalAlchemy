package com.mario90900.elementalalchemy.handler;

import java.io.File;

import com.mario90900.elementalalchemy.reference.Reference;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	public static Boolean testValue;
	
	public static void init(File configFile){
		// Create the configuration object from the given configFile
		if(config == null){
			config = new Configuration(configFile);
			loadConfig();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
			// Resync Configs
			loadConfig();
		}
	}
	
	private static void loadConfig(){
		testValue = config.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "This is a test config value");
		
		if(config.hasChanged()){
			config.save();
		}
	}
}
