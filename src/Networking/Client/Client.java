package Networking.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {
    Socket socketToServer;
    ObjectInputStream inputStream;
    ObjectOutputStream outStream;
    int currentInput;

    public Client(Socket _socket) throws IOException {
        System.out.println("Creating Client");

        socketToServer = _socket;
        System.out.println("socket initialized");

        outStream = new ObjectOutputStream(socketToServer.getOutputStream());
        System.out.println("output stream initialized");

        inputStream = new ObjectInputStream(socketToServer.getInputStream());
        System.out.println("input stream initialized");

        System.out.println("Client created");
    }

    @Override
    public void run() {
        while (true) {
            try {
                // temp
                currentInput = (int) (Math.random() * 3);

                writeCurrentInput(currentInput);
                Object o = readPayload();
                System.out.println("Read object: " + o);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void writeCurrentInput(int input) throws IOException {
        System.out.println("Writing object: " + input);
        outStream.writeObject(input);
    }

    public Object readPayload() throws IOException, ClassNotFoundException {
        return inputStream.readObject();
    }
}
