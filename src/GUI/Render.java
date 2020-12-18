package GUI;

import Game.GameConstants;
import Game.PlayerObjects.Kurwe;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Set;

public class Render {
    public static void renderKurwes(GraphicsContext graphics, HashMap<Integer, double[]> kurwes) {
        for(int kurwe : kurwes.keySet()) {
            // minus 5050 because of inconsistency with ID's throughout application
            Color color = GameConstants.colors[kurwe - 5050];
            renderKurwe(graphics, kurwes.get(kurwe), color);
        }
    }

    public static void renderKurwes(GraphicsContext graphics, Set<Kurwe> kurwes) {
        for(Kurwe kurwe : kurwes) {
            Color color = GameConstants.colors[kurwe.getColorId()];
            renderKurwe(graphics, kurwe.getPositionVec().coord.getPositionInDoubles(), color);
        }
    }

    public static void renderKurwe(GraphicsContext graphics, double[] position, Color color) {
//        graphics.setFill(color);
        graphics.setFill(Color.CORNFLOWERBLUE);
        graphics.fillOval(position[0], position[1], 50, 50);
        System.out.println(position[0] + ", " + position[1]);
    }
}
