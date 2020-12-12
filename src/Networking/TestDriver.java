package Networking;

import Networking.Server.Server;
import Networking.Utils.Payload;
import Networking.Utils.PayloadBuilder;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestDriver {
    public static void main(String args[]) throws InterruptedException, IOException {
        Payload payload = new PayloadBuilder()
                .withX(69)
                .withY(420)
                .withCurrInput(3)
                .create();
        System.out.println(payload);



        Server server = new Server(5050);
        server.start();

        Socket socketToServer = new Socket("localhost", 5050);
        ObjectOutputStream outStream = new ObjectOutputStream(socketToServer.getOutputStream());

        for (int i=1; i<10; i++) {
            try {
                Thread.sleep((long) (Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending object to server ...");
            outStream.writeObject("test message #"+i);
        }
        System.exit(0);
    }
}