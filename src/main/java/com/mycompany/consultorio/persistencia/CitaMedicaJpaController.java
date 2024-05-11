package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.CitaMedica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CitaMedicaJpaController {

    private EntityManagerFactory emf;

    public CitaMedicaJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(CitaMedica cita) {
        EntityManager em = null;
        int id_cita = 0;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cita);
            em.flush();
            id_cita = cita.getId_cita();
            em.getTransaction().commit();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return id_cita;
    }

    public void update(CitaMedica cita) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CitaMedica cita = em.find(CitaMedica.class, id);
            if (cita == null) {
                throw new Exception("Citamedica con id " + id + " no encontrado");
            }
            em.remove(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public CitaMedica findCita(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CitaMedica.class, id);
        } finally {
            em.close();
        }
    }

    public List<CitaMedica> findAllCitas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT * FROM citamedica ", CitaMedica.class).getResultList();
        } finally {
            em.close();
        }
    }
}
