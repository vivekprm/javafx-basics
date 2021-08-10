package fxdialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogApp extends Application {

    private final TextField dbURL = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("DB URL");
        dbURL.setPrefWidth(400.0d);
        Button btn = new Button("Set");
        btn.setOnAction(this::showSetDialog);

        VBox vbox = new VBox(label, dbURL, btn);
        vbox.setSpacing(10.0d);
        vbox.setPadding(new Insets(40.0d));

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Dialog App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private final ConnectionInfoStringConverter ciConverter =
            new ConnectionInfoStringConverter();

    private void showSetDialog(ActionEvent evt) {
        ConnectionInfo fromURL = ciConverter.fromString( dbURL.getText() );

        ConnectionDialog dialog = new ConnectionDialog(fromURL);

        Optional<ConnectionInfo> ci = dialog.showAndWait();

        ci.ifPresent( c -> dbURL.setText(
                        ciConverter.toString(c)
                )
        );
    }
}
