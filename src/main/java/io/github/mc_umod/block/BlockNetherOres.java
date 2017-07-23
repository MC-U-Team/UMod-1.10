package io.github.mc_umod.block;

import java.util.*;

import io.github.mc_umod.UItems;
import io.github.mc_umod.enumtype.EnumTypeBaseStuff;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockNetherOres extends BlockBase {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumTypeBaseStuff.class);
	
	public BlockNetherOres() {
		super(Material.ROCK);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public float getBlockHardness(IBlockState blockState, World world, BlockPos pos) {
		EnumTypeBaseStuff type = EnumTypeBaseStuff.byMetadata(world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)));
		return type.getOreHardness() - 1;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) state.getValue(TYPE);
		return type.getOreHarvestLevel();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) state.getValue(TYPE);
		if (type.getName() == "sulphur") {
			return UItems.ingots;
		}
		return super.getItemDropped(state, rand, fortune);
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) state.getValue(TYPE);
		if (type.getName() == "sulphur") {
			if (1 + fortune <= 4) {
				return MathHelper.getRandomIntegerInRange(random, 1 + fortune, 4);
			} else {
				return 4;
			}
		}
		return 1;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) state.getValue(TYPE);
		return type.getMetadata();
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) world.getBlockState(pos).getValue(TYPE);
		if (type.getName() == "sulphur") {
			return MathHelper.getRandomIntegerInRange(rand, 3, 6);
		}
		return 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativetab, List list) {
		for (int i = 0; i < EnumTypeBaseStuff.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumTypeBaseStuff type = EnumTypeBaseStuff.byMetadata(meta);
		return this.getDefaultState().withProperty(TYPE, type);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumTypeBaseStuff type = (EnumTypeBaseStuff) state.getValue(TYPE);
		return type.getMetadata();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
}
