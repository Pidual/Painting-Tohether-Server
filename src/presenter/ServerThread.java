import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{

    private DataManagement data;
    private DataInputStream input;
    private DataOutputStream output;

    public ServerThread(Socket socket) throws IOException {
        System.out.println("Server Thread iniciado");
        data = new DataManagement();
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    @Override
    public synchronized void run() {
        while (true){
            String text = null;
            try {
                text = input.readUTF();
                data.addDataToTree(text);
                output.writeUTF(data.getData());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            actualizeAllThreads();
        }

    }

    public void actualizeAllThreads(){
        System.out.println(currentThread().getThreadGroup().getName());

    }


}
