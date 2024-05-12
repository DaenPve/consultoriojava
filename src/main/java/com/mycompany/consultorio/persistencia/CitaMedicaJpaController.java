package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.CitaMedica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    public List<CitaMedica> findAllCitasByDate(String fecha) {
        EntityManager em = getEntityManager();
        List<CitaMedica> listCitas = null;
        try {
            // Iniciar la transacción
            em.getTransaction().begin();

            // Utilizar parámetros en la consulta para evitar la inyección SQL
            TypedQuery<CitaMedica> query = em.createQuery(
                    "SELECT c FROM CitaMedica c WHERE c.fecha = :fecha", CitaMedica.class);
            query.setParameter("fecha", fecha);

            // Obtener el resultado de la consulta
            listCitas = query.getResultList();

            // No se necesita un commit para operaciones de solo lectura
        } catch (Exception e) {
            // Manejar cualquier excepción
            e.printStackTrace(); // o registra la excepción en un log

        } finally {
            // Cerrar el EntityManager
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return listCitas;
    }

    public CitaMedica findCitaByFecha(String fecha, String hora) {
        EntityManager em = getEntityManager();
        CitaMedica cita = null;
        try {
            em.getTransaction().begin();

            TypedQuery<CitaMedica> query = em.createQuery(
                    "SELECT c FROM CitaMedica c WHERE c.fecha = :fecha AND c.hora = :hora", CitaMedica.class);
            query.setParameter("fecha", fecha);
            query.setParameter("hora", hora);

            cita = query.getSingleResult();

        } catch (Exception e) {
            
            //e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return cita;
    }
}
