package ch3events;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NodeEventsApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 300, 300, Color.GRAY));
        stage.show();
    }

    private Parent createContent() {
        Rectangle box = new Rectangle(400, 400, Color.BLUE);
        Button login = new Button("Login");
        login.setTranslateX(10);
        login.setTranslateY(20);

        login.addEventHandler(UserEvent.LOGIN_SUCCEEDED, event -> {
            System.out.println("Custom event handler.");
        });

        login.setOnAction(e -> {
            System.out.println("Login clicked: " + e);
            login.fireEvent(new UserEvent(UserEvent.LOGIN_SUCCEEDED));
        });

        login.setOnMouseEntered(e -> {
            System.out.println("Ready for login: " + e);
        });

        Pane pane = new Pane(box);
        pane.getChildren().addAll(login);
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
