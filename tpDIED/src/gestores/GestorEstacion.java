package gestores;

import java.time.Instant;
import java.util.ArrayList;

import dao.EstacionDAO;
import dao.MantenimientoDAO;
import dominio.Estacion;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import enums.EstadoEstacion;

public class GestorEstacion {
	
	
	public static void altaEstacion(EstacionDTO estacion) {
		
		
		EstacionDAO.guardarEstacion(estacion);
		
		
	}
	public static void editarEstacion(EstacionDTO estacion) {
		
		EstacionDAO.guardarEstacion(estacion);
		
	}
	
	public static void eliminarEstacion(EstacionDTO estacion) {
		
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
			e.setEstado(EstadoEstacion.Operativo);
			MantenimientoDAO.guardarMantenimiento(GestorMantenimiento.crearDTO(m));
			EstacionDAO.guardarEstacion(GestorEstacion.crearDTO(e));
		}
		
		
		
	}
	public static void setearMantenimiento(Estacion e) {
		e.setEstado(EstadoEstacion.EnMantenimiento);
		EstacionDAO.guardarEstacion(GestorEstacion.crearDTO(e));
	}
	
	
	
	private static EstacionDTO crearDTO(Estacion e) {
		return new EstacionDTO(e.getId(), e.getNombre(), e.getEstado().toString(), "15", "15");
	}
	public static Estacion getEstacionById(int id) {
		
		return EstacionDAO.buscarEstacionPorId(id);
	}

}
