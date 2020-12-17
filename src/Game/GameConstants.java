package Game;

import javafx.scene.paint.Color;

import java.util.HashSet;

public class GameConstants {
    public static final int rotSize = 5; // degrees of rotation per tick
    public static final int tickSpeed = 100; // tick speed
    public static final Color[] colors = new Color[] {  Color.BLUE,
            Color.RED,
            Color.GREEN,
            Color.YELLOW,
            Color.PURPLE,
            Color.LIGHTCYAN};
    public static HashSet usedColors = new HashSet();
}
