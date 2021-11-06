package com.pb.krylov.hw6;

public class Animal {
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String  food, location;
    public void sleep() {
        System.out.println(" спит...");
            }
    public void eat() {
        System.out.println(" ест...");
    }
}
