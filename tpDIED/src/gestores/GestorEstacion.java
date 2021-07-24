package gestores;

import java.time.Instant;
import java.util.ArrayList;

import dao.EstacionDAO;
import dominio.Estacion;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import enums.EstadoEstacion;

public class GestorEstacion {
	
	
	public static void altaEstacion(Estacion estacion) {
		
		
		EstacionDTO dto= new EstacionDTO(0, estacion.getNombre(), estacion.getEstado().toString(), "15", "15");
		EstacionDAO.guardarEstacion(dto);
		
		
	}
	public static void editarEstacion(Estacion estacion) {
		EstacionDTO dto= crearDTO(estacion);
		EstacionDAO.guardarEstacion(dto);
		
	}
	
	public static void eliminarEstacion(Estacion estacion) {
		
		EstacionDAO.EliminarEstacion(estacion.getId());
	}
	
	
	public static ArrayList<Estacion> buscarTodasLasEstaciones(){
		
		return EstacionDAO.buscarTodasLasEstaciones();
	}

	public static void terminarMantenimiento(Estacion e,Instant f1,Instant f2,String observaciones) {
		
		if(e.getEstado()==EstadoEstacion.EnMantenimiento) {
			Mantenimiento m=GestorMantenimiento.crearMantenimiento(f1, f2, observaciones);
			m.setEstacion(e);
			e.addMantenimiento(m);
			EstacionDAO.guardarEstacion(GestorEstacion.crearDTO(e));
		}
		
		
		
	}
	public static void setearMantenimiento(Estacion e) {
		e.setEstado(EstadoEstacion.EnMantenimiento);
	}
	
	
	
	private static EstacionDTO crearDTO(Estacion e) {
		return new EstacionDTO(e.getId(), e.getNombre(), e.getEstado().toString(), "15", "15");
	}
	public static Estacion getEstacionById(int id) {
		
		return EstacionDAO.buscarEstacionPorId(id);
	}

}
