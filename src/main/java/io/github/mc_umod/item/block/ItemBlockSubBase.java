package io.github.mc_umod.item.block;

import net.minecraft.block.Block;

public class ItemBlockSubBase extends ItemBlockBase {
	
	public ItemBlockSubBase(Block block) {
		super(block);
		this.hasSubtypes = true;
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
}
