package ch6layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnConstraintGridPaneApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();

        GridPane gp = new GridPane();
        gp.setPadding( new Insets(10) );
        gp.setHgap( 4 );
        gp.setVgap( 10 );

        VBox.setVgrow(gp, Priority.ALWAYS );
        Label lblTitle = new Label("Support Ticket");

        Label lblEmail = new Label("Email");
        TextField tfEmail = new TextField();

        Label lblContract = new Label("Contract");
        TextField tfContract = new TextField();

        Label lblPriority = new Label("Priority");
        RadioButton rbMedium = new RadioButton("Medium");
        RadioButton rbHigh = new RadioButton("High");
        RadioButton rbLow = new RadioButton("Low");
        VBox priorityVBox = new VBox();
        priorityVBox.setSpacing( 2 );
        GridPane.setVgrow(priorityVBox, Priority.SOMETIMES);
        priorityVBox.getChildren().addAll( lblPriority, rbMedium, rbHigh, rbLow );

        Label lblSeverity = new Label("Severity");
        ObservableList<String> severities =
                FXCollections.observableArrayList("Blocker", "Workaround", "N/A");
        ComboBox<String> cbSeverity = new ComboBox<>(severities);

        Label lblCategory = new Label("Category");
        ObservableList<String> categories =
                FXCollections.observableArrayList("Bug", "Feature");
        ComboBox<String> cbCategory = new ComboBox<>(categories);

        Label lblProblem = new Label("Problem");
        TextField tfProblem = new TextField();

        Label lblDescription = new Label("Description");
        TextArea taDescription = new TextArea();

        gp.add( lblTitle,       0, 0);

        gp.add( lblEmail,       0, 1);
        gp.add(tfEmail,         0, 2);

        gp.add( lblContract,    0, 3 );
        gp.add( tfContract,     0, 4 );

        gp.add( priorityVBox,   0, 5);

        gp.add( lblSeverity,    1, 5);
        gp.add( cbSeverity,     1, 6);
        gp.add( lblCategory,    1, 7);
        gp.add( cbCategory,     1, 8);

        gp.add( lblProblem,     0, 9);
        gp.add( tfProblem,      0, 10);

        gp.add( lblDescription, 0, 11);
        gp.add( taDescription,  0, 12);

        GridPane.setColumnSpan( tfEmail, 2 );
        GridPane.setColumnSpan( tfContract, 2 );
        GridPane.setColumnSpan( tfProblem, 2 );
        GridPane.setColumnSpan( taDescription, 2 );
        GridPane.setRowSpan( priorityVBox, 4 );

        Scene scene = new Scene(gp);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
