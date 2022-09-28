package com.dinning_hall.demo;

public class Food {
    private int id;
    private String name;
    private int preparation_time;
    private int complexity;
    private String cooking_apparatus;

    public int getComplexity() {
        return complexity;
    }

    public int getPreparation_time() {
        return preparation_time;
    }

    public String getCooking_apparatus() {
        return cooking_apparatus;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return ("id: " + this.getId()+
                "\n name: "+ this.getName() +
                "\n preparation_time: "+ this.getPreparation_time() +
                "\n complexity : " + this.getComplexity()) +
                "\n cooking-apparatus: " + this.getCooking_apparatus();
    }
}
