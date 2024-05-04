package com.mycompany.consultorio.logica;

import com.mycompany.consultorio.logica.HistorialClinico;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-03T19:49:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, HistorialClinico> unHistorialClinico;
    public static volatile SingularAttribute<Paciente, String> primerApellido;
    public static volatile SingularAttribute<Paciente, String> direccion;
    public static volatile SingularAttribute<Paciente, String> segundoApellido;
    public static volatile SingularAttribute<Paciente, Integer> id_paciente;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> telefono;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, String> edad;

}