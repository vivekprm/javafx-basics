package mvvm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVVMApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new EmploymentRequestView()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
