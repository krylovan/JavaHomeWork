package com.pb.krylov.hw13;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = "A Product, производственная нить:"
                    + Thread.currentThread().getName();
            System.out.println("I have made a product:"
                    + Thread.currentThread().getName());
            queue.put(temp); // Если очередь заполнена, она заблокирует текущий поток
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Consumer implements Runnable {
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take(); // Если очередь пуста, она заблокирует текущий поток
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class PCconcurrent {
        public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        // BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        // Если не установлено, по умолчанию размер LinkedBlockingQueue равен Integer.MAX_VALUE

        // BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for (int i = 0; i < 5; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();

            new Thread(consumer, "Consumer" + (i + 1)).start();
        }
    }
}