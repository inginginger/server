package src.rps.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServerSocket socketListener = null;
        Socket client = null;
        try {
            socketListener = new ServerSocket(8189);
            System.out.println("Сервер активен. Ожидание подключения...");
            while (true) {
                while (client == null) {
                    client = socketListener.accept();
                }
                new ClientThread(client); //Создаем новый поток, которому передаем сокет
            }
        }catch (SocketException e){
            System.out.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                socketListener.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
