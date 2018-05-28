package com.mario90900.elementalalchemy.items;

import com.mario90900.elementalalchemy.creativetab.CreativeTabEA;
import com.mario90900.elementalalchemy.reference.Reference;

//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraft.client.renderer.texture.IIconRegister; Possibly obsolete as well, leaving temporarily
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//Layout for this class borrowed from Pahimar's Open Source EE3
public class ItemEA extends Item{
	public ItemEA(){
		super();
		this.setCreativeTab(CreativeTabEA.EA_TAB);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack){
        return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
