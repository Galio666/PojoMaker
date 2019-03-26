package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_asignatura{

private int asignatura_codigo;
private String asignatura_nombre;

public int getAsignatura_codigo(){

	return  asignatura_codigo;
}

public void setAsignatura_codigo(){

	
}

public String getAsignatura_nombre(){

	return  asignatura_nombre;
}

public void setAsignatura_nombre(){

	
}



}