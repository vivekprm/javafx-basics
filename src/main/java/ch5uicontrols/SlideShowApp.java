package ch5uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SlideShowApp extends Application {
//    private Image[] imageURLs = {
//            new Image("https://www.bekwam.net/images/bekwam_rc_charging.png"),
//            new Image("https://www.bekwam.net/images/bekwam_rc_discharging.png"),
//            new Image("https://www.bekwam.net/images/bekwam_rl_scope.png")
//    };
    private Image[] imageURLs = {
            new Image("anav.jpeg"),
            new Image("anav2.jpeg"),
            new Image("anav3.jpeg")
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pagination pagination = new Pagination(imageURLs.length, 0);
        pagination.setPageFactory(
                pageIndex -> {
                    ImageView iv = new ImageView(imageURLs[pageIndex]);
                    iv.setFitHeight(480);
                    iv.setFitWidth(800);
                    iv.setPreserveRatio(true);
                    return iv;
                }
        );

        VBox vbox = new VBox( pagination );

        Scene scene = new Scene(vbox);

        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
