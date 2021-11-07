package com.pb.krylov.hw6;

import java.util.Objects;

public class Cat extends Animal{
    public String  Color;

    public Cat(String color) {
        setFood("Fish");
        setLocation("tree");
        Color = color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Color);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(Color, cat.Color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Color cat='" + Color + '\'' +
                '}';
    }
}
