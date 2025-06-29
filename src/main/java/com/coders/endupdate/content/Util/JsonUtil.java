package com.coders.endupdate.content.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import java.io.File;
import java.lang.reflect.Type;

public class JsonUtil
{

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Gson SERIALIZER = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T getOrCreateConfigFile(File configDir, String configName, T defaults, Type type)
    {
        File configFile = new File(configDir, configName);

        //No config file, so create default config:
        if (!configFile.exists())
        {
            writeFile(configFile, defaults);
        }

        try
        {
            return (T)SERIALIZER.fromJson(FileUtils.readFileToString(configFile), type);
        }
        catch (Exception e)
        {
            LOGGER.error("Error parsing config from json: " + configFile.toString(), e);
        }

        return null;
    }

    public static boolean writeFile(File outputFile, Object obj)
    {
        try
        {
            FileUtils.write(outputFile, SERIALIZER.toJson(obj));
            return true;
        }
        catch (Exception e)
        {
            LOGGER.error("Error writing config file " + outputFile.getAbsolutePath() + ": " + e.getMessage());
            return false;
        }
    }
}