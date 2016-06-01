package com.tadahtech.tadahmc;

import com.tadahtech.tadahmc.logger.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class TadahMain extends JavaPlugin {

    private static TadahMain instance;
    private String serverInstance;

    public static TadahMain getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.serverInstance = getConfig().getString("server-instance");
        System.out.println("Server has successfully started with TadahMC's plugin!");
        Log.info("This plugin's file, Logger.java, in directory com.tadahtech.tadahmc.logger.Logger,");
        Log.info("...has successfully started! You can play now :)");
    }

    public String getServerInstance() {
        return serverInstance;
    }
}
