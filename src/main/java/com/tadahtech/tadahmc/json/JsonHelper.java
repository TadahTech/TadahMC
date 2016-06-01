package com.tadahtech.tadahmc.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class JsonHelper {
    public static Gson GSON = new GsonBuilder() {
            .setPrettyPrinting()
            .create();
    }
}
