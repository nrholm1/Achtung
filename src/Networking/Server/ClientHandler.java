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

    // next Payload to be sent to client
    Payload nextPayload;

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
                int playerInput = (int) inputStream.readObject();
                String translation = "null";
                if (playerInput != 0)
                    translation = playerInput == 1 ? "left" : "right";
                currentInput = playerInput;
//                System.out.println("CLIENTHANDLER | Read object: " + playerInput + " = " + translation);

                // temp
                if (nextPayload == null)
                    nextPayload = TestDriver.createRandomPayload();
                outStream.writeObject(nextPayload);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
//            break;
            // TODO: probably a tick speed should be set here
        }
    }

    public int getCurrentInput() {
        return currentInput;
    }

    public void setNextPayload(Payload _payload) {
        nextPayload = _payload;
    }

    public void addRuntime(CommonRuntime _runtime) {
        runtime = _runtime;
    }
}