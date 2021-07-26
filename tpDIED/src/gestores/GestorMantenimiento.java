package gestores;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import dominio.Mantenimiento;
import dto.MantenimientoDTO;

public class GestorMantenimiento {
	
	public static Mantenimiento crearMantenimiento(Instant f1, Instant f2,String observaciones) {
		
		
		
		
		return new Mantenimiento(0, f1, f2, observaciones);
		
	} 
	
	
	public static MantenimientoDTO crearDTO(Mantenimiento m) {
		
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		
MantenimientoDTO mdto= new MantenimientoDTO(m.getId(), m.getEstacion().getId()
				,f.format(Date.from(m.getFechaInicioMan())), f.format(Date.from(m.getFechaInicioMan()))	
				, m.getObservaciones());

return mdto;
		
		
		
		
		
	} 

}
