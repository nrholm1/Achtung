package GUI;

import Networking.Client.Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {
    static Stage _primaryStage;
    static String hostIp;
    static String hostPort;
    static Client client;

    public static void startClient() throws IOException {
        Socket socketToServer = new Socket(hostIp, Integer.parseInt(hostPort));
        client = new Client(socketToServer);
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

    public static void changeScene(Scene _scene) {
        _primaryStage.setScene(_scene);
    }

    public static void setHostIp(String _hostIp) {
        hostIp = _hostIp;
        System.out.println(hostIp);
    }

    public static void setHostPort(String _hostPort) {
        hostPort = _hostPort;
        System.out.println(hostPort);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
