package com.dinning_hall.demo;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter extends Thread {
    private int id;
    private final List<Table> tables;

    private List<PreparedOrder> preparedOrders = Controller.getOrders();



    Waiter(List<Table> tables) {
        this.tables = tables;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    @Override
    public void run() {
        try {
            while (true) {

                for (Table table : tables) {
                    if (table.getState().equals(TableState.READY) && table.mutex.tryLock()) {
                        Order order;

                        order = table.createRandomOrder();

                        // order set pick up time


                        order.setWaiterId(id);
                        sendOrder(order); // sends order to kitchen
                        table.setState(TableState.WAITING); // set table state to WAITING (for the food to be delivered back)
                        for (String s : Arrays.asList(order.toString(), "Table " + table.getId() + " is waiting for food preparation")) {
                            System.out.println(s);
                        }

                        Thread.sleep(2000);
                        table.mutex.unlock(); // releasing lock for other threads
                    }
                }

                for( int i = 0; i < preparedOrders.size(); i++){
                   PreparedOrder order = preparedOrders.get(i);
                   if (order.getWaiter_id() == id) {
                       Table table = tables.get(order.getTableId());
                       table.setState(TableState.FREE);
                   }
                }
            }
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendOrder(Order order){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Order> requestBody = new HttpEntity<>(order);
        restTemplate.postForObject("http://localhost:8080/order", requestBody, Order.class);

    }
}
