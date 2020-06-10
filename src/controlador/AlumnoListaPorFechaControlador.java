package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import model.AlumnoModel;


@WebServlet("/alumnoPorFecha")
public class AlumnoListaPorFechaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String des = request.getParameter("desde");
		String has = request.getParameter("hasta");
		
		Date fecDesde = null, fecHasta = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fecDesde = new Date(sdf.parse(des).getTime());
			fecHasta = new Date(sdf.parse(has).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AlumnoModel m = new AlumnoModel();
		List<Alumno> lista = m.listaAlumnoPorFecha(fecDesde, fecHasta);
		
		request.setAttribute("ALUMNOS", lista);
		request.getRequestDispatcher("/listaAlumnoPorFechaNacimiento.jsp").forward(request, response);
	}

}

