package com.coders.endupdate.content.Config;


import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.Util.JsonUtil;
import com.coders.endupdate.content.worldgen.biome.ModBiomes;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import com.mojang.logging.LogUtils;
import glitchcore.util.Environment;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ModConfig {
    private static final String BIOME_CONFIG_FILE_NAME = "biome_toggles.json";
    private static Map<String, Boolean> biomeToggles;
    private static final TreeMap<String, Boolean> defaultBiomeToggles = Maps.newTreeMap();

    private static final Logger LOGGER = LogUtils.getLogger();

    public static GenerationConfig generation = new GenerationConfig();
    public static GameplayConfig gameplay = new GameplayConfig();

    public static void setup()
    {
        createConfigDirectoryIfNecessary();
    }

    public static boolean isBiomeEnabled(ResourceKey<Biome> key)
    {
        if (key == null || !key.location().getNamespace().equals(EndUpdate.MODID))
            return false;

        String optionName = getBiomeConfigOptionName(key);
        Map<String, Boolean> biomeToggles = getBiomeToggles();

        // Add the biome toggle if it is missing
        if (!biomeToggles.containsKey(optionName))
        {
            addBiomeToggle(key);
        }

        return biomeToggles.get(optionName);
    }

    private static Map<String, Boolean> getBiomeToggles()
    {
        if (biomeToggles == null)
        {
            createConfigDirectoryIfNecessary();
            biomeToggles = JsonUtil.getOrCreateConfigFile(getBOPConfigPath().toFile(), BIOME_CONFIG_FILE_NAME, defaultBiomeToggles, new TypeToken<TreeMap<String, Boolean>>(){}.getType());
        }
        return biomeToggles;
    }

    private static String getBiomeConfigOptionName(ResourceKey<Biome> key)
    {
        return key.location().getPath() + "_enabled";
    }

    private static void addBiomeToggle(ResourceKey<Biome> key)
    {
        getBiomeToggles().put(getBiomeConfigOptionName(key), true);
        updateConfigFile();
    }

    private static void updateConfigFile()
    {
        JsonUtil.writeFile(getBOPConfigFile(), getBiomeToggles());
    }

    private static void createConfigDirectoryIfNecessary()
    {
        // Create the config folder
        try
        {
            Files.createDirectory(getBOPConfigPath());
        }
        catch (FileAlreadyExistsException e)
        {
            // Do nothing
        }
        catch (IOException e)
        {
            LOGGER.error("Failed to create biomesoplenty config directory", e);
        }
    }

    private static Path getBOPConfigPath()
    {
        return Environment.getConfigPath().resolve(EndUpdate.MODID + "/");
    }

    private static File getBOPConfigFile()
    {
        return new File(getBOPConfigPath().toFile(), BIOME_CONFIG_FILE_NAME);
    }

    static
    {
        defaultBiomeToggles.putAll(ModBiomes.getAllBiomes().stream().collect(Collectors.toMap(ModConfig::getBiomeConfigOptionName, key -> true)));
    }
}