package GUI;

import Networking.Client.Client;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.Socket;

public class MenuController implements IController {
    Button changeSceneBtn;
    Button connectBtn;
    Text alertText;
    HBox hbBtn;

    Label username;
    Label ipTarget;
    Label portTarget;
    TextField usernameField;
    TextField ipTargetField;
    TextField portTargetField;

    GridPane grid;

    Scene scene;
    StackPane root;
    GameWindowController gwController;

    public void initRoot() {
        root = new StackPane();
    }

    public void setGwController(GameWindowController _gwController) {
        this.gwController = _gwController;
    }

    public Scene createScene() {
        ObservableList<Node> nodes = this.root.getChildren();
        nodes.removeAll();
        nodes.add(createGrid());

        if (this.scene == null)
            this.scene = new Scene(this.root, 1000, 1000);
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
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25, 25, 25, 25));
    }

    public void createGridElements() {
        initFormLabels();
        initFormFields();
        initAlertText();
        initConnectButton();
        initChangeSceneButton();
        initButtonContainer();
    }

    public void addGridElements() {
        this.grid.add(this.username, 0, 1);
        this.grid.add(this.usernameField, 0,2);
        this.grid.add(this.ipTarget, 0, 3);
        this.grid.add(this.ipTargetField, 0,4);
        this.grid.add(this.portTarget, 0, 5);
        this.grid.add(this.portTargetField, 0,6);
        this.grid.add(this.alertText, 0,8);
        this.grid.add(this.hbBtn, 0, 7);
    }

    public void initFormLabels() {
        this.username = new Label("Username");
        this.ipTarget = new Label("Host IP");
        this.portTarget = new Label("Port");
    }

    public void initFormFields() {
        this.usernameField = new TextField();
        this.ipTargetField = new TextField("localhost");
        this.portTargetField = new TextField("505X");
    }

    public void initAlertText() {
        this.alertText = new Text();
    }

    public void initConnectButton() {
        this.connectBtn = new Button("Connect");
        this.connectBtn.setOnAction(actionEvent -> {
            alertText.setFill(Color.FIREBRICK);
            alertText.setText("Connecting to " + ipTargetField.getText() + ":" + portTargetField.getText());
            Main.setHostIp(ipTargetField.getText());
            Main.setHostPort(portTargetField.getText());

            try {
                Main.startClient();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void initChangeSceneButton() {
        this.changeSceneBtn = new Button("Change Scene");
        this.changeSceneBtn.setOnAction(actionEvent -> {
            Main.changeScene(gwController.createScene());
            Main.startAnimationTimer();
        });
    }

    public void initButtonContainer() {
        this.hbBtn = new HBox(10);
        this.hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        this.hbBtn.getChildren().add(this.changeSceneBtn);
        this.hbBtn.getChildren().add(this.connectBtn);
    }
}