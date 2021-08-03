package gestores;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import dao.EstacionDAO;
import dao.MantenimientoDAO;
import dominio.Mantenimiento;
import dto.MantenimientoDTO;

public class GestorMantenimiento {
	
	public static void crearMantenimiento(Integer idEstacion) {
		 Mantenimiento m = new Mantenimiento(0, EstacionDAO.buscarEstacionPorId(idEstacion), Instant.now(), null, null);
		 MantenimientoDAO.guardarMantenimiento(GestorMantenimiento.crearDTO(m)); 
	} 
	
    public static void terminarMantenimiento(Integer idEstacion,String observaciones) {
    	Mantenimiento m = MantenimientoDAO.obtenerMantenimientosByIdEstacion(idEstacion).get(EstacionDAO.buscarEstacionPorId(idEstacion).getMantenimientos().size()-1);
		m.setFechaFinMan(Instant.now());
		m.setObservaciones(observaciones);
		m.setEstacion(EstacionDAO.buscarEstacionPorId(idEstacion));
		MantenimientoDAO.guardarMantenimiento(GestorMantenimiento.crearDTO(m));
	} 

	public static MantenimientoDTO crearDTO(Mantenimiento m) {
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		
		String fechaInicio=f.format(Date.from(m.getFechaInicioMan()));
		
		
		String fechaFin;
		
		if(m.getFechaFinMan()==null) {
			fechaFin="No finalizado";
		} 
		else {
			fechaFin= f.format(Date.from(m.getFechaFinMan()));
		}
		if(m.getObservaciones()==null) {
			m.setObservaciones("");
		}
		
		System.out.println(m.getEstacion());
MantenimientoDTO mdto= new MantenimientoDTO(m.getId(), m.getEstacion().getId()
				,fechaInicio,fechaFin	
				, m.getObservaciones());
return mdto;
	} 
}
