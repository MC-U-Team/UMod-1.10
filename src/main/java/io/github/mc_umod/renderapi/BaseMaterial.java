package io.github.mc_umod.renderapi;

import java.awt.Color;

import io.github.mc_umod.util.RGBA;

/**
 * Material that is used when no Material is given
 * 
 * @author MrTroble
 *
 */

public class BaseMaterial extends Material {
	
	public BaseMaterial() {
		super("BaseMaterial");
		this.setColor(new RGBA(Color.WHITE).setAlpha(125));
	}
	
}
