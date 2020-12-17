package GUI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class GameWindowController implements IController {
    Button changeSceneBtn;
    HBox hbBtn;

    GridPane grid;

    Canvas canvas;
    GraphicsContext graphics;

    Scene scene;
    StackPane root;
    MenuController menuController;

    public void initRoot() {
        root = new StackPane();
    }

    public void setMenuController(MenuController _menuController) {
        this.menuController = _menuController;
    }

    public Scene createScene() {
        ObservableList<Node> nodes = this.root.getChildren();
        nodes.removeAll();
        nodes.add(createGrid());


        if (this.scene == null)
            this.scene = new Scene(this.root, 1150, 1002);

        initPlayerInputListener();

        return this.scene;
    }

    public GridPane createGrid() {
        initGrid();
        createGridElements();
        addGridElements();
        return this.grid;
    }

    public void initGrid() {
        this.grid = new GridPane();
        this.grid.setAlignment(Pos.CENTER_LEFT);
        this.grid.setHgap(1);
        this.grid.setVgap(1);
        this.grid.setPadding(new Insets(25, 25, 25, 1));
    }

    public void createGridElements() {
        initChangeSceneButton();
        initButtonContainer();
        initCanvas();
        initGraphics();
    }

    public void addGridElements() {
        this.grid.add(this.canvas, 0, 0);
        this.grid.add(this.hbBtn, 2,  0);
    }

    public void initChangeSceneButton() {
        this.changeSceneBtn = new Button("Change Scene");
        this.changeSceneBtn.setOnAction(actionEvent -> Main.changeScene(menuController.createScene()));
    }

    public void initCanvas() {
        this.canvas = new Canvas(1000,1000);
    }

    public void initGraphics() {
        graphics = canvas.getGraphicsContext2D();
        graphics.setFill(Color.BLACK);
        graphics.fillOval(-500, -500, 2000, 2000);
    }

    public void initPlayerInputListener() {
        // add handler for player input
         scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
              // send playerInput to client if A or D
             if (key.getCode().getChar().equals("A") ||
                 key.getCode().getChar().equals("D"))
                 System.out.print(key.getCode().getChar()); // handleEvent
         });
    }

    public void initButtonContainer() {
        this.hbBtn = new HBox(10);
        this.hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        this.hbBtn.getChildren().add(this.changeSceneBtn);
    }
}