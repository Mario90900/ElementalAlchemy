package com.mario90900.elementalalchemy.creativetab;

import com.mario90900.elementalalchemy.init.ModItems;
import com.mario90900.elementalalchemy.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabEA {
	public static final CreativeTabs EA_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()){
		
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem(){
			return new ItemStack(ModItems.basicItems);
		}
		
		/*@Override
		@SideOnly(Side.CLIENT)
		public int getIconItemDamage(){
			return UnlocalizedNames.EnumBasicItems.CRYSTALFRAGMENT.getMeta();
		}*/
	};
}
