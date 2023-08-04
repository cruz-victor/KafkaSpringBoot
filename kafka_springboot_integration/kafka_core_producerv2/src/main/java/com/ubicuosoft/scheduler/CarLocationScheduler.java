package com.ubicuosoft.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ubicuosoft.entity.CarLocation;
import com.ubicuosoft.producer.CarLocationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CarLocationScheduler {
    private CarLocation carOne;
    private CarLocation carTwo;
    private CarLocation carThree;

    @Autowired
    CarLocationProducer carLocationProducer;

    public  CarLocationScheduler(){
        var now=System.currentTimeMillis();
        this.carOne=new CarLocation("car-one",now,0);
        this.carTwo=new CarLocation("car-two",now,150);
        this.carThree=new CarLocation("car-three",now,50);
    }

    @Scheduled(fixedRate = 1000)
    public void generateCarLocation() throws JsonProcessingException {
        var now=System.currentTimeMillis();

        this.carOne.setTimestamp(now);
        this.carOne.setDistance(carOne.getDistance()+1);
        this.carLocationProducer.send(carOne);

        this.carTwo.setTimestamp(now);
        this.carTwo.setDistance(carTwo.getDistance()-1);
        this.carLocationProducer.send(carTwo);

        this.carThree.setTimestamp(now);
        this.carThree.setDistance(carThree.getDistance()+1);
        this.carLocationProducer.send(carThree);
    }
}
