package com.ubicuosoft.redis.advanced.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ubicuosoft.redis.advanced.entity.Item;
import com.ubicuosoft.redis.advanced.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) throws JsonProcessingException {
        itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Item> getItem(@PathVariable String id) {
//        String item = itemService.find(id);
//        if (item != null) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        //return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable String id) throws JsonProcessingException {
        Item item = itemService.find2(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllItems() {
        Map<Object, Object> items = itemService.findAll();
        return new ResponseEntity<Object>(items, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item) {
        String existingItem = itemService.find(id);
        if (existingItem != null) {
            //item.setId(existingItem.getId());
            itemService.update(item);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}