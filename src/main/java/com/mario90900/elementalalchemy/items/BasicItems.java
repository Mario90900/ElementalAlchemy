package com.mario90900.elementalalchemy.items;

import java.util.List;

import com.mario90900.elementalalchemy.reference.Reference;
import com.mario90900.elementalalchemy.reference.UnlocalizedNames;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class will handle most generic items that either are used in crafting, or have a simple right click effect that does not warrant
 * or require a completely new ID to be used for it. The item is determined by the metadata. To see the items, check the unlocalized names file
 * for the enum listing them all.
 * 
 * @author Jonathon Secora
 *
 */
public class BasicItems extends ItemEA{
	public BasicItems(){
		super();
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setMaxDamage(0);
		this.setUnlocalizedName(UnlocalizedNames.Items.BASIC_ITEMS);
		this.setRegistryName(Reference.MOD_ID, UnlocalizedNames.Items.BASIC_ITEMS);
	}
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack){
        return String.format("%s.%s", super.getUnlocalizedName(), UnlocalizedNames.EnumBasicItems.values()[itemStack.getItemDamage()].getUnlocalizedName());
    }
	
	/*@Override TODO REMOVE ALL SUB-BLOCKS AND ITEMS!
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List subItems){
        for (int i = 0; i < UnlocalizedNames.EnumBasicItems.values().length; ++i){
            subItems.add(new ItemStack(item, 1, i));
        }
    }*/
}
