package Networking.Server;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener extends Thread {
    public int PORT;
    private ServerSocket socket;
    ObjectInputStream objIn;
    ObjectOutputStream objOut;

    public ConnectionListener(int _port) throws IOException {
        System.out.println("Starting Server");
        PORT = _port;
        socket = ServerSocketFactory.getDefault().createServerSocket(_port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Socket socketToClient = socket.accept();
                Server server = new Server(socketToClient);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
