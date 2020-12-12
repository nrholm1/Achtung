package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    static Stage _primaryStage;

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

    public static void main(String[] args) {
        launch(args);
    }
}
