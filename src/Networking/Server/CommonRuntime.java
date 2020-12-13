package Networking.Server;

import java.util.HashMap;

public class CommonRuntime {
    // interface with StateRenderer
    // create and manage sockets for communicating with clients
    // listen for new connections

    // start SocketListeners with new ports incrementally as more connections are created
    // timeout after a certain interval after last new connection and start game

    // store connections to client and interface with I/O data streams
    // <port no., ClientHandler>
    HashMap<Integer, ClientHandler> clientHandlers;

    public CommonRuntime() {
        clientHandlers = new HashMap<Integer, ClientHandler>();

        while(true) {

        }
    }

    public void addClientHandler(int port, ClientHandler clientHandler) {
        if (clientHandlers != null)
            clientHandlers.put(port, clientHandler);
        else
            System.out.println("ERROR: clientHandlers not initialized yet");
    }
}