package io.github.mc_umod.gui.container;

import io.github.mc_umod.gui.inventory.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class ContainerPulverizer extends ContainerBase {
	
	public ContainerPulverizer(EntityPlayer player, BlockPos pos) {
		super(player,pos);
		
		super.addSlotToContainer(new BaseSlotOutput((IInventory) this.tile, 0, 116, 24));
		super.addSlotToContainer(new BaseSlotOutput((IInventory) this.tile, 1, 98, 54));
		super.addSlotToContainer(new BaseSlotOutput((IInventory) this.tile, 2, 126, 54));
		super.addSlotToContainer(new BaseOreInputSlot((IInventory) this.tile, 3, 30, 23));
		
		int i = 0;
		int v = 9;
		int j = 0;
		
		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 9; ++j) {
				super.addSlotToContainer(new BaseNormalSlot(player.inventory, (j + (i * 9)) + v, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i) {
			super.addSlotToContainer(new BaseNormalSlot(player.inventory, i, 8 + i * 18, 142));
		}
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		/*
		 * ItemStack itemstack = null; Slot slot = (Slot) this.inventorySlots.get(index);
		 * 
		 * if (slot != null && slot.getHasStack()) { ItemStack itemstack1 = slot.getStack(); itemstack = itemstack1.copy();
		 * 
		 * if (index == 3) { if (!this.mergeItemStack(itemstack1, 4, 39, true)) { return null; }
		 * 
		 * slot.onSlotChange(itemstack1, itemstack); } else if (index != 1 && index != 0 && index != 2) { if (ModRegistryUtils.isRecepie(itemstack1) != null) { if (!this.mergeItemStack(itemstack1, 3, 4, false)) { return null; } } else if (index >= 4 && index < 30) { if (!this.mergeItemStack(itemstack1, 30, 39, false)) { return null; } } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 4, 30, false)) { return null; } } else if (!this.mergeItemStack(itemstack1, 4, 39, false)) { return null; }
		 * 
		 * if (itemstack1.stackSize == 0) { slot.putStack((ItemStack) null); } else { slot.onSlotChanged(); }
		 * 
		 * if (itemstack1.stackSize == itemstack.stackSize) { return null; }
		 * 
		 * slot.onPickupFromSlot(playerIn, itemstack1); }
		 * 
		 * return itemstack;
		 */
		return null;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		((IInventory) this.tile).closeInventory(player);
	}
	
	@Override
	protected void retrySlotClick(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {
	}
}
