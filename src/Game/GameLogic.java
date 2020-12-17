package Game;

import Game.PlayerObjects.Kurwe;

import java.util.HashMap;

public class GameLogic {
    public static void moveKurwesAndCollisionDetect(HashMap<Integer, Kurwe> kurwes, boolean[][] visitedPoints) {
        for(var k : kurwes.values()) {
            k.move();
            if(collisionDetection(k, visitedPoints))
                // handle collision
                System.out.println(k.getPlayerId() + " has collided");
        }
    }

    public static boolean collisionDetection(Kurwe k, boolean[][] visitedPoints) {
        int xFieldIndex = (int) (k.getPositionVec().coord.v1
                - k.getPositionVec().coord.v1 % 5) / 5 - 1;
        int yFieldIndex = (int) (k.getPositionVec().coord.v2
                - k.getPositionVec().coord.v2 % 5) / 5 - 1;

        if (xFieldIndex < 0 || yFieldIndex < 0 ||
                xFieldIndex >= 200 || yFieldIndex >= 200)
            return true;

        if (visitedPoints[xFieldIndex][yFieldIndex]
                && !k.isInLastVisited(xFieldIndex, yFieldIndex))
            return true;
        else
            visitedPoints[xFieldIndex][yFieldIndex] = true;
        return false;
    }

    public static void handlePlayerInput(Kurwe player, int input) {
        // 0, 1, 2 -> null, left, right
        if (input == 0)
            return;
        // input==2 -> setNewAngle(clockwise = true) -> goes right
        player.setNewAngle(input == 2);
    }
}
