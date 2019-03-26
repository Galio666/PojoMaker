package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_alumno_asignatura{

private String rut_alumno;
private int codigo_asignatura;

public String getRut_alumno(){

	return  rut_alumno;
}

public void setRut_alumno(){

	
}

public int getCodigo_asignatura(){

	return  codigo_asignatura;
}

public void setCodigo_asignatura(){

	
}



}