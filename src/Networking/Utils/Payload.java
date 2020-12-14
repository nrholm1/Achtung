package Networking.Utils;

import java.io.Serializable;
import java.util.HashMap;

public class Payload implements Serializable {
    // positions = {playerId/PORT: [x,y]}
    // gameState = 0, 1, 2 (in progress, game over, you won)

    HashMap<Integer, double[]> positions;
    int gameState;

    public void setPositions(HashMap<Integer, double[]> _positions) {
        positions = _positions;
    }
    public void addPosition(int id, double[] coord) {
        positions.put(id, coord);
    }

    public void setGameState(int _gameState) {
        gameState = _gameState;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String inputState = "in progress";
        if (gameState != 0)
            inputState = gameState == 1 ? "game over" : "you won";
        sb.append(inputState);

        for(var v : positions.keySet())
            sb.append("\n(" + (int)positions.get(v)[0] + ", " + (int)positions.get(v)[1] + ")");

        return sb.append("\n").toString();
    }

    public Payload() {
        positions = new HashMap<Integer, double[]>();
        gameState = 0;
    }
}