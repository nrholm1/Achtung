package Networking.Server;

import Game.GameLogic;
import Game.PlayerObjects.Kurwe;
import Networking.TestDriver;
import Networking.Utils.Payload;

import java.util.HashMap;

public class StateRenderer {
    // <port, kurwe obj>
    private static HashMap<Integer, Kurwe> players = new HashMap<>();
    private static boolean[][] visitedPoints = new boolean[200][200];

    public static Kurwe getPlayerById(int port) {
        return players.get(port);
    }

    public static void addPlayer(int port, Kurwe player) {
        players.put(port,player);
    }

    public static void handleMultiplayerInput(HashMap<Integer, Integer> inputs) {
        for (int port : inputs.keySet())
            GameLogic.handlePlayerInput(getPlayerById(port),
                                        inputs.get(port));
    }

    public static Payload ComputeState(HashMap<Integer, Integer> playerInputs) {
        // disable temp
//        GameLogic.moveKurwesAndCollisionDetect(players, visitedPoints);

        // temp
        return TestDriver.createRandomPayload();
    }
}
