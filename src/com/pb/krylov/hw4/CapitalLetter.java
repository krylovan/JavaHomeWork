package com.pb.krylov.hw4;

import java.util.Scanner;

public class CapitalLetter {
    static String ChangeFirstLetter(String str) {
        char[] astr = str.toCharArray();
        StringBuilder b = new StringBuilder();
        b.append(Character.toUpperCase(astr[0]));

        for (int i = 1; i < str.length(); i++) {
            if (Character.isWhitespace(astr[i - 1])) b.append(Character.toUpperCase(astr[i]));
            else b.append(astr[i]);
        }
        return b.toString();

    }

    static String ChangeFirstLetter2(String str) {
        StringBuilder b = new StringBuilder();
        b.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i - 1))) b.append(Character.toUpperCase(str.charAt(i)));
            else b.append(str.charAt(i));
        }
        return b.toString();

    }


    public static void main(String[] args) {
        String mstr1 = "Истина — это то, что выдерживает проверку опытом. Эйнштейн А.";
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        String mstr = in.nextLine();
        System.out.println(ChangeFirstLetter(mstr));
        System.out.println(ChangeFirstLetter2(mstr));


    }
}
