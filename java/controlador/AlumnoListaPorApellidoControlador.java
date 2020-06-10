package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import model.AlumnoModel;


@WebServlet("/alumnoPorApellido")
public class AlumnoListaPorApellidoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 Se recibe los par�metros del JSP
		String fil = request.getParameter("filtro");
		
		//2 Se realiza la consulta a la base de datos
		AlumnoModel m = new AlumnoModel();
		List<Alumno> lista = m.listaAlumnoPorApellido(fil);
		
		//3 Se guarda en la memoria request la data
		request.setAttribute("ALUMNOS", lista);
		
		//4 Se reenv�a al JSP el request
		request.getRequestDispatcher("/listaAlumnoPorApellido.jsp").forward(request, response);
		
		
	}

}

