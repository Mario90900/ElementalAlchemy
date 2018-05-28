package com.mario90900.elementalalchemy.blocks;

import com.mario90900.elementalalchemy.creativetab.CreativeTabEA;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEA extends ItemBlock{
	public ItemBlockEA(Block block){
		super(block);
		this.setCreativeTab(CreativeTabEA.EA_TAB);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage){
        return damage;
    }

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((ISubBlocks)this.block).getSubName(stack);
	}
}
