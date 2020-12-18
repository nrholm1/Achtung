package Networking.Client;

import Networking.Utils.Payload;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Client extends Thread {
    Socket socketToServer;
    ObjectInputStream inputStream;
    ObjectOutputStream outStream;
    int currentInput;

    // payload contents
    HashMap<Integer, double[]> playerPositions;
    int gameState;

    public HashMap<Integer, double[]> getPlayerPositionMap() {
        return playerPositions;
    }

    public int getGameState() {
        return gameState;
    }

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
        while(true) {
            try {
                writeCurrentInput(currentInput);
                Payload _payload = (Payload) readPayload();
                this.playerPositions = _payload.getPositions();
                this.gameState = _payload.getGameState();
//                System.out.println("CLIENT | Read object: " + _payload);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // TODO: probably a tick speed should be set here
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeCurrentInput(int input) throws IOException {
        outStream.writeObject(input);
    }

    public Object readPayload() throws IOException, ClassNotFoundException {
        return inputStream.readObject();
    }

    public void setCurrentInput(int _currentInput) {
        currentInput = _currentInput;
    }
}