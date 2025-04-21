package com.example.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_17 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI elements
        Text text = new Text("Show Colors");
        text.setFont(Font.font("Arial", 32));

        ScrollBar redBar = new ScrollBar();
        ScrollBar greenBar = new ScrollBar();
        ScrollBar blueBar = new ScrollBar();
        ScrollBar opacityBar = new ScrollBar();

        // Set max for each scrollbar
        redBar.setMax(255);
        greenBar.setMax(255);
        blueBar.setMax(255);
        opacityBar.setMax(1);
        opacityBar.setMin(0);
        opacityBar.setBlockIncrement(0.01);

        // Set initial values
        redBar.setValue(0);
        greenBar.setValue(0);
        blueBar.setValue(0);
        opacityBar.setValue(1);

        // Event handler to update text color
        ChangeListener<Number> listener = (ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
            Color color = Color.rgb(
                (int) redBar.getValue(),
                (int) greenBar.getValue(),
                (int) blueBar.getValue(),
                opacityBar.getValue()
            );
            text.setFill(color);
        };

        redBar.valueProperty().addListener(listener);
        greenBar.valueProperty().addListener(listener);
        blueBar.valueProperty().addListener(listener);
        opacityBar.valueProperty().addListener(listener);

        // Layout with GridPane
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(text, 0, 0, 2, 1);
        pane.add(new Label("Red"), 0, 1);
        pane.add(redBar, 1, 1);
        pane.add(new Label("Green"), 0, 2);
        pane.add(greenBar, 1, 2);
        pane.add(new Label("Blue"), 0, 3);
        pane.add(blueBar, 1, 3);
        pane.add(new Label("Opacity"), 0, 4);
        pane.add(opacityBar, 1, 4);

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
