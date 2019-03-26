package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_profesor{

private String profesor_rut;
private String profesor_nombre;

public String getProfesor_rut(){

	return  profesor_rut;
}

public void setProfesor_rut(){

	
}

public String getProfesor_nombre(){

	return  profesor_nombre;
}

public void setProfesor_nombre(){

	
}



}