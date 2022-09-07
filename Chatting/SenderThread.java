package SixTeam;
import java.net.*;
import java.io.*;

class SenderThread extends Thread {
   Socket socket;
   String name;
   SixTeam six;
   String text;
   BufferedReader reader;
   PrintWriter writer;

   SenderThread(Socket socket, String nickName) {
	   this.socket = socket;
	   this.name = nickName;

   }


public void run() {
	  
      try {
    	 
         reader = new BufferedReader(new InputStreamReader(System.in));
         writer = new PrintWriter(socket.getOutputStream());
         
         writer.println(name);
         writer.flush();

         while (true) {
            String str = reader.readLine();
        	 
            if (str.equals("bye"))
               break;
            
           writer.println(str);
            writer.flush();
            
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         try {
            socket.close();
         } catch (Exception ignored) {
         }
      }
   }

}