package com.pb.krylov.hw6;

import com.pb.krylov.hw5.Book;

public class VetСlinic {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Черная"), new Dog("злая"), new Horse(20)};
        Veterinarian veterinarian = new Veterinarian();
        for (Animal mAnimal : animals) {
            veterinarian.treatAnimal(mAnimal);
        }
        }
}
