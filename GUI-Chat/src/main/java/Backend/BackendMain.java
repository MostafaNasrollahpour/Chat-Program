package Backend;


import java.io.IOException;


public class BackendMain {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
    }
}
