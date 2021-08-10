package ch5uicontrols;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class UiControlsJavaFXApp extends Application {
    private final ChoiceBox<Pair<String,String>> assetClass = new ChoiceBox<>();
    private final static Pair<String, String> EMPTY_PAIR_CHOICE = new Pair<>("", "");

    private final ComboBox<Pair<String, String>> account = new ComboBox<>();
    private final static Pair<String, String> EMPTY_PAIR_COMBO = new Pair<>("", "");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Asset Class:");
        assetClass.setPrefWidth(200);
        Button saveButton = new Button("Save");

        HBox assetHbox = new HBox(
                label,
                assetClass,
                saveButton);
        assetHbox.setSpacing( 10.0d );
        assetHbox.setAlignment(Pos.CENTER );
        assetHbox.setPadding( new Insets(40) );

        Label accountsLabel = new Label("Account:");
        account.setPrefWidth(200);

        HBox accountHbox = new HBox(
                accountsLabel,
                account,
                saveButton);
        accountHbox.setSpacing( 10.0d );
        accountHbox.setAlignment(Pos.CENTER );
        accountHbox.setPadding( new Insets(40) );

        GridPane gp = new GridPane();
        gp.add( label, 0, 0 );
        gp.add( assetHbox, 1, 0 );
        gp.add( accountsLabel, 0, 1 );
        gp.add( accountHbox, 1, 1 );
        gp.setHgap(10);
        gp.setVgap(10);

        HBox hbox = new HBox(gp);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(hbox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);

        initChoice();
        initCombo();

        saveButton.setOnAction(
                (evt) -> {
                    System.out.println("saving " + assetClass.getValue());
                    if( account.getValue().equals(EMPTY_PAIR_COMBO) ) {
                        System.out.println("no save needed; no item selected");
                    } else {
                        System.out.println("saving " + account.getValue());
                    }
                }
        );

        primaryStage.setTitle("ChoicesApp");
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    private void initCombo() {
        List<Pair<String,String>> accounts = new ArrayList<>();

        accounts.add( new Pair<>("Auto Expense", "60000") );
        accounts.add( new Pair<>("Interest Expense", "61000") );
        accounts.add( new Pair<>("Office Expense", "62000") );
        accounts.add( new Pair<>("Salaries Expense", "63000") );

        account.getItems().add( EMPTY_PAIR_COMBO );
        account.getItems().addAll( accounts );
        account.setValue( EMPTY_PAIR_COMBO );

        Callback<ListView<Pair<String,String>>, ListCell<Pair<String,String>>> factory =
            (lv) ->
                new ListCell<>() {
                    @Override
                        protected void updateItem(Pair<String, String> item, boolean empty) {
                            super.updateItem(item, empty);
                            if( empty ) {
                                setText("");
                            } else {
                                setText( item.getKey() );
                            }
                        }
                    };

        account.setCellFactory( factory );
        account.setButtonCell( factory.call( null ) );
    }

    private void initChoice() {
        List<Pair<String,String>> assetClasses = new ArrayList<>();
        assetClasses.add( new Pair("Equipment", "20000"));
        assetClasses.add( new Pair("Furniture", "21000"));
        assetClasses.add( new Pair("Investment", "22000"));

        assetClass.setConverter( new StringConverter<>() {
            @Override
            public String toString(Pair<String, String> pair) {
                return pair.getKey();
            }

            @Override
            public Pair<String, String> fromString(String string) {
                return null;
            }
        });

        assetClass.getItems().add( EMPTY_PAIR_CHOICE );
        assetClass.getItems().addAll( assetClasses );
        assetClass.setValue( EMPTY_PAIR_CHOICE );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
