package com.pb.krylov.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMultiThread {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
// цикл ожидания сообщений от клиента
                System.out.println("Ожидаем сообщений");
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    System.out.println(clientMessage);
                    // имитация долгой обработки запроса
                    System.out.println("Ждем  имитируя долгую обработку");
                    Thread.sleep(3 * 1000);
                    out.println("Сервер: " +LocalDateTime.now().toString()+" "+ clientMessage);
                }



                System.out.println("Закрываем соединение с клиентом");
                out.close();
                in.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
