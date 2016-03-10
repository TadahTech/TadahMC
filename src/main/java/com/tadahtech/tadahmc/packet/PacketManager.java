package com.tadahtech.tadahmc.packet;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class PacketManager {

    private static Map<String, IPacket> packets = Maps.newHashMap();

    public static IPacket getPacket(String name) {
        return packets.get(name);
    }

}
