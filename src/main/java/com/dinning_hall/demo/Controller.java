package com.dinning_hall.demo;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private static final Logger logger = LogManager.getLogger(Controller.class);

    private static final List<PreparedOrder> orders = new ArrayList<>();

    private static void add(PreparedOrder preparedOrder){
        orders.add(preparedOrder);
    }

    public static List getOrders(){
        return orders;
    }
   
	@PostMapping("/distribution")
	public void redirect(@RequestBody PreparedOrder order) {
        //waiters take the returned prepared orders
        add(order);

        logger.log(Level.INFO, "Received api call from kitchen / received prepared order" + order);
    }
}
