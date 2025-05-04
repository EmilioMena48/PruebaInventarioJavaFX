package com.demoInventario.ui;

import com.demoInventario.model.Articulo;
import com.demoInventario.model.Proveedor;
import com.demoInventario.controller.AguregarArticuloAProveedorController;
import javax.swing.*;
import java.awt.*;

public class ArticuloProveedorPanel extends JPanel {
    private JComboBox<Proveedor> proveedorCombo;
    private JComboBox<Articulo> articuloCombo;
    private JTextField precioField;
    private JButton agregarBtn;
    private AguregarArticuloAProveedorController controller;

    public ArticuloProveedorPanel() {
        controller = new AguregarArticuloAProveedorController();
        setLayout(new GridLayout(5, 1));

        proveedorCombo = new JComboBox<>();
        for (Proveedor p : controller.obtenerProveedores()) {
            proveedorCombo.addItem(p);
        }

        articuloCombo = new JComboBox<>();
        for (Articulo a : controller.obtenerArticulos()) {
            articuloCombo.addItem(a);
        }

        precioField = new JTextField();
        agregarBtn = new JButton("Agregar Artículo al Proveedor");

        agregarBtn.addActionListener(e -> {
            Proveedor proveedor = (Proveedor) proveedorCombo.getSelectedItem();
            Articulo articulo = (Articulo) articuloCombo.getSelectedItem();
            float precio = Float.parseFloat(precioField.getText());

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Confirmas agregar el artículo con precio: " + precio + "?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                controller.agregarArticuloAProveedor(proveedor.getIdProveedor(), articulo.getIdArticulo(), precio);
                JOptionPane.showMessageDialog(this, "Artículo agregado correctamente.");
            }
        });

        add(new JLabel("Proveedor:"));
        add(proveedorCombo);
        add(new JLabel("Artículo:"));
        add(articuloCombo);
        add(new JLabel("Precio:"));
        add(precioField);
        add(agregarBtn);
    }
}
