package ch5uicontrols;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageApp extends Application {
    private final static String IMAGE_LOC = "anav.jpeg";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image2 = new Image(IMAGE_LOC, 360.0d, 360.0d, true, true );
        Image image3 = new Image(IMAGE_LOC, 360.0d, 360.0d, false, true);
        Image image4 = new Image(IMAGE_LOC);

        ImageView iv1 = new ImageView(IMAGE_LOC);

        ImageView iv2 = new ImageView(image2);
        ImageView iv3 = new ImageView(image3);
        ImageView iv4 = new ImageView(image4);

        iv4.setPreserveRatio(true);
        iv4.setFitHeight(360);
        iv4.setFitWidth(360);
        Rectangle2D viewportRect = new Rectangle2D(20, 50, 100, 100);
        iv4.setViewport(viewportRect);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(iv1);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
