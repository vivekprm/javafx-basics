package nonNull;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NoNullComboApp extends Application {

    private final ComboBox<String> country = new ComboBox<>();
    private final ComboBox<String> city = new ComboBox<>();

    private List<String> countries = new ArrayList<>();

    private Map<String, List<String>> citiesMap = new LinkedHashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label countryLabel = new Label("Country:");
        country.setPrefWidth(200.0d);
        Label cityLabel = new Label("City:");
        city.setPrefWidth(200.0d);
        Button saveButton = new Button("Save");

        VBox vbox = new VBox(
                countryLabel,
                country,
                cityLabel,
                city,
                saveButton
        );
        vbox.setAlignment(Pos.CENTER_LEFT );
        vbox.setSpacing( 10.0d );

        TilePane outerBox = new TilePane(vbox);
        outerBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(outerBox);

        initData();

        country.getItems().add("");
        country.getItems().addAll( countries );
        country.setValue( "" );  // empty selection is object and not null

        city.getItems().add("");
        city.setValue( "" );

        country.setOnAction( (evt) -> {
            String cty = country.getValue();

            city.getItems().removeIf( (c) -> !c.isEmpty() );

            if( citiesMap.containsKey(cty) ) {  // not an empty key
                city.getItems().addAll( citiesMap.get(cty) );
            }
        });

        saveButton.setOnAction( (evt) -> {
            System.out.println("saving country='" + country.getValue() +
                    "', city='" + city.getValue() + "'");
        });

        primaryStage.setTitle("NoNullComboApp");
        primaryStage.setScene( scene );
        primaryStage.setWidth( 320 );
        primaryStage.setHeight( 480 );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initData() {

        String COUNTRY_FR = "France";
        String COUNTRY_DE = "Germany";
        String COUNTRY_CH = "Switzerland";

        countries.add(COUNTRY_FR); countries.add(COUNTRY_DE); countries.add(COUNTRY_CH);

        List<String> frenchCities = new ArrayList<>();
        frenchCities.add("Paris");
        frenchCities.add("Strasbourg");

        List<String> germanCities = new ArrayList<>();
        germanCities.add("Berlin");
        germanCities.add("Cologne");
        germanCities.add("Munich");

        List<String> swissCities = new ArrayList<>();
        swissCities.add("Zurich");

        citiesMap.put(COUNTRY_FR, frenchCities );
        citiesMap.put(COUNTRY_DE, germanCities );
        citiesMap.put(COUNTRY_CH, swissCities );
    }
}
