package com.demoInventario.app;

import com.demoInventario.ui.ProveedorPanelJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProveedorPanelJavaFX root = new ProveedorPanelJavaFX();
        Scene scene = new Scene(root, 650, 500);
        scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        primaryStage.setTitle("Gestión de Proveedores");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
