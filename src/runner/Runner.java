import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            new PaintingServer().start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
