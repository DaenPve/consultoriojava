package com.mycompany.consultorio.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistorialClinico implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_historial;
    private String peso;
    private String estatura;
    private String anpepa;
    private String explora;
    private String motivoconsulta;
    private String anheac;
    private String padecimmiento;
    private String tratamiento;

    public HistorialClinico() {
    }

    public HistorialClinico(int id_historial, String peso, String estatura, String anpepa, String explora, String motivoconsulta, String anheac, String padecimmiento, String tratamiento) {
        this.id_historial = id_historial;
        this.peso = peso;
        this.estatura = estatura;
        this.anpepa = anpepa;
        this.explora = explora;
        this.motivoconsulta = motivoconsulta;
        this.anheac = anheac;
        this.padecimmiento = padecimmiento;
        this.tratamiento = tratamiento;
    }

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstartura(String estatura) {
        this.estatura = estatura;
    }

    public String getAnpepa() {
        return anpepa;
    }

    public void setAnpepa(String anpepa) {
        this.anpepa = anpepa;
    }

    public String getExplora() {
        return explora;
    }

    public void setExplora(String explora) {
        this.explora = explora;
    }

    public String getMotivoconsulta() {
        return motivoconsulta;
    }

    public void setMotivoconsulta(String motivoconsulta) {
        this.motivoconsulta = motivoconsulta;
    }

    public String getAnheac() {
        return anheac;
    }

    public void setAnheac(String anheac) {
        this.anheac = anheac;
    }

    public String getPadecimmiento() {
        return padecimmiento;
    }

    public void setPadecimmiento(String padecimmiento) {
        this.padecimmiento = padecimmiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

   
    }

    