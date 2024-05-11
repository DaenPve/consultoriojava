package com.mycompany.consultorio.logica;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Paciente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_paciente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String edad;
    private String sexo;
    private String direccion;
    private String telefono;
    @OneToOne
    @JoinColumn(name="id_historial")
    private HistorialClinico id_historial;
    
    @OneToOne
    @JoinColumn(name = "id_cita")
    private CitaMedica id_cita;

    public Paciente() {
    }

    public Paciente(int id_paciente, String nombre, String primerApellido, String segundoApellido, String edad, String sexo, String direccion, String telefono, HistorialClinico id_historial, CitaMedica id_cita) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_historial = id_historial;
        this.id_cita = id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HistorialClinico getId_historial() {
        return id_historial;
    }

    public void setId_historial(HistorialClinico id_historial) {
        this.id_historial = id_historial;
    }

    public CitaMedica getId_cita() {
        return id_cita;
    }

    public void setId_cita(CitaMedica id_cita) {
        this.id_cita = id_cita;
    }

   
       
}
    