package com.pb.krylov.hw9;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {
    void writeArray (byte [][] array,String FileName){
        BufferedWriter outputWriter = null;


        try {
            outputWriter = new BufferedWriter(new FileWriter(FileName));



            for (byte[] anArray : array) {

                for (byte element : anArray) {
                    outputWriter.write(element+" ");
                    System.out.print(element+" ");
                }
                System.out.println();
                outputWriter.newLine();
            };

            System.out.println("Data is written to the file :"+FileName);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {outputWriter.flush();
                outputWriter.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
    void createNumbersFile(){

            // Cоздаем массив
            byte[][] array = new byte[10][10];
            Random random = new Random();

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++){
                    array[i][j] = (byte) random.nextInt(101);
                }

            }
        writeArray(array,"numbers.txt");
    }
    void createOddNumbersFile() {
    BufferedReader inputReader = null;
    // Cоздаем массив

    byte[][] array = new byte[10][10];



    BufferedWriter outputWriter = null;
        try {
        inputReader = new BufferedReader(new FileReader("numbers.txt"));
        for (int i = 0; i < array.length; i++) {
            String[] strN=inputReader.readLine().split("\\s");

            for (int j = 0; j < array[i].length; j++){
                array[i][j] = Byte.parseByte(strN[j])%2==0 ?0:Byte.parseByte(strN[j]);
            }

        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        writeArray(array,"numbers-odd.txt");

}
    void createOddNumbersFile2() {
        // Cоздаем массив
        byte[][] array = new byte[10][10];
        Path path = Paths.get("numbers.txt");
        try (Scanner scan = new Scanner(path)) {


            while (true) {

                for (int i = 0; i < array.length; i++) {

                    for (int j = 0; j < array[i].length; j++) {
                        byte b =scan.nextByte();
                        array[i][j] = (b) % 2 == 0 ? 0 : b;
                    }
                }
            }
            } catch(NoSuchElementException ex){
                System.out.println("Файл прочитан.");
            } catch(IOException ex){
                ex.printStackTrace();
            }


            writeArray(array, "numbers-odd.txt");


    }

    public static void main(String[] args){
        FileNumbers FN=new FileNumbers();
        FN.createNumbersFile();
        FN.createOddNumbersFile2();


    }
}

