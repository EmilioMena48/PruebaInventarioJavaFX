package com.demoInventario.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import com.demoInventario.model.Articulo;
import com.demoInventario.model.Proveedor;
import com.demoInventario.controller.ProveedorController;

import java.util.List;

public class ProveedorPanelJavaFX extends VBox {

    private final ProveedorController proveedorController = new ProveedorController();

    // Controles
    private final TextField nombreProveedorField = new TextField();
    private final Button registrarProveedorBtn = new Button("Registrar Proveedor");
    private final TextArea listadoProveedoresArea = new TextArea();

    private final TextField nombreArticuloField = new TextField();
    private final Button registrarArticuloBtn = new Button("Registrar Artículo");
    private final TextArea listadoArticulosArea = new TextArea();

    public ProveedorPanelJavaFX() {
        setSpacing(20);
        setPadding(new Insets(20));

        // Aplicar estilos
        nombreProveedorField.getStyleClass().add("text-field");
        registrarProveedorBtn.getStyleClass().add("boton");
        listadoProveedoresArea.getStyleClass().add("text-area");

        nombreArticuloField.getStyleClass().add("text-field");
        registrarArticuloBtn.getStyleClass().add("boton");
        listadoArticulosArea.getStyleClass().add("text-area");

        // Panel de Proveedores
        VBox proveedorBox = new VBox(10);
        proveedorBox.setPadding(new Insets(10));
        proveedorBox.setStyle("-fx-border-color: #bdc3c7; -fx-border-width: 1; -fx-border-radius: 5;");

        Label proveedorLabel = new Label("Proveedores");
        proveedorLabel.getStyleClass().add("titulo");

        HBox formProveedor = new HBox(10, new Label("Nombre del Proveedor:"), nombreProveedorField, registrarProveedorBtn);
        formProveedor.setAlignment(Pos.CENTER_LEFT);

        registrarProveedorBtn.setOnAction(e -> {
            String nombre = nombreProveedorField.getText().trim();
            if (!nombre.isEmpty()) {
                proveedorController.registrarProveedor(nombre);
                nombreProveedorField.clear();
                actualizarListadoProveedores();
            } else {
                mostrarAlerta("Ingrese un nombre válido.");
            }
        });

        listadoProveedoresArea.setEditable(false);
        proveedorBox.getChildren().addAll(proveedorLabel, formProveedor, listadoProveedoresArea);

        // Panel de Artículos
        VBox articuloBox = new VBox(10);
        articuloBox.setPadding(new Insets(10));
        articuloBox.setStyle("-fx-border-color: #bdc3c7; -fx-border-width: 1; -fx-border-radius: 5;");

        Label articuloLabel = new Label("Artículos");
        articuloLabel.getStyleClass().add("titulo");

        HBox formArticulo = new HBox(10, new Label("Nombre del Artículo:"), nombreArticuloField, registrarArticuloBtn);
        formArticulo.setAlignment(Pos.CENTER_LEFT);

        registrarArticuloBtn.setOnAction(e -> {
            String nombre = nombreArticuloField.getText().trim();
            if (!nombre.isEmpty()) {
                proveedorController.registrarArticulo(nombre);
                nombreArticuloField.clear();
                actualizarListadoArticulos();
            } else {
                mostrarAlerta("Ingrese un nombre válido.");
            }
        });

        listadoArticulosArea.setEditable(false);
        articuloBox.getChildren().addAll(articuloLabel, formArticulo, listadoArticulosArea);

        // Agregar secciones al contenedor principal
        getChildren().addAll(proveedorBox, articuloBox);

        actualizarListadoProveedores();
        actualizarListadoArticulos();
    }

    private void actualizarListadoProveedores() {
        List<Proveedor> proveedores = proveedorController.listarProveedores();
        StringBuilder builder = new StringBuilder();
        for (Proveedor p : proveedores) {
            builder.append("ID: ").append(p.getIdProveedor())
                    .append(" - Nombre: ").append(p.getNombreProveedor()).append("\n");
        }
        listadoProveedoresArea.setText(builder.toString());
    }

    private void actualizarListadoArticulos() {
        List<Articulo> articulos = proveedorController.listarArticulos();
        StringBuilder builder = new StringBuilder();
        for (Articulo a : articulos) {
            builder.append("ID: ").append(a.getIdArticulo())
                    .append(" - Nombre: ").append(a.getNombreArticulo()).append("\n");
        }
        listadoArticulosArea.setText(builder.toString());
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
