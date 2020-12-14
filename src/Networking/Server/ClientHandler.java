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

    // stores current input (from player: 0,1,2 -> null,left,right)
    int currentInput;

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
                Object obj = inputStream.readObject();
                String translation = "null";
                if ((int)obj != 0)
                    translation = (int) obj == 1 ? "left" : "right";
                currentInput = (int)obj;
                System.out.println("CLIENTHANDLER | Read object: " + obj + " = " + translation);

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

    public int getCurrentInput() {
        return currentInput;
    }

    public void addRuntime(CommonRuntime _runtime) {
        runtime = _runtime;
    }
}