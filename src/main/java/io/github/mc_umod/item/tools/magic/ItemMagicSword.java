package io.github.mc_umod.item.tools.magic;

import java.util.List;

import io.github.mc_umod.UReference;
import io.github.mc_umod.utils.URegistryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

public class ItemMagicSword extends ItemSword {
	
	public ItemMagicSword(ToolMaterial material) {
		super(material);
		setCreativeTab(UReference.magic);
	}
	
	@SuppressWarnings("rawtypes")
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		URegistryUtils.addTooltip(stack, tooltip);
	}
	
}
