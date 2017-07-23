package io.github.mc_umod.event;

import net.minecraft.world.GameRules;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventLoadWorld {
	
	@SubscribeEvent
	public void onEvent(WorldEvent.Load event) {
		event.getWorld().getGameRules().addGameRule("allowExplosion", "true", GameRules.ValueType.BOOLEAN_VALUE);
	}
	
}
