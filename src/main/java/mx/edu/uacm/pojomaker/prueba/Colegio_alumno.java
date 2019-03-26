package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_alumno{

private String alumno_rut;
private String alumno_nombre;
private int alumno_edad;
private int codigo_curso;

public String getAlumno_rut(){

	return  alumno_rut;
}

public void setAlumno_rut(){

	
}

public String getAlumno_nombre(){

	return  alumno_nombre;
}

public void setAlumno_nombre(){

	
}

public int getAlumno_edad(){

	return  alumno_edad;
}

public void setAlumno_edad(){

	
}

public int getCodigo_curso(){

	return  codigo_curso;
}

public void setCodigo_curso(){

	
}



}