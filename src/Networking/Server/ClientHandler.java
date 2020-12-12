package Networking.Server;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// thread that manages one socket connection with a client
public class ClientHandler extends Thread {
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outSteam;


    public ClientHandler(Socket _socket) throws IOException {
        socket = _socket;
        inputStream = new ObjectInputStream(socket.getInputStream());
        outSteam = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object o = inputStream.readObject();
                System.out.println("Read object: " + o);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}