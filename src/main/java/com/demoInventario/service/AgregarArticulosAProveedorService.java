package com.demoInventario.service;

import com.demoInventario.model.Articulo;
import com.demoInventario.model.ArticuloProveedor;
import com.demoInventario.model.Proveedor;
import com.demoInventario.repository.ArticuloProveedorRepository;
import com.demoInventario.repository.ArticuloRepository;
import com.demoInventario.repository.ProveedorRepository;

import java.util.List;

public class AgregarArticulosAProveedorService {
    private final ProveedorRepository proveedorRepository = new ProveedorRepository();
    private final ArticuloRepository articuloRepository = new ArticuloRepository();
    private final ArticuloProveedorRepository articuloProveedorRepository = new ArticuloProveedorRepository();


    public List<Articulo> getArticulos() {
        return articuloRepository.buscarTodosArticulo();
    }

    public List<Proveedor> getProveedores() {
        return proveedorRepository.listarProveedor();
    }

    public void AddArticuloToProvider(Long idProveedor, Long idArticulo, float precio) {
        Proveedor proveedor = proveedorRepository.buscarProveedor(idProveedor);
        Articulo articulo = articuloRepository.buscarArticulo(idArticulo);

        ArticuloProveedor ap = new ArticuloProveedor();
        ap.setProveedor(proveedor);
        ap.setArticulo(articulo);
        ap.setPrecioArticuloProveedor(precio);

        articuloProveedorRepository.guardarArticuloProveedor(ap);
    }

}
