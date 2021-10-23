package com.pb.krylov.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        String mstr1 = "Я в мире — сирота.";
        String mstr2 = "Я в Риме — Ариост.";
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку 1:");
        String mstr3 = in.nextLine();
        System.out.println("Введите строку 1:");
        String mstr4 = in.nextLine();


        if (isAnagram(mstr3,mstr4))
        System.out.println(mstr3+"\n"+mstr4+"\n"+"есть Анаграмма");
        else
            System.out.println(mstr3+"\n"+mstr4+"\n"+"не есть Анаграмма");

    }
    static boolean isAnagram(String str1, String str2){
        String s1=str1.toUpperCase().replaceAll("\\s|[^А-Я0-9]","");
        String s2=str2.toUpperCase().replaceAll("\\s|[^А-Я0-9]","");

        char[] astr1= s1.toCharArray();
        char[] astr2= s2.toCharArray();

        for (int i=0; i<s1.length();i++){
            for(int j=0; j<s2.length();j++){
                if (astr1[i]==astr2[j]) {astr1[i]=astr2[j]='-';break;}
            }
        }
        for (int i=0; i<s1.length()-1;i++){
            if (astr1[i]!='-') {return false;}
        }
        for (int i=0; i<s2.length()-1;i++){
            if (astr2[i]!='-') {return false;}
        }
return true;
    }
    static boolean isAnagram2(String str1, String str2){
        String s1=str1.toUpperCase().replaceAll("\\s|[^А-Я0-9]","");
        String s2=str2.toUpperCase().replaceAll("\\s|[^А-Я0-9]","");

        char[] astr1= s1.toCharArray();
        char[] astr2= s2.toCharArray();
        Arrays.sort(astr1);
        Arrays.sort(astr2);


        return Arrays.equals(astr1, astr2);
    }
}
