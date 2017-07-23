package io.github.mc_umod.gui.mode;

import io.github.mc_umod.gui.GuiBase;
import io.github.mc_umod.gui.items.ImplGui;

public class ModeNormal extends ImplGui{

	public ModeNormal(GuiBase base_gui) {
		super(base_gui);
	}

	@Override
	public void render(int mouseX, int mouseY) {}
	
	@Override
	public void onClick(int mouseX, int mouseY) {
		base_gui.handelMouseInput(mouseX, mouseY);
	}
	
}
