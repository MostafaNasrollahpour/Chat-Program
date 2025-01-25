package Backend;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String userName;



    public Client(Socket socket, String userName) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.userName = userName;


            bufferedWriter.write(userName);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message;
                Scanner scanner = new Scanner(System.in);
                while (true){
                    message = scanner.nextLine();
                    if (message.trim().isEmpty()) {
                        continue;
                    }
                    try {
                        bufferedWriter.write(message);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void getMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String message = bufferedReader.readLine();
                        System.out.println(message);
                    }catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter Your Name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        Socket socket1 = new Socket("localhost", 5693);

        Client client = new Client(socket1, userName);
        client.sendMessage();
        client.getMessage();
    }
}