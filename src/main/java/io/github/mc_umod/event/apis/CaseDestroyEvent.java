package io.github.mc_umod.event.apis;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class CaseDestroyEvent extends Event{
	
	private World world;
	private BlockPos pos;
	private IBlockState state;
	
	public CaseDestroyEvent(World w,BlockPos pos,IBlockState state) {
		this.world = w;
		this.pos = pos;
		this.state = state;
	}
	
	
	public IBlockState getState() {
		return state;
	}
	
	public World getWorld() {
		return world;
	}
	
	public BlockPos getPos() {
		return pos;
	}
	
	@Override
	public boolean isCancelable() {
		return true;
	}
}
