package io.github.mc_umod.block.machine;

import io.github.mc_umod.item.ItemEnergyDisplay;
import io.github.mc_umod.tileentity.TileEntityEnergyPannel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class BlockEnergyPanel extends BlockBaseMachine {
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() instanceof ItemEnergyDisplay && playerIn.getHeldItemMainhand().getTagCompound() != null && playerIn.getHeldItemMainhand().getTagCompound().hasKey(ItemEnergyDisplay.NBT_TAG)) {
			TileEntityEnergyPannel pan = (TileEntityEnergyPannel) worldIn.getTileEntity(pos);
			pan.setStack(playerIn, playerIn.getHeldItemMainhand());
			return true;
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityEnergyPannel();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (placer instanceof EntityPlayer && worldIn.isRemote) {
			TileEntityEnergyPannel p = (TileEntityEnergyPannel) worldIn.getTileEntity(pos);
			p.setView(-Minecraft.getMinecraft().getRenderManager().playerViewY);
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return false;
	}
}
