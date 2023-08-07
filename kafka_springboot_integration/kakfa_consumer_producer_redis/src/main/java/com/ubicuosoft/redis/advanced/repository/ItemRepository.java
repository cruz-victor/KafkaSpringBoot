package com.ubicuosoft.redis.advanced.repository;

import com.ubicuosoft.redis.advanced.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ItemRepository {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public String save(String item, String id) {
        redisTemplate.opsForValue().set(getKey(id), String.valueOf(item));
        return item;
    }

    public String find(String id) {
        return redisTemplate.opsForValue().get(getKey(id));
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(getHashKey());
    }

    public void update(Item item) {
        //save(item);
    }

    public void delete(String id) {
        redisTemplate.opsForHash().delete(getKey(id));
    }

    private String getKey(String id) {
        return "item:" + id;
    }

    private String getHashKey() {
        return "item";
        //return "item:123abc";
    }
}
