package SixTeam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerExample4 {
   static ArrayList<String> cInfo= new ArrayList<>(); 
   
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9002);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트 연결 접수됨..");
                
                Thread thread = new PerClinetThread(socket, ServerExample4.cInfo);
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}