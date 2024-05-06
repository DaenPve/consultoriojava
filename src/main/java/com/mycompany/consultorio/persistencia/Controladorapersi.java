package com.mycompany.consultorio.persistencia;

import com.mycompany.consultorio.logica.Paciente;

public class Controladorapersi {
    
    PacienteJpaController pacienteJPA = new PacienteJpaController();
    
    public void crearPaciente(Paciente paciente){
        try{
            pacienteJPA.create(paciente);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
