import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VerticalButtonBarExecute extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VerticalButtonBar bar = new VerticalButtonBar();
        bar.addButton(new Button("A"));
        bar.addButton(new Button("Button"));

        BorderPane root = new BorderPane();
        root.setLeft(bar);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
