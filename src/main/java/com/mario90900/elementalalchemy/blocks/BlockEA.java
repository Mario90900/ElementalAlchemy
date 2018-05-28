package com.mario90900.elementalalchemy.blocks;

import com.mario90900.elementalalchemy.creativetab.CreativeTabEA;
import com.mario90900.elementalalchemy.reference.Reference;


//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//Layout for this class borrowed from Pahimar's Open Source EE3
public abstract class BlockEA extends Block{
	public BlockEA(Material material){
		super(material);
		this.setCreativeTab(CreativeTabEA.EA_TAB);
	}
	
	public BlockEA(){
		this(Material.ROCK);
	}
	
	@Override
    public String getUnlocalizedName(){
        return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
	
    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
