package Networking.Server;

import Game.GameLogic;
import Game.PlayerObjects.Kurwe;
import Networking.TestDriver;
import Networking.Utils.Payload;
import Networking.Utils.PayloadBuilder;

import java.util.HashMap;

public class StateRenderer {
    // <port, kurwe obj>
    private static final HashMap<Integer, Kurwe> players = new HashMap<>();
    private static final boolean[][] visitedPoints = new boolean[200][200];

    public static Kurwe getPlayerById(int port) {
        return players.get(port);
    }

    public static void addPlayer(int port, Kurwe player) {
        players.put(port, player);
    }

    public static void handleMultiplayerInput(HashMap<Integer, Integer> inputs) {
        for (int port : inputs.keySet()) {
            GameLogic.handlePlayerInput(getPlayerById(port), inputs.get(port));
        }
    }

    public static HashMap<Integer, double[]> getPlayerPositionMap() {
        HashMap<Integer, double[]> positionMap = new HashMap<>();

        for(int port : players.keySet())
                positionMap.put(port, players.get(port)
                                             .getPositionVec()
                                             .coord.getPositionInDoubles());

        return positionMap;
    }

    public static Payload ComputeState(HashMap<Integer, Integer> playerInputs) {
        handleMultiplayerInput(playerInputs);

        GameLogic.moveKurwesAndCollisionDetect(players, visitedPoints);

        return new PayloadBuilder()
                              .withGameState(1) // temp GameState 1
                              .withPositions(getPlayerPositionMap())
                              .create();
        // temp
//        return TestDriver.createRandomPayload();
    }
}
