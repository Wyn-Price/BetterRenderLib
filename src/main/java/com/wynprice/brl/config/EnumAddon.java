package com.wynprice.brl.config;

import com.wynprice.brl.addons.plastic.PlasticAddonLoader;
import com.wynprice.brl.addons.tblloader.TBLAddonLoader;

public enum EnumAddon 
{
	PLASTIC("plastic", new PlasticAddonLoader()),
	TBLLOADER("tbl-loader", new TBLAddonLoader());
	
	
	private final String name;
	private final IBRLAddonLoader loader;
	private boolean enabled;
	
	private EnumAddon(String name, IBRLAddonLoader loader) 
	{
		this.name = name;
		this.loader = loader;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public IBRLAddonLoader getLoader() {
		return loader;
	}
}
