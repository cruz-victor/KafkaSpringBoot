package com.ubicuosoft.service;

import com.ubicuosoft.entity.Commodity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CommodityService {
    private final static Map<String,Commodity> COMMODITY_BASE=new HashMap<>();
    private final static String COOPER="cooper";
    private final static String GOLD="gold";
    private final double MAX_ADJUSTMENT=1.01d;
    private final double MIN_ADJUSTMENT=0.5d;

    static {
        var timestamp=System.currentTimeMillis();
        COMMODITY_BASE.put(COOPER, new Commodity("copper", 1.01d,"tone", timestamp));
        COMMODITY_BASE.put(GOLD, new Commodity("gold", 1.02d,"ounce", timestamp));
    }

    public Commodity createDummyCommodity(String name){
        if (!COMMODITY_BASE.containsKey(name)){
            throw new IllegalArgumentException("Invalid commodity : "+name);
        }

        var commodity=COMMODITY_BASE.get(name);
        var basePrice=commodity.getPrice();
        var newPrice=basePrice* ThreadLocalRandom.current().nextDouble(MIN_ADJUSTMENT, MAX_ADJUSTMENT);

        commodity.setPrice(newPrice);
        commodity.setTimestamp(System.currentTimeMillis());

        return commodity;
    }

    public List<Commodity> createDummyCommodities(){
        var result=new ArrayList<Commodity>();
        COMMODITY_BASE.keySet().forEach(c->result.add(createDummyCommodity(c)));
        return result;
    }
}
