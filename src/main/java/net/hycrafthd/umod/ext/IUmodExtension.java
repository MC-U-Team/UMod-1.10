package net.hycrafthd.umod.ext;

import net.hycrafthd.umod.ext.abs.*;
import net.minecraftforge.fml.common.event.*;

public interface IUmodExtension {
	
	public void preinit(FMLPreInitializationEvent evt);
	
	public void init(FMLInitializationEvent evt);
	
	public void postinit(FMLPostInitializationEvent evt);
	
	public AbstractOreDictionaryRegistry oredirctionary();
	
	public AbstractRecipeRegistry recipes();
	
	public void serverstarting(FMLServerStartingEvent evt);
	
	public void clientRegistry();
	
}
