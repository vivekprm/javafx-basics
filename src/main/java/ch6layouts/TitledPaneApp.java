package ch6layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox(
                new Label("Keywords" ),
                new TextField()
        );

        vbox.setPadding( new Insets(10) );
        vbox.setSpacing( 10 );

        VBox advancedVBox = new VBox(
                new Label("All Keywords"),
                new CheckBox(),
                new Label("Domains"),
                new TextField(),
                new Label("Time"),
                new ComboBox<>(
                        FXCollections.observableArrayList( "Day", "Month", "Year" )
                )
        );

        TitledPane titledPane = new TitledPane(
                "Advanced",
                advancedVBox
        );
        titledPane.setExpanded( false );

        vbox.getChildren().addAll(
                titledPane,
                new Button("Search")
        );

        Scene scene = new Scene( vbox );

        primaryStage.setTitle( "TitledPaneApp" );
        primaryStage.setScene( scene );
        primaryStage.setWidth( 568 );
        primaryStage.setHeight( 320 );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

