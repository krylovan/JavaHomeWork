package com.pb.krylov.hw6;

public class Cat extends Animal{
    public String  Color;

    public Cat(String color) {
        food= "Fish";
        location="tree";
        Color = color;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
