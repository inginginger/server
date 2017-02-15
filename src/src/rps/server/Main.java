package src.rps.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServerSocket socketListener = null;
        Socket client = null;
        try{
            socketListener = new ServerSocket(8189);
            System.out.println("Сервер активен. Ожидание подключения...");
            client = socketListener.accept();
            Scanner sc = new Scanner(client.getInputStream());
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            while(true) {
                String str = sc.nextLine();
                if(str.equals("end")) break;
                pw.println("Echo: " + str);
                pw.flush();
            }
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
