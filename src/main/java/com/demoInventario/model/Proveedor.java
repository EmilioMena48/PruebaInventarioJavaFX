package com.demoInventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String nombreProveedor;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<ArticuloProveedor> articulos;

    @Override
    public String toString() {
        return nombreProveedor;
    }

}
