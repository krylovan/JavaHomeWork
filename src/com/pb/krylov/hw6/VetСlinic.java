package com.pb.krylov.hw6;


import java.lang.reflect.Constructor;
import java.util.Arrays;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Cat c1 = new Cat("Черная");
        Cat c2 = new Cat("Рыжая");
        Cat c3 = new Cat("Черная");

        System.out.println("eq? "+c1+c2+c1.equals(c2));
        System.out.println("eq? "+c1+c3+c1.equals(c3));


        System.out.println("HC1-"+c1.hashCode());
        System.out.println("HC2-"+c2.hashCode());
        System.out.println("HC3-"+c3.hashCode());



        Animal[] animals = {new Cat("Черная"), new Dog("злая"),new Dog("добрая"), new Horse(20)};

        Veterinarian vet = new Veterinarian();
        Class clazz = vet.getClass();
        System.out.println(clazz.getName());
        System.out.println(Arrays.toString(clazz.getMethods()));
        Class vetClazz = Class.forName("com.pb.krylov.hw6.Veterinarian");
        Constructor constructor = vetClazz.getConstructor();
        Object obj = constructor.newInstance();
        if (obj instanceof Veterinarian) {
            Veterinarian vet2 = ((Veterinarian) obj);
            for (Animal mAnimal : animals) {
                System.out.println("Пришел на прием " +mAnimal);
                vet2.treatAnimal(mAnimal);
            }
        }






        }
}
