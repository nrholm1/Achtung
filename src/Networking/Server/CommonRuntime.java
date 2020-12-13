package Networking.Server;

import java.util.ArrayList;

public class CommonRuntime {
    // interface with StateRenderer
    // create and manage sockets for communicating with clients
    // listen for new connections

    // start SocketListeners with new ports incrementally as more connections are created
    // timeout after a certain interval after last new connection and start game

    // store connections to client and interface with I/O data streams
    ArrayList<ClientHandler> clientHandlers;

    public CommonRuntime() {
        clientHandlers = new ArrayList<ClientHandler>();

        while(true) {

        }
    }
}