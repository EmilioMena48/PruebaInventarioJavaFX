package com.demoInventario.service;

import com.demoInventario.model.Articulo;
import com.demoInventario.model.Proveedor;
import com.demoInventario.repository.ArticuloRepository;
import com.demoInventario.repository.IndirecciónJPA;
import com.demoInventario.repository.ProveedorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class InventarioService {
    private final ProveedorRepository proveedorRepository = new ProveedorRepository();
    private final ArticuloRepository articuloRepository = new ArticuloRepository();

    public void registrarProveedor(Proveedor proveedor) {
        proveedorRepository.guardarProveedor(proveedor);
    }

    public List<Proveedor> mostrarProveedor() {
        return proveedorRepository.listarProveedor();
    }

    public void registrarArticulo(Articulo articulo) {
        articuloRepository.guardarArticulo(articulo);
    }
    public List<Articulo> mostrarArticulo() {
        return articuloRepository.buscarTodosArticulo();
    }



}
