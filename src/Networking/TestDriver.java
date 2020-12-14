package Networking;

import Networking.Client.Client;
import Networking.Server.CommonRuntime;
import Networking.Server.SocketListener;
import Networking.Utils.Payload;
import Networking.Utils.PayloadBuilder;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class TestDriver {
    public static void main(String args[]) throws InterruptedException, IOException {
        Payload payload = new PayloadBuilder()
                .withGameState(0)
                .withPosition(69, new double[] {420, 32})
                .create();
        System.out.println(payload);

//        testServer();
//        testListenerTimeout();
        testCommonRuntime();
    }

    public static Payload createRandomPayload() {
        return new PayloadBuilder()
                .withPositions(createRandomPositions())
                .withGameState((int) (Math.random() * 3))
                .create();
    }

    public static HashMap<Integer,double[]> createRandomPositions() {
        HashMap<Integer, double[]> positions = new HashMap<>();
        for(int x = 0; x < 3; x++)
            positions.put((int)(Math.random() * 7), new double[] {Math.random() * 69, Math.random() * 420});
        return positions;
    }

    public static Client startClientWithPort(int _port) throws IOException {
        Socket socketToServer = new Socket("localhost", _port);
        return new Client(socketToServer);
    }

    public static void testCommonRuntime() throws IOException {
        CommonRuntime runtime = new CommonRuntime();
        startClientWithPort(5050);
        startClientWithPort(5053);
    }

    // TODO: not implemented yet!
    public static void testListenerTimeout() throws IOException, InterruptedException {
        SocketListener listener = new SocketListener(5050);
        listener.start();
    }

    public static void testServer() throws IOException {
        SocketListener listener = new SocketListener(5050);
        listener.start();

        Client client = startClientWithPort(5050);

        client.run();

        System.exit(0);
    }

    public static void testServerFakeClient() throws IOException {
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

            outStream.writeObject(createRandomPayload());
        }
        System.exit(0);
    }
}