package com.mycompany.consultorio.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CitaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_cita;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
   
    private String fecha;
    
    private String hora;
    private String servicio;

    public CitaMedica() {
    }

    public CitaMedica(int id_cita, String nombre, String primerapellido, String segundoapellido, String fecha, String hora, String servicio) {
        this.id_cita = id_cita;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }

    public int getId_paciente() {
        return id_cita;
    }

    public void setId_paciente(int id_paciente) {
        this.id_cita = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
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
   
}
