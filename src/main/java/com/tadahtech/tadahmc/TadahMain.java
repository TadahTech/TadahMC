package com.tadahtech.tadahmc;

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
    }

    public String getServerInstance() {
        return serverInstance;
    }
}
