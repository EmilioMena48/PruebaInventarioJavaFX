package com.demoInventario.controller;

import com.demoInventario.model.Articulo;
import com.demoInventario.model.Proveedor;
import com.demoInventario.service.InventarioService;

import java.util.List;

public class ProveedorController {
    private final InventarioService inventarioService;

    public ProveedorController() {
        this.inventarioService = new InventarioService();
    }

    public void registrarProveedor(String nombreProveedor) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProveedor(nombreProveedor);
        inventarioService.registrarProveedor(proveedor);

    }

    public List<Proveedor> listarProveedores() {
        return inventarioService.mostrarProveedor();
    }

    public void registrarArticulo(String nombreArticulo) {
        Articulo articulo = new Articulo();
        articulo.setNombreArticulo(nombreArticulo);
        inventarioService.registrarArticulo(articulo);
    }

    public List<Articulo> listarArticulos() {
        return inventarioService.mostrarArticulo();
    }
}
