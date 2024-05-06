/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author patri
 */
public class PacienteJpaController {
    
    private EntityManagerFactory emf;

    public PacienteJpaController() {
        emf = Persistence.createEntityManagerFactory("persistence.xml");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void insertar(Paciente paciente) {
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

    public void actualizar(Paciente paciente) throws Exception {
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

    public void borrar(Long id) throws Exception {
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

    public Paciente encontrarPaciente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Paciente> encontrarPacientes() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT * FROM Paciente p", Paciente.class).getResultList();
        } finally {
            em.close();
        }
    }
}
