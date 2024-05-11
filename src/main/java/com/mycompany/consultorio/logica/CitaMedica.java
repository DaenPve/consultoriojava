package com.mycompany.consultorio.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CitaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_cita;
    private String fecha;
    private String hora;
    private String servicio;
    
    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;


    public CitaMedica() {
    }

    public CitaMedica(int id_cita, String fecha, String hora, String servicio, Paciente paciente) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.paciente = paciente;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    
    
}
