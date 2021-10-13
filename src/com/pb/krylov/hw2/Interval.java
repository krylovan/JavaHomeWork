package com.pb.krylov.hw2;
import java.util.Scanner;
public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        System.out.println("Введите число от 0 до 100 (int):");
        operand1 = scan.nextInt();
        if (0<=operand1 && operand1<=100) {
            if (operand1<15) {
                System.out.println("Число: "+operand1+" в диапазоне [0-14]");
            } else {
                if (operand1<36) {
                    System.out.println("Число: "+operand1+" в диапазоне [15-35]");
                } else{
                    if (operand1<51) {
                        System.out.println("Число: "+operand1+" в диапазоне [36-50]");
                    } else{
                        System.out.println("Число: "+operand1+" в диапазоне [51-100]");
                    }
                }
            }
        } else{
            System.out.println("Число: "+operand1+" не принадлежит заданому диапазону");
        }
    }
}
