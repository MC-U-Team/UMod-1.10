package io.github.mc_umod.world.explosion;

import java.util.*;

import io.github.mc_umod.UDamageSource;
import io.github.mc_umod.api.IProcess;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class NuclearExplosionTrace implements IProcess {
	
	private World worldObj;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private float power;
	private Random random;
	private boolean isDead = false;
	
	public NuclearExplosionTrace(World world, int x, int y, int z, float power, Random random) {
		this.worldObj = world;
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.power = power;
		this.random = random;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateProcess() {
		
		float energy = power * 10;
		for (int y = yCoord; y > 0 && energy > 0; y--) {
			Block block = worldObj.getBlockState(new BlockPos(xCoord, y, zCoord)).getBlock();
			
			List<Entity> entities = worldObj.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(xCoord, y, zCoord, xCoord + 1, y + 1, zCoord + 1));
			for (Entity entity : entities)
				entity.attackEntityFrom(UDamageSource.nuclearExplosion, power * 100);
			
			energy -= block instanceof BlockLiquid ? 10 : block.getExplosionResistance(null);
			
			boolean blockRemoved = false;
			if (energy >= 0 && block != Blocks.AIR) {
				worldObj.setBlockToAir(new BlockPos(xCoord, y, zCoord));
				blockRemoved = true;
			}
			energy -= 0.5F + (0.1F * (yCoord - y));
			
			if (energy <= 0 && random.nextInt(20) == 0 && blockRemoved) {
				if (random.nextInt(3) > 0)
					worldObj.setBlockState(new BlockPos(xCoord, y, zCoord), Blocks.FIRE.getDefaultState());
			}
		}
		
		energy = power * 20;
		yCoord++;
		for (int y = yCoord; y < 255 && energy > 0; y++) {
			Block block = worldObj.getBlockState(new BlockPos(xCoord, y, zCoord)).getBlock();
			
			List<Entity> entities = worldObj.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(xCoord, y, zCoord, xCoord + 1, y + 1, zCoord + 1));
			for (Entity entity : entities)
				entity.attackEntityFrom(UDamageSource.nuclearExplosion, power * 100);
			
			energy -= block instanceof BlockLiquid ? 10 : block.getExplosionResistance(null);
			if (energy >= 0)
				worldObj.setBlockToAir(new BlockPos(xCoord, y, zCoord));
			
			energy -= 0.5F + (0.1F * (y - yCoord));
		}
		
		isDead = true;
	}
	
	@Override
	public boolean isDead() {
		return isDead;
	}
}
