package io.github.mc_umod.world;

import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class WorldSavedDataInfectedStructure extends WorldSavedData {
	
	public WorldSavedDataInfectedStructure(String name) {
		super(name);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
		return nbt;
	}
	
}
