package io.github.mc_umod;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.*;
import net.minecraftforge.fml.common.IWorldGenerator;

public class UOreGeneration implements IWorldGenerator {
	
	private void nether(Random random, int x, int y, World world) {
		/*GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.ALUMINIUM.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 15);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.COPPER.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 30, 0, 128, 2, 15);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.LEAD.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.MANGAN.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 15);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.MERCURY.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.NICKEL.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.PLATINUM.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 1, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.SILICIUM.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.SILVER.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.SULPHUR.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 30, 0, 128, 5, 15);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.TIN.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 30, 0, 128, 2, 15);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.URAN.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 1, 10);
		GenerationUtils.generateOre(UBlocks.netherores.getStateFromMeta(EnumTypeBaseStuff.ZINC.getMetadata()), Blocks.NETHERRACK, random, x, y, world, 10, 0, 128, 2, 10);
	*/}
	
	private void overworld(Random random, int x, int y, World world) {/*
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.ALUMINIUM.getMetadata()), random, x, y, world, 35, 0, 128, 2, 12);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.COPPER.getMetadata()), random, x, y, world, 80, 0, 128, 2, 12);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.LEAD.getMetadata()), random, x, y, world, 30, 0, 30, 2, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.MANGAN.getMetadata()), random, x, y, world, 30, 0, 128, 2, 12);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.MERCURY.getMetadata()), random, x, y, world, 30, 0, 28, 2, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.NICKEL.getMetadata()), random, x, y, world, 30, 0, 30, 2, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.PLATINUM.getMetadata()), random, x, y, world, 8, 4, 22, 1, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.SILICIUM.getMetadata()), random, x, y, world, 25, 0, 30, 2, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.SILVER.getMetadata()), random, x, y, world, 25, 0, 30, 2, 8);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.SULPHUR.getMetadata()), random, x, y, world, 10, 0, 64, 3, 4);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.TIN.getMetadata()), random, x, y, world, 80, 0, 128, 2, 12);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.URAN.getMetadata()), random, x, y, world, 10, 4, 22, 1, 6);
		GenerationUtils.generateOre(UBlocks.ores.getStateFromMeta(EnumTypeBaseStuff.ZINC.getMetadata()), random, x, y, world, 40, 0, 33, 2, 8);
	*/}
	
	private void end(Random random, int x, int y, World world) {
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		switch (world.provider.getDimension()) {
		case -1:
			nether(random, x, z, world);
			break;
		case 0:
			overworld(random, x, z, world);
			break;
		case 1:
			end(random, x, z, world);
			break;
		
		}
	}
	
}
