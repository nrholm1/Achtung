package Networking.Server;

import Game.PlayerObjects.Kurwe;

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

    public Kurwe createPlayerKurwe() {
        return new Kurwe(this.PORT);
    }

    @Override
    public void run() {
        // TODO: add timeout condition -> perhaps timestamp field for start listening and check for each run of loop
        while (true) {
            try {
                final Socket socketToClient = socket.accept();
                ClientHandler clientHandler = new ClientHandler(socketToClient);
                clientHandler.start();
                System.out.println("ClientHandler for port {" + PORT + "} started");

                if (runtime != null) {
                    runtime.addClientHandler(PORT, clientHandler);
                    clientHandler.addRuntime(runtime);
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Killing listener thread");
            }
        }
    }
}