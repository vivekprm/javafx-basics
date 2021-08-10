package fxanimation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Circle circle = new Circle(50, 150, 50, Color.RED);

        // change circle.translateXProperty from it's current value to 200
        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 200);

        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
        Timeline timeline = new Timeline(keyFrame);

        Scene scene = new Scene(new Pane(circle), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }
}
