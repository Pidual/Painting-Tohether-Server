import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PaintingServer {

    private final int PUERTO = 1234;
    private ServerSocket serverSocket;


    public PaintingServer() throws IOException{
        serverSocket = new ServerSocket(PUERTO);
    }

    public void start() throws IOException{
        while(true){

            System.out.println("Servidor esperando conexiones... ");
            Socket socket = serverSocket.accept();
            System.out.println("Entrada aceptada");

            new ServerThread(socket);
        }
    }
}
