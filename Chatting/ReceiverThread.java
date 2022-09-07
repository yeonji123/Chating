package SixTeam;
import java.io.*;
import java.net.*;
class ReceiverThread extends Thread {
    Socket socket;
    SixTeam six;
    ReceiverThread(Socket socket,SixTeam six) {
        this.socket = socket;
        this.six = six;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                six.textArea.append(str+"\n");
                System.out.println(str);
                
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}