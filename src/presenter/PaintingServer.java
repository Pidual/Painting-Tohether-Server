import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PaintingServer{
    private final int PUERTO = 1234;
    private ServerSocket serverSocket;
    private ArrayList<ServerThread> threads;


    public PaintingServer() throws IOException{
        serverSocket = new ServerSocket(PUERTO);
        threads = new ArrayList<>();
    }

    public void start() throws IOException {
        while(true){
            System.out.println("Servidor esperando conexiones... ");
            Socket socket = serverSocket.accept();
            new ServerThread(socket).start();
        }
    }
}
