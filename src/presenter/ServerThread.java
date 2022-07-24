import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{

    // private Models modelo
    private DataInputStream input;
    private DataOutputStream output;

    public ServerThread(Socket socket) throws IOException {
        //modelo - new modelo
        output = new DataOutputStream(socket.getOutputStream());
        while (true){
           String texto = input.readUTF();
        }
    }
}
