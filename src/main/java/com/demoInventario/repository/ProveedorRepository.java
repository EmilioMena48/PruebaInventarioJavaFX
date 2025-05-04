package com.demoInventario.repository;

import com.demoInventario.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProveedorRepository {

    public void guardarProveedor(Proveedor proveedor) {
        EntityManager em = IndirecciónJPA.getEntityManager();
        try {em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Proveedor> listarProveedor() {
        EntityManager em = IndirecciónJPA.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Proveedor buscarProveedor(Long id) {
        EntityManager em = IndirecciónJPA.getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            System.out.println("Proveedor encontrado");
        }
    }
}
