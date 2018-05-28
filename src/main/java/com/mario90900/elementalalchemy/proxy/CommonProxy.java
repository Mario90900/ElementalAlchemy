package com.mario90900.elementalalchemy.proxy;

import com.mario90900.lizardlib.proxy.IProxy;

/**
 * Do actions common to both client and server here
 * 
 * @author Jonathon Secora
 *
 */
public abstract class CommonProxy implements IProxy{
	public void registerTileEntities(){
		//Example from FON: GameRegistry.registerTileEntity(TileEntityWheatPlant.class, UnlocalizedNames.WHEAT_PLANT)
	}
}