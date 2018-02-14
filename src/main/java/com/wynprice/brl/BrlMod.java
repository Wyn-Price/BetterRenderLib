package com.wynprice.brl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wynprice.brl.addons.tblloader.TBLModelLoader;
import com.wynprice.brl.config.EnumAddon;
import com.wynprice.brl.handlers.PlasticCommand;
import com.wynprice.brl.handlers.TextureStitch;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "brl", name = "BetterRenderLib", version = "0.2.0")
public class BrlMod 
{
	
    public static final Logger LOGGER = LogManager.getLogger("BetterRenderLib");

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		for(EnumAddon addon : EnumAddon.values())
			if(addon.isEnabled())
				addon.getLoader().init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		OpenGlHelper.vboSupported = false;
		OpenGlHelper.vboSupportedAti = false;
	}
	
}
