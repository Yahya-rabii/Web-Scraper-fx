package com.example.webscraperfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WebScraperGUI extends Application {
    private WebScraper webScraper = new WebScraper();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Web Scraper");

        Label urlLabel = new Label("URL:");
        TextField urlTextField = new TextField();

        Button scrapeButton = new Button("Scrape");
        scrapeButton.setOnAction(event -> {
            String url = urlTextField.getText();
            webScraper.scrapeWebsite(url);
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(urlLabel, 0, 0);
        gridPane.add(urlTextField, 1, 0);
        gridPane.add(scrapeButton, 1, 1, 1, 1);

        // Add CSS styling to change background color to black and text color to white
        gridPane.setStyle("-fx-text-fill: white;");
        scrapeButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");

        VBox vbox = new VBox(gridPane);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 80);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
