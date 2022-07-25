import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{

    private DataManagement data;
    private DataInputStream input;
    private DataOutputStream output;

    public ServerThread(Socket socket) throws IOException {

        data = new DataManagement();
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
        while (true){
            String text = input.readUTF();
            data.addDataToTree(text);
            output.writeUTF(data.getData());
        }
    }
}
