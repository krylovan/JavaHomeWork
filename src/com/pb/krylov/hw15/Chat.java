package com.pb.krylov.hw15;

import com.sun.xml.internal.ws.resources.SenderMessages;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    private JPanel Chat;
    public JTextArea textPane1;
    private JTextField textField1;
    private JButton SendButton;
    private JButton exit;


    private ClientforChat client=new ClientforChat();
    public Chat() {
        DefaultCaret caret = (DefaultCaret) textPane1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        SendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textPane1.setText(textField1.getText());
                client.sendMessage(textField1.getText());
                textField1.setText("");




            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.close();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat");
        frame.setContentPane(new Chat().Chat);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



    public class ClientforChat {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private String message="";
        private Resender resend;


        public ClientforChat() {
            System.out.println("Клиент стартовал");
            String serverIp = "127.0.0.1";
            int serverPort = 1234;
            System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort);
            Scanner scan = new Scanner(System.in);

            //Socket server = new Socket(serverIp, serverPort);

            try {

                socket = new Socket(serverIp, serverPort);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                resend = new Resender();
                resend.start();

             //   resend.setStop();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // close();
            }
        }


        private void close() {
            try {
                sendMessage("exit");
                resend.setStop();
                in.close();
                out.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("!");
            }
        }

        public void sendMessage(String message) {
            out.println(message);
            this.message = message;
        }


        private class Resender extends Thread {

            private boolean stoped;


            public void setStop() {
                stoped = true;
            }


            @Override
            public void run() {
                try {
                    while (!stoped) {
                        String str = in.readLine();
                        System.out.println(str);
                        textPane1.append(str+"\n");

                    }
                } catch (IOException e) {
                    System.err.println(".");
                    e.printStackTrace();
                }
            }
        }


    }
}
