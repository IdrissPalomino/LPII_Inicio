package entidad;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alumno {

	private int idAlumno;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String correo;
	
	
	
}
