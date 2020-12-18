package GUI;

import Game.GameConstants;
import Networking.Client.Client;
import com.sun.prism.Graphics;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;

public class Main extends Application {
    static Stage _primaryStage;
    static GraphicsContext graphics;

    static String hostIp;
    static String hostPort;
    static Client client;

    public static void startClient() throws IOException {
        Socket socketToServer = new Socket(hostIp, Integer.parseInt(hostPort));
        client = new Client(socketToServer);
        client.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        _primaryStage = primaryStage;
        primaryStage.setTitle("java sux");

        GameWindowController gwController = new GameWindowController();
        gwController.initRoot();

        MenuController menuController = new MenuController();
        menuController.initRoot();

        menuController.setGwController(gwController);
        gwController.setMenuController(menuController);

        primaryStage.setScene(menuController.createScene());
        primaryStage.show();
    }

    // temporary probably
    public static void startAnimationTimer() {
        new AnimationTimer() {
            long lastTick = 0;

            @Override
            public void handle(long l) {
                if (lastTick == 0) {
                    lastTick = l;
                    Render.renderKurwes(graphics, client.getPlayerPositionMap());
                    return;
                }
                if (l - lastTick > 1000000000 / GameConstants.tickSpeed) {
                    lastTick = l;
                    Render.renderKurwes(graphics, client.getPlayerPositionMap());
                }
            }
        }.start();
    }

    public static void changeScene(Scene _scene) {
        _primaryStage.setScene(_scene);
    }

    public static void setGraphics(GraphicsContext _graphics) {
        graphics = _graphics;
    }

    public static void setHostIp(String _hostIp) {
        hostIp = _hostIp;
        System.out.println(hostIp);
    }

    public static void setHostPort(String _hostPort) {
        hostPort = _hostPort;
        System.out.println(hostPort);
    }

    public static void setCurrentInput(int _currentInput) {
        client.setCurrentInput(_currentInput);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
