package com.pb.krylov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        int attempt = 0;           // Счетчик попыток.
        int bingo = random.nextInt(101);      // Задуманное число
        Scanner in = new Scanner(System.in);
        int ValueInt;
        System.out.println("Угадайте целое число в диапазоне от 0 до 100 ()" + bingo);
        System.out.println("Для выхода из программы введите - x");


        while (true) {
            attempt++;
            System.out.println("Попытка " + attempt + ":");
            String value = in.next();
            try {
                ValueInt = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Введено не число");
                break;
            }

            if (ValueInt < bingo) {
                System.out.println(" задуманное число больше");
                continue;

            }

            if (ValueInt > bingo) {
                System.out.println(" задуманное число меньше");
                continue;
            }

            System.out.println("Поздравляем, Вы угадали с " + attempt + " попытки!");
            break;
        }

        System.out.println("Конец игры!");
    }

}
