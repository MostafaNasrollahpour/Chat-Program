package Backend;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A New Client Joined The Chat!");
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


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket1 = new ServerSocket(5693);
        Server server = new Server(serverSocket1);

        server.startServer();
    }
}
