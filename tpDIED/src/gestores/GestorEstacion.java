package gestores;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import dao.EstacionDAO;
import dao.LineaTransporteDAO;
import dao.MantenimientoDAO;
import dao.RutaDAO;
import dominio.Estacion;
import dominio.LineaTransporte;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import dto.LineaTransporteDTO;
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

	/*public static void terminarMantenimiento(Estacion e,Instant f1,Instant f2,String observaciones) {
		
		if(e.getEstado()==EstadoEstacion.EnMantenimiento) {
			Mantenimiento m=GestorMantenimiento.crearMantenimiento(observaciones);
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
	}*/
	
	
	
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
	public static ArrayList<EstacionDTO> obtenerPageRank(){
		 return Grafo.getInstance().getEstacionPagerank();
	}
    public static void eliminarEstacion(Estacion estacion) {
		
		EstacionDAO.EliminarEstacion(estacion.getId());
	}
	public static ArrayList<EstacionDTO> buscarEstaciones(Integer id, String n, String es, String horarioapertura,
			String horariocierre) {
			ArrayList<Estacion> estaciones=EstacionDAO.buscarTodasLasEstaciones();

			
			int tam=estaciones.size();
			if(id!=-1) {
				for(int i=0; i<tam;i++) {
					
					if(estaciones.get(i).getId()!=id) {
						estaciones.remove(i);
						i--;
						tam=estaciones.size();
					}	
				}
				}
			if(n!="all") {
				for(int i=0; i<tam;i++) {
					
					if(estaciones.get(i).getNombre().toLowerCase().compareTo(n)!=0) {
						
						estaciones.remove(i);
						i--;
						tam=estaciones.size();
					}	
				}
				}
			if(es!="all") {
				for(int i=0; i<tam;i++) {
					System.out.println(estaciones.get(i).getEstado().toString());
					if(!estaciones.get(i).getEstado().toString().toLowerCase().equals(es)) {
						estaciones.remove(i);
						i--;
						tam=estaciones.size();
					}	
				}
				}
			if(horarioapertura!="all") {
				for(int i=0; i<tam;i++) {
					
					if(estaciones.get(i).getHorarioApertura().toLowerCase().compareTo(horarioapertura)!=0) {
						estaciones.remove(i);
						i--;
						tam=estaciones.size();
					}	
				}
				}
			
			if(horariocierre!="all") {
				for(int i=0; i<tam;i++) {
					
					if(estaciones.get(i).getHorarioCierre().toLowerCase().compareTo(horariocierre)!=0) {
						estaciones.remove(i);
						i--;
						tam=estaciones.size();
					}	
				}
				}
		return GestorEstacion.obtenerEstacionDTO(estaciones);
	}
	
	private static ArrayList<EstacionDTO> obtenerEstacionDTO(ArrayList<Estacion> estaciones) {
ArrayList<EstacionDTO> estacionesDTO=new ArrayList<EstacionDTO>();
		
		for(Estacion c:estaciones) {
			EstacionDTO dto=new EstacionDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getNombre());
			dto.setEstado(c.getEstado().toString());
			dto.setHorarioApertura(c.getHorarioApertura());
			dto.setHorarioCierre(c.getHorarioCierre());
			estacionesDTO.add(dto);
	}
	return estacionesDTO;
}
}
