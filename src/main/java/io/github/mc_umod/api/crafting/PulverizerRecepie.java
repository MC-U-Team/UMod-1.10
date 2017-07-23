package io.github.mc_umod.api.crafting;

import io.github.mc_umod.UItems;
import net.minecraft.item.ItemStack;
import scala.util.Random;

public class PulverizerRecepie {
	
	private ItemStack input;
	private ItemStack output;
	private ItemStack randomoutut;
	private boolean randomoutput;
	private int randomnumber;
	
	public PulverizerRecepie(ItemStack input, ItemStack output, ItemStack randomoutut, int randomnumber, boolean randomoutput) {
		this.input = input;
		this.output = output;
		this.randomoutut = randomoutut;
		this.randomnumber = randomnumber;
	}
	
	public ItemStack getInput() {
		return input;
	}
	
	public ItemStack getOutput() {
		return output;
	}
	
	public ItemStack getRandomSecondoutput() {
		
		if (randomoutput) {
			int i = new Random().nextInt(randomnumber);
			if (i > 5) {
				return randomoutut;
			}
			
			return null;
			
		} else {
			
			return randomoutut;
		}
		
	}
	
	public ItemStack getSecondOutput() {
		return new ItemStack(UItems.cdust);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PulverizerRecepie) {
			PulverizerRecepie re = (PulverizerRecepie) obj;
			if (input != null && re.getInput() != null && re.getInput().isItemEqual(this.input)) {
				return true;
			}
		}
		return false;
	}
}
