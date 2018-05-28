package com.mario90900.elementalalchemy.reference;

import com.mario90900.lizardlib.reference.IItemDataEnum;

public final class UnlocalizedNames {
	
	//Items
	public static final class Items{
		public static final String BASIC_ITEMS = "basicItems";
	}
	
	public static enum EnumBasicItems implements IItemDataEnum{
		SALT(0, "salt"),
		SULFUR(1, "sulfur"),
		QUICKSILVER(2, "quicksilver"),
		CRYSTALFRAGMENT(3, "crystalFragment");
		
		private final int meta;
		private final String unlocalizedName;
		
		private EnumBasicItems(int metaVal, String unlocName){
			this.meta = metaVal;
			this.unlocalizedName = unlocName;
		}
		
		public int getMeta(){
            return this.meta;
        }
		
		public String getName(){
			return this.unlocalizedName;
		}
		
		public String getUnlocalizedName(){
            return this.unlocalizedName;
        }
		
		public String getTextureName(){
			return String.format("%s%s_%s", Reference.RESOURCE_PREFIX, UnlocalizedNames.Items.BASIC_ITEMS, this.unlocalizedName);
		}
	}
	
	//Blocks
	public static final class Blocks{
		public static final String RIFTS = "rifts";
	}
	
	public static enum EnumRifts implements IItemDataEnum{
		FIRE(0, "fire"),
		WATER(1, "water"),
		EARTH(2, "earth"),
		AIR(3, "air");
		
		private final int meta;
		private final String unlocalizedName;
		
		private EnumRifts(int metaVal, String unlocName){
			this.meta = metaVal;
			this.unlocalizedName = unlocName;
		}
		
		public int getMeta(){
            return this.meta;
        }
		
		public String getName(){
			return this.unlocalizedName;
		}
		
		public String getUnlocalizedName(){
            return this.unlocalizedName;
        }
		
		public String getTextureName(){
			return String.format("%s%s_%s", Reference.RESOURCE_PREFIX, UnlocalizedNames.Blocks.RIFTS, this.unlocalizedName);
		}
		
		public static UnlocalizedNames.EnumRifts getByMeta(int meta){
			UnlocalizedNames.EnumRifts[] enums = UnlocalizedNames.EnumRifts.values();
			if (meta < 0 || meta >= enums.length){
				meta = 0;
			}
			return enums[meta];
		}
	}
	
	
	//Other
	
}
