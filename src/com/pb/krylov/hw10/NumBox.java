package com.pb.krylov.hw10;


import com.pb.krylov.hw8.WrongPasswordException;

public class NumBox <T extends Number>{

    private T[] arrayN;

    public int getLength() {
        return Length;
    }

    private int Length=0;

    public NumBox(int Size) {
        arrayN = (T[]) new Number[Size];
    }
    public void add(T num) throws WrongSizeException {
        if ((Length + 1) > arrayN.length) throw new WrongSizeException("Массив переполнен");
        arrayN[Length++]=num;
    }
    public T get(int index){
        return arrayN[index];
    }
    public double sum(){
        double sum=0;
        for (int i=0;i<(Length);i++){
            sum+=arrayN[i].doubleValue();
        }
        return sum;
    }
    public double average(){
        double sum=0;
        for (int i=0;i<(Length);i++){
            sum+=arrayN[i].doubleValue();
        }
        return sum/Length;
    }
    public T max(){
        T maxe=arrayN[0];
        for (int i=1;i<(Length);i++){
            if (maxe.doubleValue()<arrayN[i].doubleValue()) maxe=arrayN[i];
        }
        return maxe;
    }
    public static <T> String nameOf(T o) {
        return o.getClass().getSimpleName();
    }
    public void demo(){
        System.out.println("Размер тип массива :"+this.Length +" "+this.get(0).getClass().getSimpleName());
        System.out.println("Первый элемент :"+this.get(0));
        System.out.println("Размер массива :"+this.Length);
        System.out.println("Сумма массива :"+this.sum());
        System.out.println("Макс массива :"+this.max());
        System.out.println("Среднее массива :"+this.average());
    }

    public static void main(String[] args) {
        NumBox<Float> floatNumBox=new NumBox<>(5);
        try {
            floatNumBox.add(3F);
            floatNumBox.add(10F);
            floatNumBox.add(20F);
        } catch (WrongSizeException e) {
            e.printStackTrace();
        }
         floatNumBox.demo();

        NumBox<Integer> intNumBox=new NumBox<>(6);
        try {
            intNumBox.add(7);
            intNumBox.add(99);
            intNumBox.add(45);
            intNumBox.add(4);
            intNumBox.add(8);
        } catch (WrongSizeException e) {
            e.printStackTrace();
        }
        intNumBox.demo();






    }
}
