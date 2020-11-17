package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import managers.GameManager;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameManager manager = new GameManager();
        primaryStage.setTitle("Anaconda");

        Group root = new Group();
        List<Node> node = manager.getViewNodes();
        root.getChildren().addAll(node);

        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
