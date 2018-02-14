package com.wynprice.brl.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.Lists;
import com.wynprice.brl.config.BetterRenderConfig;
import com.wynprice.brl.config.EnumAddon;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name(value = "BRL CORE")
@IFMLLoadingPlugin.MCVersion(value = "1.12.2")
@IFMLLoadingPlugin.TransformerExclusions({"com.wynprice.brl.core"})
@IFMLLoadingPlugin.SortingIndex(1001)
public class BetterRenderCore implements IFMLLoadingPlugin {

    public static boolean isDebofEnabled = false;
    public static File mcLocation;

    public BetterRenderCore() {
        FMLLog.info("[BetterRenderCore] Loaded core.");
    	BetterRenderConfig.syncConfig();
    }
    
    boolean postedAddons = false;

    @Override
    public String[] getASMTransformerClass() 
    {    	
    	
    	ArrayList<String> list = Lists.newArrayList //Core transformers. Must be used
    			(
    					"com.wynprice.brl.core.BlockRendererDispatcherTransformer",
        				"com.wynprice.brl.core.RegionRenderCacheBuilderTransformer",
        				"com.wynprice.brl.core.WorldVertexBufferUploaderTransformer"
    			);
    	
    	for(EnumAddon addon : EnumAddon.values())
    		if(addon.isEnabled())
    		{
    			if(!postedAddons)
    				LogManager.getLogger("BRLAddonManager").info("Loading addon: {}", addon.getName());
    			list.add(addon.getLoader().getClassName());
    		}
    	postedAddons = true;
    	String[] transformers = new String[list.size()];
    	for(int i = 0; i < list.size(); i++)
    		transformers[i] = list.get(i);
    	return transformers;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) 
    {
    	mcLocation = (File) data.get("mcLocation");
        isDebofEnabled = (boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}