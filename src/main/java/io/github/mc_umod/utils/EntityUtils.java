package io.github.mc_umod.utils;

import java.lang.reflect.Field;
import java.util.*;

import io.github.mc_umod.api.IInfectedEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class EntityUtils {
	
	public static boolean isInfectedEntity(EntityLivingBase base) {
		return (base instanceof IInfectedEntity);
	}
	
	@SuppressWarnings("unchecked")
	public static int getHighestID() {
		int highest = 0;
		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			
			try {
				if (f.getName().equals("field_180150_I")) {
					f.setAccessible(true);
					HashMap<ResourceLocation, Potion> potions = (HashMap<ResourceLocation, Potion>) f.get(Potion.class);
					ArrayList<Integer> ints = new ArrayList<Integer>();
					for (Potion potion : potions.values()) {
						System.out.println(potion);
						ints.add(new Integer(Potion.getIdFromPotion(potion)));
					}
					for (int i = 0; i < ints.size(); i++) {
						if (!ints.contains(new Integer(i))) {
							return i;
						}
					}
					System.out.println("===========");
					System.out.println(highest);
					return ints.size() + 1;
				}
			} catch (Exception e) {
				System.err.println("Server error, please report this to the mod authors:");
				System.err.println(e);
			}
		}
		return highest;
	}
	
}
