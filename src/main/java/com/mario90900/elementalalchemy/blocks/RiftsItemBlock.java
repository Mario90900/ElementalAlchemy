package com.mario90900.elementalalchemy.blocks;

import com.mario90900.elementalalchemy.init.ModBlocks;
import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames;

public class RiftsItemBlock extends ItemBlockEA {
	public RiftsItemBlock(){
		super(ModBlocks.rifts);
		this.setRegistryName(Reference.MOD_ID, UnlocalizedNames.Blocks.RIFTS);
	}
}
