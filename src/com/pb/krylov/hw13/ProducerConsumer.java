package com.pb.krylov.hw13;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProducerConsumer {
    static class Reader implements Runnable {

        private final Lock readLock;
        private final Buffer buffer;

        public Reader(Lock readLock, Buffer buffer) {
            this.readLock = readLock;
            this.buffer = buffer;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 50; i++) {
                synchronized (buffer) {
                    try {
                        while (buffer.isEmpty()) {
                            System.out.println("\u001B[31m" + threadName + " Буффер пустой " + "\u001B[0m");
                            buffer.wait();
                        }
                        int seconds = new Random().nextInt(10);
                        Thread.sleep(seconds * 100);
                        System.out.println(threadName + " Прочитано из буффера: " + buffer.read() + " В буффере : " + buffer.getBufSize());
                        //  System.out.println(threadName + " В буффере : " + buffer.getBufSize());
                        buffer.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class Writer implements Runnable {

        private final Lock writeLock;
        private final Buffer buffer;
        private final String str;

        public Writer(Lock writeLock, Buffer buffer, String str) {
            this.writeLock = writeLock;
            this.buffer = buffer;
            this.str = str;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 50; i++) {
                synchronized (buffer) {
                    try {
                        while (buffer.isFull()) {
                            System.out.println("\u001B[31m" + threadName + " Буффер заполнен " + "\u001B[0m");
                            buffer.wait();
                        }

                        int seconds = new Random().nextInt(10);
                        Thread.sleep(seconds * 100);
                        buffer.append(seconds);
                        System.out.println(threadName + " Запись в буффер числа " + seconds + " В буффере : " + buffer.getBufSize());


                        buffer.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        Buffer buffer = new Buffer(5);

        Thread writerA = new Thread(new Writer(writeLock, buffer, "a"));
        writerA.setName("Producer");
        Thread writerB = new Thread(new Writer(writeLock, buffer, "a"));
        writerB.setName("Producer2");
        Thread reader1 = new Thread(new Reader(readLock, buffer));
        reader1.setName("Consumer");
        Thread reader2 = new Thread(new Reader(readLock, buffer));
        reader2.setName("Consumer2");
        reader1.start();
        //reader2.start();

        writerA.start();
        //writerB.start();


    }
}
