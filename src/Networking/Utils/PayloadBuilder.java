package Networking.Utils;

import java.util.HashMap;

public class PayloadBuilder {
    Payload payload;

    public PayloadBuilder() {
        payload = new Payload();
    }

    public Payload create() {
        return payload;
    }

    public PayloadBuilder withPositions(HashMap<Integer, double[]> positions) {
        payload.setPositions(positions);
        return this;
    }

    public PayloadBuilder withPosition(int id, double[] position) {
        payload.addPosition(id, position);
        return this;
    }

    public PayloadBuilder withGameState(int _gameState) {
        payload.setGameState(_gameState);
        return this;
    }
}