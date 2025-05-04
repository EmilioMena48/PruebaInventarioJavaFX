package com.demoInventario.repository;

import com.demoInventario.model.Articulo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ArticuloRepository {

    public List<Articulo> buscarTodosArticulo(){
        EntityManager em = IndirecciónJPA.getEntityManager();
        try{
            return em.createQuery("select a from Articulo a", Articulo.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void guardarArticulo(Articulo articulo){
        EntityManager em = IndirecciónJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Articulo buscarArticulo(Long id){
        EntityManager em = IndirecciónJPA.getEntityManager();
        try{
            return em.find(Articulo.class, id);
        } finally {
            System.out.println("Articulo encontrado");
        }
    }
}
