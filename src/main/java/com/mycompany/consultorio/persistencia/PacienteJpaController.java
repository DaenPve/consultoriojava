package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.Paciente;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PacienteJpaController {
    
    private EntityManagerFactory emf;

    public PacienteJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Paciente paciente) throws Exception {
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
            Paciente paciente = em.find(Paciente.class, id);
            if (paciente == null) {
                throw new Exception("Paciente con id " + id + " no encontrado");
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Paciente findPaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Paciente> findAllPacientes() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT * FROM Paciente p", Paciente.class).getResultList();
        } finally {
            em.close();
        }
    }
}

