package com.dinning_hall.demo;

import java.util.List;
import java.util.Map;

public class Order {
    private int order_id;
    private int table_id;
    private int waiter_id;
    private List<Integer> items;
    private int priority;
    private float max_wait;
    private long pick_up_time;
    int cooking_time;
    // add cooking_details

    // constructor for creating orders from tables(clients)
    public Order(int table_id, List<Integer> items, int priority, float max_wait){
        this.table_id = table_id;
        this.items = items;
        this.priority = priority;
        this.max_wait = max_wait;
    }

    public int getOrderId(){
        return order_id;

    }
    public int getTableId(){
        return table_id;
    }
    
    public int getWaiterId(){
        return waiter_id;
    }
    
    public List<Integer> getItems(){
        return items;
    }

    public int getPriority(){
        return priority;
    }
    public float getMaxWait(){
        return max_wait;
    }
    public long getPickUpTime(){
        return pick_up_time;
    }

    public void setOrderId( int order_id){
        this.order_id = order_id;
    }

    public void setTableId( int table_id){
        this.table_id = table_id;
    }

    public void setWaiterId( int waiter_id){
        this.waiter_id = waiter_id;
    }
    
    public void setItems( List<Integer> items){
        this.items = items;
    }
    
    public void setPriority( int priority){
        this.priority = priority;
    }


    @Override
    public String toString() {
        return ("id: " + this.getOrderId()+
                "\n table: "+ this.getTableId() +
                "\n waiter: "+ this.getWaiterId() +
                "\n items : " + this.getItems()) +
                "\n priority: " + this.getPriority() +
                "\n max_wait: " + this.getMaxWait();
    }

}
