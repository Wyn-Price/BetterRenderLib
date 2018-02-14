package com.wynprice.brl.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IBRLAddonLoader 
{
	/**
	 * Please return the raw string, as this is called before classloading
	 */
	public String getClassName();
	
	/**
	 * Called if the addon is initiated, during {@link FMLPreInitializationEvent}
	 */
	public default void init() {}
}
