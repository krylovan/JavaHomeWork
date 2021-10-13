package com.pb.krylov.hw2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        float rezult = 0;
        String sign;
        System.out.println("Введите operand1(int):");
        operand1 = scan.nextInt();
        System.out.println("Введите operand2(int):");
        operand2 = scan.nextInt();
        System.out.println("Введите sign(+-*/):");
        sign = scan.next();
        switch (sign) {
            case "+":
                rezult=operand1+operand2;
                break;
            case "-":
                rezult=operand1-operand2;
                break;
            case "*":
                rezult=operand1*operand2;
                break;
            case "/":
                if (operand2==0) {
                    System.out.println("На 0 делить нельзя");
                    }else {
                    rezult = ((float)operand1)/operand2;
                    }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sign);
        }


        System.out.println("Значение выражения "+operand1+sign+operand2+"="+rezult);
    }
}
