package gestores;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import dao.EstacionDAO;
import dao.MantenimientoDAO;
import dao.RutaDAO;
import dominio.Estacion;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import dto.RutaDTO;
import enums.EstadoEstacion;
import estructuras.Grafo;

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
	
	
	
	public static EstacionDTO crearDTO(Estacion e) {
		return new EstacionDTO(e.getId(), e.getNombre(), e.getEstado().toString(), "15", "15");
	}
	public static Estacion getEstacionById(int id) {
		
		return EstacionDAO.buscarEstacionPorId(id);
	}
    public static int getIdEstacionByNombre(String nombre) {
		
		return EstacionDAO.getIdEstacion(nombre);
	}

	public static List<List<String>> flujoMaximoGestor(Estacion o, Estacion d) {
		
		return Grafo.getInstance().flujoMaximo(o, d);
		
	}
	public static ArrayList<Estacion> obtenerPageRank(){
		 return Grafo.getInstance().getEstacionPagerank();
	}
    public static void eliminarEstacion(Estacion estacion) {
		
		EstacionDAO.EliminarEstacion(estacion.getId());
	}
	

}
