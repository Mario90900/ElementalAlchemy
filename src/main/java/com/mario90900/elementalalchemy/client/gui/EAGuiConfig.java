package com.mario90900.elementalalchemy.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.mario90900.elementalalchemy.handler.ConfigHandler;
import com.mario90900.elementalalchemy.reference.Reference;

import net.minecraftforge.fml.client.config.GuiConfig;

public class EAGuiConfig extends GuiConfig{
	public EAGuiConfig(GuiScreen guiScreen){
		super(guiScreen, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}
}
