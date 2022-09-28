package com.dinning_hall.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;


public class Table {
    private int table_id;
    private TableState tableState;

    public final ReentrantLock mutex = new ReentrantLock(); // Creating A Mutex


    Table(TableState state){
        this.tableState =  state;
    }

    public int getId(){
        return table_id;
    }

    public TableState getState(){
        return tableState;
    }

    public void setId(int id){
        this.table_id = id;
    }

    public void setState(TableState state){
        this.tableState = state;
    }


    public Order createRandomOrder() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Food> menu = objectMapper.readValue(
                new File("C:\\Users\\User\\Desktop\\FAF\\FAF-sem5\\Network programming (PR)\\Dinning Hall\\dinning-hall\\src\\main\\java\\com\\dinning_hall\\demo\\foods.json"),
                new TypeReference<>(){});

        int numberOfItems = ThreadLocalRandom.current().nextInt(1,5);
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++){
            items.add(ThreadLocalRandom.current().nextInt(1,menu.size()));
        }

        int priority = (int) (Math.random()*5 + 1);
        int maxTime = 0;
        for (int item: items){
            if(menu.get(item).getPreparation_time() > maxTime) maxTime = menu.get(item).getPreparation_time();
        }
        float max_wait = (float) (maxTime*1.3);

        return new Order(table_id, items, priority, max_wait);
    }
    
}
