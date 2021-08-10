package ch6layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class PaneClippedApp extends Application {
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
    /**
     * Clips the children of the specified {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     *
     * @param region the {@link Region} whose children to clip
     * @param arc the {@link Rectangle#arcWidth} and {@link Rectangle#arcHeight}
     *            of the clipping {@link Rectangle}
     * @throws NullPointerException if {@code region} is {@code null}
     */
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

    static Region createClipped() {
        final Pane pane = new Pane(createShape());
        pane.setBorder(createBorder());
        pane.setPrefSize(100, 100);

        // clipped children still overwrite Border!
        clipChildren(pane, 3 * BORDER_RADIUS);

        return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createClipped());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
