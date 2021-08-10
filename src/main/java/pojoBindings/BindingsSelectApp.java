package pojoBindings;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingsSelectApp extends Application {
    private final Track currentTrack = new Track(
            "Jaco Pastorious",
            "Jaco Pastorious",
            "Come On, Come Over",
            2,
            new Rating(4.99f, 5.00f),
            false
    );
    private final TextField tfArtist = new TextField();
    private final TextField tfAlbum = new TextField();
    private final TextField tfTrack = new TextField();
    private final TextField tfTrackNo = new TextField();
    private final TextField tfRating = new TextField();
    private final TextField tfDownloaded = new TextField();

    private final Button downloadButton = new Button("Download");

    private final BooleanProperty downloaded = new SimpleBooleanProperty(currentTrack, "downloaded");

    @Override
    public void start(Stage primaryStage) throws Exception {
        initBindings();
        GridPane gp = new GridPane();

        gp.add(new Label("Artist"), 0, 0);
        gp.add(tfArtist, 1, 0);
        gp.add(new Label("Album"), 0, 1);
        gp.add(tfAlbum, 1, 1);
        gp.add(new Label("Track"), 0, 2);
        gp.add(tfTrack, 1, 2);
        gp.add(new Label("#"), 0, 3);
        gp.add(tfTrackNo, 1, 3);
        gp.add(new Label("Rating"), 0, 4);
        gp.add(tfRating, 1, 4);
        gp.add(new Label("Downloaded"), 0, 5);
        gp.add(tfDownloaded, 1, 5);

        gp.setHgap(4.0d);
        gp.setVgap(8.0d);

        VBox.setVgrow(gp, Priority.ALWAYS);
        VBox.setMargin(gp, new Insets(40.0d));
        ButtonBar buttons = new ButtonBar();

        ButtonBar.setButtonData(downloadButton, ButtonBar.ButtonData.OTHER);

        buttons.getButtons().add(downloadButton);
        buttons.setPadding(new Insets(10.0d));

        downloadButton.setOnAction( (evt) -> {
            downloaded.set(true);
        });

        downloaded.addListener( (obs,ov,nv) -> currentTrack.setDownloaded(true));

        VBox vbox = new VBox(
                gp,
                new Separator(),
                buttons
        );
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();
    }
    private void initBindings() {
        tfArtist.textProperty().bind( Bindings.select(currentTrack, "artist"));
        tfAlbum.textProperty().bind( Bindings.select(currentTrack, "album"));
        tfTrack.textProperty().bind( Bindings.select(currentTrack, "track"));

        tfTrackNo.textProperty().bind(
                Bindings.select(currentTrack, "trackNo").asString()
        );

        tfRating.textProperty().bind(
                Bindings.concat(
                        Bindings.select(currentTrack, "rating", "value").asString(),
                        " out of ",
                        Bindings.select(currentTrack, "rating", "scale").asString()
                )
        );

        tfDownloaded.textProperty().bind(downloaded.asString());
        downloadButton.disableProperty().bind(downloaded);
    }
}
