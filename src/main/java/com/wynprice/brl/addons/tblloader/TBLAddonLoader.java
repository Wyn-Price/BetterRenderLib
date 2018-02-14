package com.wynprice.brl.addons.tblloader;

import com.wynprice.brl.config.IBRLAddonLoader;

import net.minecraftforge.client.model.ModelLoaderRegistry;

public class TBLAddonLoader implements IBRLAddonLoader
{

	@Override
	public String getClassName() {
		return "com.wynprice.brl.addons.tblloader.FallbackResourceManagerTransformer";
	}
	
	@Override
	public void init() 
	{
		ModelLoaderRegistry.registerLoader(new TBLModelLoader());
	}

}
