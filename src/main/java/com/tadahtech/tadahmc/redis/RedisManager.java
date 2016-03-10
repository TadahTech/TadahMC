package com.tadahtech.tadahmc.redis;

import com.tadahtech.tadahmc.packet.IPacket;
import org.bukkit.configuration.file.FileConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class RedisManager {

    public static String CHANNEL = "TadahMC-Redis-Channel";
    private String host, password;
    private FileConfiguration config;
    private JedisPool pool;

    public RedisManager(FileConfiguration config) {
        this.config = config;
        connect();
    }

    private void connect() {
        try {
            String host = config.getString("host");
            String password = config.getString("password", "");
            this.host = host;
            int redisPort = config.getInt("port", 6379);
            int database = config.getInt("database", 1);
            pool = new JedisPool(new JedisPoolConfig(), host, redisPort, Integer.MAX_VALUE, password == null || password.isEmpty() ? null : password, database);
            this.pool = new JedisPool(host);
            subscribe();
        } catch (Exception e) {
            System.out.println("ERROR Connecting to Redis! Is it running? Exception: " + e.getMessage());
        }
    }

    private void subscribe() {
        new Thread(() -> {
            Jedis subscriber = new Jedis(host);
            subscriber.subscribe(new MessageListener(), CHANNEL);
        }).start();
    }

    public void sendInfo(IPacket packet, String message, String server) {
        Jedis jedis = pool.getResource();
        try {
            jedis.publish(CHANNEL, packet.getName() + "%" + message + "%" + server);
        } catch (Exception e) {
            System.out.println("Something went wrong! Reestablishing connection to the database");
            connect();
        } finally {
            pool.returnResource(jedis);
        }
    }

    public JedisPool getPool() {
        return pool;
    }


}
