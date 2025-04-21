package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load the images from the resources folder
        ImageView imageView1 = new ImageView(new Image(getClass().getResource("/image/germany.gif").toExternalForm()));
        ImageView imageView2 = new ImageView(new Image(getClass().getResource("/image/china.gif").toExternalForm()));
        ImageView imageView3 = new ImageView(new Image(getClass().getResource("/image/france.gif").toExternalForm()));
        ImageView imageView4 = new ImageView(new Image(getClass().getResource("/image/us.gif").toExternalForm()));

        // Set fixed size (optional)
        imageView1.setFitWidth(150); imageView1.setFitHeight(100);
        imageView2.setFitWidth(150); imageView2.setFitHeight(100);
        imageView3.setFitWidth(150); imageView3.setFitHeight(100);
        imageView4.setFitWidth(150); imageView4.setFitHeight(100);

        // Create a GridPane and add the images
        GridPane pane = new GridPane();
        pane.add(imageView1, 0, 0);
        pane.add(imageView2, 1, 0);
        pane.add(imageView3, 0, 1);
        pane.add(imageView4, 1, 1);

        // Create and show the scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
