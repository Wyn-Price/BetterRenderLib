package com.wynprice.brl.config;

import java.io.File;

import com.wynprice.brl.core.BetterRenderCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;

public class BetterRenderConfig 
{
	public static final Configuration CONFIG = new Configuration(new File(BetterRenderCore.mcLocation, "config/BetterRenderLib.cfg"));
	
	public static void syncConfig()
	{
		CONFIG.load();
		
		boolean posted = false;
		for(EnumAddon addon : EnumAddon.values())
		{
			Property property = CONFIG.get("addons", addon.getName(), true);
			if(!posted)
				property.setComment("Addons");
			posted = true;
			addon.setEnabled(property.getBoolean());
		}
		
		CONFIG.save();
		
	}
}
