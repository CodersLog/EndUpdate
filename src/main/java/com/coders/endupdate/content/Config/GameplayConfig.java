package com.coders.endupdate.content.Config;
import com.coders.endupdate.EndUpdate;
import glitchcore.config.Config;
import glitchcore.util.Environment;

public class GameplayConfig extends Config
{
    public boolean wanderingTraderTrades;

    public GameplayConfig()
    {
        super(Environment.getConfigPath().resolve(EndUpdate.MODID + "/gameplay.toml"));
    }

    @Override
    public void load()
    {
        wanderingTraderTrades = add("general.wandering_trader_trades", true, "Add various BOP resources to the Wandering Trader trade pool.");
    }
}