package modelChangeMVVM;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModelChangeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(new URLTestView());

        primaryStage.setTitle("Model Change App");
        primaryStage.setScene( scene );
        primaryStage.setWidth(568);
        primaryStage.setHeight(320);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
