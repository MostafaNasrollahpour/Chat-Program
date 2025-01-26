package Backend;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private final ServerSocket serverSocket;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(5693);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startServer() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket);
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
