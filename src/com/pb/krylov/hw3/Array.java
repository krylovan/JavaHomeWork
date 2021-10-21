package com.pb.krylov.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        int x = array.length;
        int sum = 0;
        int countpositive = 0;
        Scanner scanner = new Scanner(System.in);
        // Заполнение массива.
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите " + i + " элемент массива: ");
            array[i] = scanner.nextInt();

        }

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
            sum += array[i];
            if (array[i] > 0) countpositive++;
        }
        System.out.println("Сумма элементов массива :" + sum);
        System.out.println("Число позитивных элементов массива :" + countpositive);

        //Сортировка
       /* int tmp;
        boolean isswap = true;
           for (int i = array.length - 1; i > 0; i--) {
            if (isswap) {
                isswap=false;
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        tmp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = tmp;
                        isswap = true;
                    }
                }
            } else break;
        }*/
        int n= array.length;
        do {
            int newn=0;
            for (int j=1;j<(n);j++){
                if (array[j-1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    newn = j;
                }
            }
            n=newn;
        }while (n>0);


        // Специальная запись цикла for для прохождения элементов массива (Java 8)
        // Аналогична конструкции foreach, используемой в других языках программирования (например C#, PHP)
        // for (int ключ, массив)
        System.out.println("Отсортированый массив :");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }
}
