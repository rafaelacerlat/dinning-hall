package com.dinning_hall.demo;

import java.util.List;

public class PreparedOrder {
    private int order_id, table_id, waiter_id;
    private List<Integer> items;
    private int priority;
    private long max_wait;
    private long pick_up_time;
    private long cooking_time;
    private List<CookingDetails> cooking_details;

    public int getWaiter_id() {
        return waiter_id;
    }

    public int getTableId() {
        return table_id;
    }

    public void setPick_up_time(long pick_up_time) {
        this.pick_up_time = pick_up_time;
    }

    public void setMax_wait(long max_wait) {
        this.max_wait = max_wait;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setCooking_time(long cooking_time) {
        this.cooking_time = cooking_time;
    }

    public void setCooking_details(List<CookingDetails> cooking_details) {
        this.cooking_details = cooking_details;
    }
}

