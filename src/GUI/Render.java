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
            Color color = GameConstants.colors[kurwe];
            renderKurwe(graphics, kurwes.get(kurwe), color);
        }
    }

    public static void renderKurwes(GraphicsContext graphics, Set<Kurwe> kurwes) {
        for(Kurwe kurwe : kurwes) {
            Color color = GameConstants.colors[kurwe.getColorId()];
            renderKurwe(graphics, kurwe.getPositionVec().coord.getPositionForRender(), color);
        }
    }

    public static void renderKurwe(GraphicsContext graphics, double[] position, Color color) {
        graphics.setFill(color);
        graphics.fillOval(position[0], position[1], 5, 5);
    }
}
