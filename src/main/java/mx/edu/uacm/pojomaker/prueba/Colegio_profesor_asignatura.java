package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_profesor_asignatura{

private String rut_profesor;
private int codigo_asignatura;

public String getRut_profesor(){

	return  rut_profesor;
}

public void setRut_profesor(){

	
}

public int getCodigo_asignatura(){

	return  codigo_asignatura;
}

public void setCodigo_asignatura(){

	
}



}