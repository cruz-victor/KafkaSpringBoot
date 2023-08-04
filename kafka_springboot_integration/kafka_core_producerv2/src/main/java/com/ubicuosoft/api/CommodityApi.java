package com.ubicuosoft.api;

import com.ubicuosoft.entity.Commodity;
import com.ubicuosoft.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commodity/v1")
public class CommodityApi {
    @Autowired
    CommodityService commodityService;

    @GetMapping(value = "/all")
    public List<Commodity> generateAllCommodities(){
        return commodityService.createDummyCommodities();
    }
}
