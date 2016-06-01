package com.tadahtech.tadahmc.logger;

import java.util.logging.Level; 
import java.util.logging.Logger; 

public class Log {
    public static final Logger LOGGER = Logger.getLogger("Minecraft-Server");
    public static final Logger srvLog = ""; // can be changed to null
    public static final Logger plgLog = ""; // can be changed to null
    public Log() {
        throw new AssertionError();
    }
    
    // Log.info (regular information)
    public static void logInformation(String msg) {
        logInformation(msg, false);
    }
    
    public static void logInformation(String msg, Boolean raw) {
        log(Level.INFO, msg, raw);
    }
    
    public static void logInformation(Throwable ex) {
        log(Level.INFO, ex);
    }
    
    // Log.warn (warning information)
    public static void logWarning(String msg) {
        logWarning(msg, false);
    }
    
    public static void logWarning(String msg, Boolean raw) {
        log(Level.WARNING, msg, raw);
    }
    
    public static void logWarning(Throwable ex) {
        log(Level.WARNING, ex);
    }
}
