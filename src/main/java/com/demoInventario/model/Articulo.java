package com.demoInventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;

    private String nombreArticulo;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    private List<ArticuloProveedor> proveedores;

    @Override
    public String toString() {
        return nombreArticulo;
    }
}
