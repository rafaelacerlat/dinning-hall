package com.dinning_hall.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DinningHall {

    public static List<Table> tables = new ArrayList<>();
    public static List<Waiter> waiters = new ArrayList<>();

    public static void main(String[] args) {

        SpringApplication.run(DinningHall.class, args);
        initiateTables(10);
        initiateWaiters(5);


        TableHandling clientGenerator = new TableHandling(tables);
        new Thread(clientGenerator).start();
        for(Waiter waiter: waiters){
            new Thread(waiter).start();
        }
    }

    public static void initiateTables(int numberOfTables){
        for(int i = 1; i <= numberOfTables; i++){
            Table table = new Table(TableState.FREE);
            table.setId(i);
            tables.add(table);
        }
    }

    public static void initiateWaiters(int numberOfWaiters){
        for(int i = 1; i <= numberOfWaiters; i++){
            Waiter waiter = new Waiter(tables);
            waiter.setId(i);
            waiters.add(waiter);
        }
    }

}
