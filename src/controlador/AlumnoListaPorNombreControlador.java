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


@WebServlet("/alumnoPorNombre")
public class AlumnoListaPorNombreControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 Se recibe los parámetros del JSP
		String fil = request.getParameter("filtro");
		
		//2 Se realiza la consulta a la base de datos
		AlumnoModel m = new AlumnoModel();
		List<Alumno> lista = m.listaAlumnoPorNombre(fil);
		
		//3 Se guarda en la memoria request la data
		request.setAttribute("ALUMNOS", lista);
		
		//4 Se reenvía al JSP el request
		request.getRequestDispatcher("/listaAlumnoPorNombre.jsp").forward(request, response);
		
		
	}

}

