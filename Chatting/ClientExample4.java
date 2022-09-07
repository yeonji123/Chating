package SixTeam;
import java.net.*;

//클라이언트 클래스
class ClientExample4 {
	
 ClientExample4(String nickName, Socket socket) {
	SixTeam six;
	
	if (nickName == null) {
      System.out.println(
            "Usage: java ClientExample4 <user-name>");
      return;
   }
   try {
	   
	  
      SenderThread thread1 = new SenderThread(socket,nickName);
      six = new SixTeam(nickName,socket,thread1);
      Thread thread2 = new ReceiverThread(socket,six);
      
      thread1.start();
      thread2.start();
   }
   catch (Exception e) {
      System.out.println(e.getMessage());
   }
}
}