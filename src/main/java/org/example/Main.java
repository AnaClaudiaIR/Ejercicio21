package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Botón para mostrar texto");

        //Cuadrícula
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label texto = new Label("Introducir texto: ");
        grid.add(texto, 0, 0);

        TextField textoTexto = new TextField();
        grid.add(textoTexto, 1, 0);

        Button boton = new Button("Aceptar");
        grid.add(boton, 1, 1);

        boton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //Mensaje de confirmación
            alert.setTitle("Confirmar operación");
            alert.setHeaderText("¿Desea mostrar este texto?");
            alert.setContentText("Confirmar acción");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("Texto introducido --> "+textoTexto.getText()); //Mostrar el texto si se confirma la acción
                } else {
                    System.out.println("Operación cancelada.");
                }
            });

        });

        Scene scene = new Scene(grid, 270, 100);
        stage.setScene(scene);
        stage.show();

    }
}
