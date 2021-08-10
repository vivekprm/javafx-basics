package ch6layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class PaneDefaultApp extends Application {
    static final double BORDER_RADIUS = 4;

    static Border createBorder() {
        return new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                        new CornerRadii(BORDER_RADIUS), BorderStroke.THICK));
    }

    static Shape createShape() {
        final Ellipse shape = new Ellipse(50, 50);
        shape.setCenterX(80);
        shape.setCenterY(80);
        shape.setFill(Color.LIGHTCORAL);
        shape.setStroke(Color.LIGHTCORAL);
        return shape;
    }

    static Region createDefault() {
        final Pane pane = new Pane(createShape());
        pane.setBorder(createBorder());
        pane.setPrefSize(100, 100);
        return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createDefault());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
