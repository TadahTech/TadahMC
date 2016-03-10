package com.tadahtech.tadahmc.packet;

/**
 * Created by Timothy Andis (TadahTech)
 */
public interface IPacket {

    String getName();

    String getServer();

    void send(String message);
    void receive(String message);


}
