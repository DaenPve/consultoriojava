package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.HistorialClinico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class HistorialClinicoJpaController {

    private EntityManagerFactory emf;

    public HistorialClinicoJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(HistorialClinico h) {
        EntityManager em = null;
        int id_historial = 0;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(h);
            em.flush();
            id_historial = h.getId_historial();
            em.getTransaction().commit();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return id_historial;
    }

    public void update(HistorialClinico paciente) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(paciente);
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
            HistorialClinico historial = em.find(HistorialClinico.class, id);
            if (historial == null) {
                throw new Exception("Historial Clinico con id " + id + " no encontrado");
            }
            em.remove(historial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public HistorialClinico findHistorial(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistorialClinico.class, id);
        } finally {
            em.close();
        }
    }

    public List<HistorialClinico> findAllHistorial() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT * FROM HistorialClinico p", HistorialClinico.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public HistorialClinico findLastHistorialAdded() {
        EntityManager em = getEntityManager(); // Assuming you have a method to get the EntityManager

        try {
            TypedQuery<HistorialClinico> query = em.createQuery(
                "SELECT h FROM historialclinico h ORDER BY h.id_historial DESC", HistorialClinico.class);
            query.setMaxResults(1); // Limit to one result, the most recent one
            List<HistorialClinico> resultList = query.getResultList();
            
            // Check if resultList is not empty before returning
            return resultList.isEmpty() ? null : resultList.get(0);

        } finally {
            em.close();
        }
    }
}
