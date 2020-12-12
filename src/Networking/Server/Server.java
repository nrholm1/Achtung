package Networking.Server;

import java.io.*;
import java.net.Socket;

// thread that manages one socket connection with a client
public class Server extends Thread {
    int PORT;
    ObjectInputStream objIn;
    ObjectOutputStream objOut;

    public Server(int _port) {
        PORT = _port;
    }

    @Override
    public synchronized void start() {

    }
}
