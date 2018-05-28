package com.mario90900.elementalalchemy.proxy;

import com.mario90900.elementalalchemy.init.ModBlocks;
import com.mario90900.elementalalchemy.init.ModItems;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames.EnumBasicItems;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames.EnumRifts;

/**
 * Do actions only performed on the client here. IE: Rendering
 * 
 * @author Jonathon Secora
 *
 */
public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenderers(){
		//Item Render Registry
		EnumBasicItems[] basicItemsList = UnlocalizedNames.EnumBasicItems.values();
		for (int i = 0; i < basicItemsList.length; i++){
			ModItems.registerSubItemRenders(ModItems.basicItems, basicItemsList[i]);
		}
		
		//Block Render Registry
		EnumRifts[] riftsList = UnlocalizedNames.EnumRifts.values();
		for (int i = 0; i < riftsList.length; i++){
			ModBlocks.registerSubItemRenders(ModBlocks.rifts, riftsList[i]);
		}
	}
	
}