package io.github.mc_umod.gui.inventory;

import java.awt.Color;

import io.github.mc_umod.api.render.StringMethod;
import io.github.mc_umod.util.RGBA;
import net.minecraft.inventory.IInventory;

public class ColorSlot extends BaseSlot {
	
	public Color color;
	
	public ColorSlot(Color c, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		color = c;
		this.setHoverColor(new RGBA(color).setAlpha(25), new RGBA(color).setAlpha(25), new RGBA(color).setAlpha(255), new RGBA(color).setAlpha(255));
		this.setStringRet(new StringMethod() {
			
			@Override
			public String getString() {
				return "Color Slot put dye in\nFor color: " + (color.equals(Color.RED) ? "Red" : (color.equals(Color.GREEN) ? "Green" : color.equals(Color.blue) ? "Blue" : ("" + color.getRed() + "," + color.getGreen() + "," + color.getBlue())));
			}
		});
	}
	
	@Override
	public int getFontColor() {
		return 0xFFFFFF;
	}
	
}
