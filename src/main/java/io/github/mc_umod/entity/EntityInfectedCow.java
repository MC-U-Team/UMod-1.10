package io.github.mc_umod.entity;

import io.github.mc_umod.UItems;
import io.github.mc_umod.api.IInfectedEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class EntityInfectedCow extends EntityMob implements IInfectedEntity {
	
	public EntityInfectedCow(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
		// this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		// this.tasks.addTask(2, this.field_175455_a);
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}
	
	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, ItemStack stack, EnumHand hand) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		
		if (itemstack != null && itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode) {
			if (itemstack.stackSize-- == 1) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(UItems.infectedmilk));
			} else if (!player.inventory.addItemStackToInventory(new ItemStack(UItems.infectedmilk))) {
				player.dropItem(new ItemStack(UItems.infectedmilk, 1, 0), false);
			}
			return EnumActionResult.SUCCESS;
		} else {
			return applyPlayerInteraction(player, vec, itemstack, hand);
		}
	}
	
	@Override
	public Item getDropItem() {
		return UItems.infectedleather;
	}
	
	@Override
	public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
		int k;
		
		for (k = 0; k < j; ++k) {
			this.dropItem(UItems.infectedleather, 1);
		}
		
		j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(UItems.infectedbeef, 1);
		}
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		// TODO Auto-generated method stub
		return super.getHurtSound();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		// TODO Auto-generated method stub
		return super.getDeathSound();
	}
	
	@Override
	public void playStepSound(BlockPos p_180429_1_, Block p_180429_2_) {
		// this.playSound("mob.cow.step", 0.15F, 1.0F);
	}
	
	@Override
	public float getSoundVolume() {
		return 0.4F;
	}
	
}
