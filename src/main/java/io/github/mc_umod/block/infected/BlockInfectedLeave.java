package io.github.mc_umod.block.infected;

import java.util.*;

import io.github.mc_umod.*;
import io.github.mc_umod.api.IInfectedBlock;
import net.minecraft.block.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;
import scala.actors.threadpool.Arrays;

public class BlockInfectedLeave extends BlockLeaves implements IInfectedBlock {
	
	public BlockInfectedLeave() {
		super();
		this.setCreativeTab(UReference.infected);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		Blocks.FIRE.setFireInfo(this, 30, 60);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { CHECK_DECAY, DECAYABLE, });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			meta |= 4;
		}
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			meta |= 8;
		}
		return meta;
	}
	
	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public int getBlockColor() { return 0xFFFFFF; }
	 * 
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public int getRenderColor(IBlockState state) { return ColorizerFoliage.getFoliageColorBasic(); }
	 * 
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int tintIndex) { return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos); }
	 */
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, 0);
	}
	
	@Override
	protected ItemStack createStackedBlock(IBlockState state) {
		IBlockState newState = state.withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));
		return super.createStackedBlock(newState);
	}
	
	@Override
	public int getSaplingDropChance(IBlockState state) {
		return 15;
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		return new ArrayList<ItemStack>(Arrays.asList(new ItemStack[] { new ItemStack(this) }));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState s) {
		return Blocks.LEAVES.isOpaqueCube(s);
	}
	
	@Override
	public BlockPlanks.EnumType getWoodType(int meta) {
		return null;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(UBlocks.infectedSapling);
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
	}
	
	@Override
	public Block getNormalBlock() {
		return Blocks.LEAVES;
	}
	
}
