package io.github.mc_umod.block.infected;

import io.github.mc_umod.UReference;
import io.github.mc_umod.api.IInfectedBlock;
import net.minecraft.block.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.*;
import net.minecraft.init.Blocks;

public class BlockInfectedLog extends BlockLog implements IInfectedBlock {
	
	public BlockInfectedLog() {
		this.setCreativeTab(UReference.infected);
		this.setHarvestLevel("axe", 1);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.PLANT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		Blocks.FIRE.setFireInfo(this, 5, 5);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();
		
		switch (meta) {
		case 0:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
			break;
		case 1:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			break;
		case 2:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}
		
		return iblockstate;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return BlockInfectedLog.SwitchEnumAxis.AXIS_LOOKUP[((BlockInfectedLog.EnumAxis) state.getValue(LOG_AXIS)).ordinal()];
		
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
	}
	
	static final class SwitchEnumAxis {
		
		static final int[] AXIS_LOOKUP = new int[BlockLog.EnumAxis.values().length];
		
		static {
			try {
				AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}
			
			try {
				AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}
			
			try {
				AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}
		}
	}
	
	@Override
	public Block getNormalBlock() {
		return Blocks.LOG;
	}
}
