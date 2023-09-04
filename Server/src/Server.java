import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] a) throws IOException {
        try {
            ServerSocket server = new ServerSocket(3636);
            System.out.println("Server openned : 3636 ");
            Socket costumer = server.accept();
            System.out.println("Costumer logged on  "+costumer.getInetAddress().
                    getHostAddress());
            Scanner s = new Scanner(costumer.getInputStream());
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }

            s.close();
            server.close();
        }catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}

