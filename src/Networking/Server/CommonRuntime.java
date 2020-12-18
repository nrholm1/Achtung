package Networking.Server;

import Game.PlayerObjects.Kurwe;
import Networking.Utils.Payload;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CommonRuntime extends Thread {
    // interface with StateRenderer
    // create and manage sockets for communicating with clients
    // listen for new connections

    // store connections to client and interface with I/O data streams
    // Concurrent version to avoid concurrent modification exception
    // <port no., ClientHandler>
    ConcurrentHashMap<Integer, ClientHandler> clientHandlers;

    // predefined ports - allows 4 concurrent connections currently
    final int[] PORTS = {5050, 5051, 5052, 5053};

    public CommonRuntime() throws IOException {
        clientHandlers = new ConcurrentHashMap<Integer, ClientHandler>();

        while(true) {
            // create socket listeners and add resulting clienthandlers to hashmap
            for(int port : PORTS) {
                if (!clientHandlers.containsKey(port)) {
                    SocketListener listener = new SocketListener(port);
                    listener.setRuntimePointer(this);
                    listener.start();
                }
            }
            break;
        }

        for(int port : clientHandlers.keySet())
            StateRenderer.addPlayer(port, createPlayerKurwe(port));


        System.out.println("CommonRuntime started");
    }

    public Kurwe createPlayerKurwe(int _port) {
        return new Kurwe(_port);
    }

    public void addClientHandler(int port, ClientHandler clientHandler) {
        if (clientHandlers != null)
            clientHandlers.put(port, clientHandler);
        else
            System.out.println("ERROR: clientHandlers not initialized yet");
    }

    @Override
    public void run() {
        while (true) {
            // main server loop

            // store playerInputs for StateRenderer
            // <PORT, input>
            HashMap<Integer, Integer> playerInputs = new HashMap<Integer, Integer>();
            for(int port : clientHandlers.keySet()) {
                playerInputs.put(port,
                        clientHandlers.get(port)
                                      .getCurrentInput());
//                System.out.println("COMMONRUNTIME | Input received from port {" + port + "}");
            }

            Payload payloadForClients = StateRenderer.ComputeState(playerInputs);
            for(int port : clientHandlers.keySet()) {
                clientHandlers.get(port)
                              .setNextPayload(payloadForClients);
//                System.out.println("COMMONRUNTIME | Payload set for port {" + port + "}");
            }
        }
    }
}