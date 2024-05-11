package com.mycompany.consultorio.logica;

import com.mycompany.consultorio.logica.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-11T01:56:51", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(CitaMedica.class)
public class CitaMedica_ { 

    public static volatile SingularAttribute<CitaMedica, String> fecha;
    public static volatile SingularAttribute<CitaMedica, String> servicio;
    public static volatile SingularAttribute<CitaMedica, String> hora;
    public static volatile SingularAttribute<CitaMedica, Paciente> paciente;
    public static volatile SingularAttribute<CitaMedica, Integer> id_cita;

}