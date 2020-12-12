package Networking;

import Networking.Server.SocketListener;
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



        SocketListener listener = new SocketListener(5050);
        listener.start();

        Socket socketToServer = new Socket("localhost", 5050);
        ObjectOutputStream outStream = new ObjectOutputStream(socketToServer.getOutputStream());

        for (int i=1; i<10; i++) {
            try {
                Thread.sleep((long) (Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending object to server ...");
            payload = new PayloadBuilder()
                    .withX(Math.random() * 69)
                    .withY(Math.random() * 420)
                    .withCurrInput((int) (Math.random() * 3))
                    .create();
            outStream.writeObject(payload);
        }
        System.exit(0);
    }
}