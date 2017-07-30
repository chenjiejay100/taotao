package com.taotao.sso.dao.JedisClient.impl;

import com.taotao.sso.dao.JedisClient.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * Created by bing on 2017/7/22.
 */
@Component
public class JedisClientCluster implements JedisClient {
    //@Autowired 是byType的，@Resource是byName的
    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key, value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisCluster.expire(key, second);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public long del(String key) {
        return 0;
    }

    @Override
    public long hdel(String hkey, String key) {
        return 0;
    }

}

