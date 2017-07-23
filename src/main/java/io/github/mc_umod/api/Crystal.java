package io.github.mc_umod.api;

import io.github.mc_umod.UReference;
import io.github.mc_umod.item.ItemBase;
import net.minecraft.item.ItemStack;

public abstract class Crystal extends ItemBase {
	
	public abstract int energyUnits();
	
	public Crystal() {
		super();
		this.setCreativeTab(UReference.magic);
	}
	
	public static boolean isStackCrystal(ItemStack is) {
		if (is != null && is.getItem() instanceof Crystal)
			return true;
		return false;
	}
	
}
