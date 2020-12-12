package Networking;

import Networking.Utils.Payload;
import Networking.Utils.PayloadBuilder;

public class TestDriver {
    public static void main(String args[]) throws InterruptedException {
        Payload payload = new PayloadBuilder()
                .withX(69)
                .withY(420)
                .withCurrInput(3)
                .create();
    }
}
