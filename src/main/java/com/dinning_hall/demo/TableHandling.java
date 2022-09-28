package com.dinning_hall.demo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.Semaphore;

public class TableHandling extends Thread{
    private final List<Table> tables;

    static Semaphore mutex = new Semaphore(1);        // Creating A Mutex

    TableHandling(List<Table> tables){
        this.tables = tables;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int random = ThreadLocalRandom.current().nextInt(1, tables.size() - 1);

                if (tables.get(random).getState() == TableState.FREE) {
                    tables.get(random).setState(TableState.READY);
                    System.out.println("Table " + tables.get(random).getId() + " is ready to order");
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
