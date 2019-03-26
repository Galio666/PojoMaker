package mx.edu.uacm.pojomaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElPojoMakerTresPunto1416ApplicationTests {

	private static final Logger log = LogManager.getLogger(ElPojoMakerTresPunto1416ApplicationTests.class);

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() throws SQLException, IOException {
		String ruta ="src/main/java/mx/edu/uacm/pojomaker/";
		String nomCarpeta="prueba";
		BufferedWriter bfw;
		crearCarpeta(nomCarpeta, ruta);

		DatabaseMetaData md = dataSource.getConnection().getMetaData();// Conection to get MetaData from DB

		String prueba = dataSource.getConnection().getCatalog();

		log.debug("Esto me trajo el 3.1416" + prueba);
		
		
		ResultSet rs = md.getTables("mapeo", null, "%", null);// Obtenemos todas las tablas
		
		while (rs.next()) {
			String nomTabla=rs.getString(3);
			nomTabla=nomTabla.substring(0,1).toUpperCase() + nomTabla.substring(1);
			
			
			
			
			File archivoRetorn=crearArchivo(nomTabla,nomCarpeta,ruta);
			bfw= new BufferedWriter(new FileWriter(archivoRetorn));
			log.debug("Estas son las tablas----->" + rs.getString(3));// 3 tablas 4 Atributos 6 tipoDato
			ResultSet rs1 = md.getColumns("mapeo", null, rs.getString(3), null);
			
			bfw.write("package mx.edu.uacm.pojomaker."+nomCarpeta+";\n");
			
			bfw.write("import javax.persistence.Entity;\n");
			bfw.write("import javax.persistence.GeneratedValue;\n");
			bfw.write("import javax.persistence.GenerationType;\n");
			bfw.write("import javax.persistence.Id;\n");
			
			bfw.write("@Entity\n");
			bfw.write("public class "+nomTabla+"{\n\n");
			while (rs1.next()) {
				
				
				log.debug("Estas son las columnas de las tablas------>" + rs1.getString(4) + "  Tipo de dato es-->"
						+ rs1.getString(6));
			bfw.write("private "+ cambiarTipoDato(rs1.getString(6))+ " "+ rs1.getString(4)+";\n");
					           
			}
			ResultSet rs2 = md.getColumns("mapeo", null, rs.getString(3), null);
			while(rs2.next()) {
				String nomAtrib=rs2.getString(4);
				nomAtrib=nomAtrib.substring(0,1).toUpperCase() + nomAtrib.substring(1);
				bfw.write("\npublic"+" "+cambiarTipoDato(rs2.getString(6))+" "+"get"+ nomAtrib+"()"+"{\n\n"+"\t"+"return "+" "+rs2.getString(4)+";"+"\n}\n");
				bfw.write("\npublic"+" void "+"set"+ nomAtrib+"()"+"{\n\n"+"\t"+"\n}\n");
			}
			
			bfw.write("\n\n\n}");
			bfw.close();
		}
	}

	//Creamos una carpeta
	public void crearCarpeta(String nombreCarpeta, String ruta) {

		File carpeta = new File(ruta + nombreCarpeta);
		if (!carpeta.exists()) {

			carpeta.mkdir();
		}
	}
	
	public String cambiarTipoDato(String tipoDato) {
		
		if(tipoDato.equals("INT")) {
			tipoDato= "int";			
		}
		
		if(tipoDato.equals("VARCHAR")) {
			tipoDato="String";
		}
		if(tipoDato.equals("BIGINT")) {
			tipoDato="Long";
		}
		return tipoDato;
	}

	public File crearArchivo(String nomArchivo, String nomCarpeta, String ruta) throws IOException {

		File archivo = new File(ruta + nomCarpeta + "/" + nomArchivo + ".java");
		if(!archivo.exists()) {
			archivo.createNewFile();
		}
		return archivo;
	}

	@Test
	public void prueba() {

		System.out.println("Esto me trajo el 3.1416");
	}

}
