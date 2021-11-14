package com.pb.krylov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, int cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболку одевает мужчина");
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболку одевает женщина");
    }
}
