package Networking.Server;

import Networking.TestDriver;
import Networking.Utils.Payload;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// thread that manages one socket connection with a client
public class ClientHandler extends Thread {
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outStream;

    // runtime context
    CommonRuntime runtime;

    public ClientHandler(Socket _socket) throws IOException {
        socket = _socket;
        inputStream = new ObjectInputStream(socket.getInputStream());
        outStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object o = inputStream.readObject();
                String translation = "null";
                if ((int)o != 0)
                    translation = (int) o == 1 ? "left" : "right";
                System.out.println("CLIENTHANDLER | Read object: " + o + " = " + translation);

                // temp
                Payload payload = TestDriver.createRandomPayload();
                outStream.writeObject(payload);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void addRuntime(CommonRuntime _runtime) {
        runtime = _runtime;
    }
}