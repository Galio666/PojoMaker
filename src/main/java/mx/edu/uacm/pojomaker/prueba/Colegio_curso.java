package mx.edu.uacm.pojomaker.prueba;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Colegio_curso{

private int curso_codigo;
private String curso_nivel;

public int getCurso_codigo(){

	return  curso_codigo;
}

public void setCurso_codigo(){

	
}

public String getCurso_nivel(){

	return  curso_nivel;
}

public void setCurso_nivel(){

	
}



}