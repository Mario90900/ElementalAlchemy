package com.mario90900.elementalalchemy.blocks;

import java.util.List;
import java.util.Random;

import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class will manage all four of the elemental rifts in Elemental Alchemy.
 * 
 * @author Jonathon Secora
 *
 */
public class Rifts extends BlockEA implements ISubBlocks{
	
	public static final PropertyEnum<UnlocalizedNames.EnumRifts> ELEMENT = PropertyEnum.create("element", UnlocalizedNames.EnumRifts.class);
	
	public Rifts(){
		super(Material.BARRIER);
		this.setHardness(50.0F);
		this.setResistance(100000.0F);
		this.setHarvestLevel("pickaxe", 0); //Any pick of level Iron or better should be able to break the rift if you REALLY want, but there will be a nasty Chaos effect if you do.
		this.setUnlocalizedName(UnlocalizedNames.Blocks.RIFTS);
		this.setRegistryName(Reference.MOD_ID, UnlocalizedNames.Blocks.RIFTS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(ELEMENT, UnlocalizedNames.EnumRifts.FIRE));
		this.setTickRandomly(true);
	}
	
	@Override
	public int damageDropped(IBlockState state){
        return ((UnlocalizedNames.EnumRifts)state.getValue(ELEMENT)).getMeta();
    }

    /* TODO This needs to be torn apart for 1.13 anyway! No more metadata ever again.
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems){
		for (int i = 0; i < UnlocalizedNames.EnumRifts.values().length; ++i){
            subItems.add(new ItemStack(item, 1, i));
        }
	}*/
	
	@Override
	public String getSubName(ItemStack stack) {
		return UnlocalizedNames.EnumRifts.values()[stack.getMetadata()].getUnlocalizedName();
	}
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos){ //Allow entities to pass through the Rift block
		return true;
	}
	
	/*@Override
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side){
		return false;
	}*/
	
	/**
	 * This is called when the block breaks. Use this method to cause Strong Chaos Effect upon a rift being broken.
	 * Implement this once Chaos Effects are completed.
	 */
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		super.breakBlock(worldIn, pos, state);
	}
	
	//We cant have rifts actually dropping anything, can we?
	@Override
	public int quantityDropped(Random random){
		return 0;
	}
	
	/**
	 * This is where the rendering for the particle effects coming from the Rift happens.
	 */
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand){
		
	}
	
	/**
     * One for one - The metadata determines the what block it is. No need to make this complicated.
     */
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(ELEMENT, UnlocalizedNames.EnumRifts.getByMeta(meta));
    }

    /**
     * The reverse of above.
     */
    public int getMetaFromState(IBlockState state){
        return ((UnlocalizedNames.EnumRifts)state.getValue(ELEMENT)).getMeta();
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {ELEMENT});
    }
}
