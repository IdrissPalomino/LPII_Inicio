package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.Alumno;
import util.MySqlDBConexion;

public class AlumnoModel {
	
	private static final Log log = LogFactory.getLog(AlumnoModel.class);

	public int insertaAlumno(Alumno obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MySqlDBConexion.getConexion();
			String sql ="insert into alumno values(null,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setDate(3, obj.getFechaNacimiento());
			pstm.setString(4, obj.getCorreo());
			log.info(pstm);
			//La variable contiene el número de registros en la BD
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	
	public List<Alumno> listaAlumno(){
		List<Alumno> data = new ArrayList<Alumno>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql ="select * from alumno";
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				obj.setCorreo(rs.getString("correo"));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}

	public List<Alumno> listaAlumnoPorFecha(Date desde, Date hasta){
		List<Alumno> data = new ArrayList<Alumno>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql ="select * from alumno where fechaNacimiento between ? and ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, desde);
			pstm.setDate(2, hasta);
			log.info(pstm);
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				obj.setCorreo(rs.getString("correo"));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}
	
	public List<Alumno> listaAlumnoPorNombre(String filtro){
		List<Alumno> data = new ArrayList<Alumno>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql ="select * from alumno where nombre like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(pstm);
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				obj.setCorreo(rs.getString("correo"));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}
	
	public List<Alumno> listaAlumnoPorApellido(String filtro){
		List<Alumno> data = new ArrayList<Alumno>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql ="select * from alumno where apellido like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(pstm);
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				obj.setCorreo(rs.getString("correo"));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}
}
