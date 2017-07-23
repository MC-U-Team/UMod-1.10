package io.github.mc_umod.world.explosion;

import java.util.Random;

import io.github.mc_umod.api.*;
import net.minecraft.world.World;

public class NuclearExplosion implements IProcess {
	
	private World worldObj;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private float power;
	private Random random = new Random();
	
	private double expansion = 0;
	private boolean isDead = false;
	
	public NuclearExplosion(World world, int x, int y, int z, float power) {
		this.worldObj = world;
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.power = power;
		isDead = world.isRemote;
	}
	
	@Override
	public void updateProcess() {
		
		int OD = (int) expansion;
		int ID = OD - 1;
		int size = (int) expansion;
		
		for (int x = xCoord - size; x < xCoord + size; x++) {
			for (int z = zCoord - size; z < zCoord + size; z++) {
				double dist = getDistanceAtoB(x, z, xCoord, zCoord);
				if (dist < OD && dist >= ID) {
					float tracePower = power - (float) (expansion / 10D);
					tracePower *= 1.5F + ((random.nextFloat() - 0.5F) * 0.1);
					ProcessHandler.addProcess(new NuclearExplosionTrace(worldObj, x, yCoord, z, tracePower, random));
				}
			}
		}
		
		isDead = expansion >= power * 10;
		expansion += 1;
	}
	
	@Override
	public boolean isDead() {
		return isDead;
	}
	
	private double getDistanceAtoB(double x1, double z1, double x2, double z2) {
		double dx = x1 - x2;
		double dz = z1 - z2;
		return Math.sqrt((dx * dx + dz * dz));
	}
}