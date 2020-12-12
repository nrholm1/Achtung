package Networking.Server;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// thread that manages one socket connection with a client
public class Server extends Thread {
    public int PORT;
    private ServerSocket socket;
    ObjectInputStream objIn;
    ObjectOutputStream objOut;

    public Server(int _port) throws IOException {
        System.out.println("Starting Server");
        PORT = _port;
        socket = ServerSocketFactory.getDefault().createServerSocket(_port);
    }

    @Override
    public synchronized void start() {
        while (true) {
            try {
                final Socket socketToClient = socket.accept();
                ClientHandler clientHandler = new ClientHandler(socketToClient);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        ObjectInputStream inputStream;

        public ClientHandler(Socket _socket) throws IOException {
            socket = _socket;
            inputStream = new ObjectInputStream(socket.getInputStream());
        }

        @Override
        public void start() {
            while (true) {
                try {
                    Object o = inputStream.readObject();
                    System.out.println(o);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
