package Networking.Server;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Thread {
    public int PORT;
    private ServerSocket socket;
    ObjectInputStream objIn;
    ObjectOutputStream objOut;

    public SocketListener(int _port) throws IOException {
        System.out.println("Starting Server");
        PORT = _port;
        socket = ServerSocketFactory.getDefault().createServerSocket(_port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Socket socketToClient = socket.accept();
                ClientHandler server = new ClientHandler(socketToClient);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
