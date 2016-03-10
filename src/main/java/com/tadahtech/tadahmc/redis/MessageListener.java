package com.tadahtech.tadahmc.redis;

import com.tadahtech.tadahmc.TadahMain;
import com.tadahtech.tadahmc.packet.IPacket;
import com.tadahtech.tadahmc.packet.PacketManager;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class MessageListener extends JedisPubSub {

    private static final String thisServer = TadahMain.getInstance().getServerInstance();

    @Override
    public void onMessage(String channel, String message) {
        if (!channel.equalsIgnoreCase(RedisManager.CHANNEL)) {
            return;
        }

        String[] str = message.split("%");
        String packetRaw = str[0];
        String msg = str[1];
        String server = str[2];
        IPacket packet = PacketManager.getPacket(packetRaw);

        if (packet == null) {
            return;
        }

        if(!server.equalsIgnoreCase(thisServer)) {
            return;
        }

        packet.receive(msg);
    }

    @Override
    public void onPMessage(String s, String s1, String s2) {

    }

    @Override
    public void onSubscribe(String s, int i) {

    }

    @Override
    public void onUnsubscribe(String s, int i) {

    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

    @Override
    public void onPSubscribe(String s, int i) {

    }

}
