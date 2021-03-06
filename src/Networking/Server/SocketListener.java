package Networking.Server;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Thread {
    public int PORT;
    private ServerSocket socket;

    private CommonRuntime runtime;

    public SocketListener(int _port) throws IOException {
        System.out.println("Starting Server");
        PORT = _port;
        socket = ServerSocketFactory.getDefault().createServerSocket(_port);
        System.out.println("Socket on {PORT " + _port + "} created succesfully");
    }

    public void setRuntimePointer(CommonRuntime _runtime) {
        runtime = _runtime;
    }

    @Override
    public void run() {
        // TODO: add timeout condition -> perhaps timestamp field for start listening and check for each run of loop
        while (true) {
            try {
                final Socket socketToClient = socket.accept();
                ClientHandler clientHandler = new ClientHandler(socketToClient);

                if (runtime != null) {
                    runtime.addClientHandler(PORT, clientHandler);
                    clientHandler.addRuntime(runtime);
                }

                clientHandler.start();
                System.out.println("ClientHandler for port {" + PORT + "} started");

                break;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Killing listener thread");
            }
        }
    }
}