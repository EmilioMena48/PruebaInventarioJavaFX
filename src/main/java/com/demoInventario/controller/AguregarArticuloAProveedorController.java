package com.demoInventario.controller;
import com.demoInventario.model.Articulo;
import com.demoInventario.model.Proveedor;
import com.demoInventario.service.AgregarArticulosAProveedorService;

import java.util.List;

public class AguregarArticuloAProveedorController {
    private AgregarArticulosAProveedorService service = new AgregarArticulosAProveedorService();

    public List<Proveedor> obtenerProveedores(){
        return service.getProveedores();
    }

    public List<Articulo> obtenerArticulos(){
        return service.getArticulos();
    }

    public void agregarArticuloAProveedor(Long idProveedor, Long idArticulo, float precio){
        service.AddArticuloToProvider(idProveedor, idArticulo, precio);
    }
}
