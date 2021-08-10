package ch6layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class PaneNestedApp extends Application {
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
    static void clipChildren(Region region, double arc) {

        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(arc);
        outputClip.setArcHeight(arc);
        region.setClip(outputClip);

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }
    static Region createNested() {
        // create drawing Pane without Border or size
        final Pane pane = new Pane(createShape());
        clipChildren(pane, BORDER_RADIUS);

        // create sized enclosing Region with Border
        final Region container = new StackPane(pane);
        container.setBorder(createBorder());
        container.setPrefSize(100, 100);
        return container;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createNested());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
