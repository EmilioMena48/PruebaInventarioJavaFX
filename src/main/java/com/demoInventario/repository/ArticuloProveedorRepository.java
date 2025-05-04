package com.demoInventario.repository;

import com.demoInventario.model.ArticuloProveedor;
import jakarta.persistence.EntityManager;

public class ArticuloProveedorRepository {

    public void guardarArticuloProveedor(ArticuloProveedor art) {
        EntityManager em = IndirecciónJPA.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(art);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
