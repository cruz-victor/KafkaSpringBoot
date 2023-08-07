package com.ubicuosoft.redis.advanced.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.redis.advanced.entity.Item;
import com.ubicuosoft.redis.advanced.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

//    public ItemService(ItemRepository itemRepository){
//        this.itemRepository=itemRepository;
//    }

    @Autowired
    private ObjectMapper objectMapper;


    public void save(Item item) throws JsonProcessingException {
        var json=objectMapper.writeValueAsString(item);
        itemRepository.save(json,item.getId());
        //itemRepository.save(item);
    }

    public String find(String id) {
        return itemRepository.find(id);
    }

    public Item find2(String id) throws JsonProcessingException {
        var i=itemRepository.find(id);
        var item=objectMapper.readValue(i, Item.class);
        return item;
    }

    public Map<Object, Object> findAll() {
        return itemRepository.findAll();
    }

    public void update(Item item) {
        itemRepository.update(item);
    }

    public void delete(String id) {
        itemRepository.delete(id);
    }
}
