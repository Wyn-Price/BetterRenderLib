package com.wynprice.brl.addons.plastic;

import com.wynprice.brl.config.IBRLAddonLoader;
import com.wynprice.brl.handlers.PlasticCommand;
import com.wynprice.brl.handlers.TextureStitch;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;

public class PlasticAddonLoader implements IBRLAddonLoader
{

	@Override
	public String getClassName() {
		return "com.wynprice.brl.addons.plastic.ForgeBlockModelRendererTransformer";
	}
	
	@Override
	public void init() 
	{
		MinecraftForge.EVENT_BUS.register(new TextureStitch());		
		ClientCommandHandler.instance.registerCommand(new PlasticCommand());
	}

}
