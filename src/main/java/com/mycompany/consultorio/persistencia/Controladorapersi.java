package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.CitaMedica;
import com.mycompany.consultorio.logica.HistorialClinico;
import com.mycompany.consultorio.logica.Paciente;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class Controladorapersi {

    private PacienteJpaController pacienteJPA = new PacienteJpaController();
    private HistorialClinicoJpaController historialJPA = new HistorialClinicoJpaController();
    private CitaMedicaJpaController citamedicaJPA = new CitaMedicaJpaController();

    public void crearPaciente(Paciente paciente) {
        try {
            pacienteJPA.create(paciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int crearHistorial(HistorialClinico historial) {

        int id_historial = 0;

        try {
            id_historial = historialJPA.create(historial);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id_historial;
    }
    
    
    public int crearCitaMedica(CitaMedica cita){
        int id_cita = 0;
        
        try{
            id_cita = citamedicaJPA.create(cita);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id_cita;
    }

    public Paciente buscarPaciente(int id_paciente) {

        Paciente paciente = null;

        try {
            paciente = pacienteJPA.findPaciente(id_paciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return paciente;
    }

    public HistorialClinico obtenerHistorial(int id_historial) {

        HistorialClinico historial = null;

        try {
            historial = historialJPA.findHistorial(id_historial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return historial;
    }

    public CitaMedica obtenerCitaMedica(int id_paciente) {
        Paciente paciente = null;
        CitaMedica cita = null;

        try {
            paciente = pacienteJPA.findPaciente(id_paciente);
            cita = citamedicaJPA.findCita(paciente.getId_paciente());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cita;
    }

    public void actualizarPaciente(Paciente paciente) {
        try {
            pacienteJPA.update(paciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarHistorial(HistorialClinico h) {
        try {
            historialJPA.update(h);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarCitaMedica(CitaMedica c){
        try{
            citamedicaJPA.update(c);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarCitaMedica(Paciente p, CitaMedica c){
        p.setId_cita(null);
        try{
            pacienteJPA.update(p);
            citamedicaJPA.delete(c.getId_cita());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void msjExito(JRootPane rootPane, String msj) {
        JOptionPane.showMessageDialog(rootPane, msj);
    }

    public void msjAlerta(JRootPane rootPane, String msj) {
        JOptionPane.showMessageDialog(rootPane, msj, "Atencion!", JOptionPane.WARNING_MESSAGE);

    }

}
