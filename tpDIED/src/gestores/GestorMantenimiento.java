package gestores;

import java.time.Instant;

import dominio.Mantenimiento;

public class GestorMantenimiento {
	
	public static Mantenimiento crearMantenimiento(Instant f1, Instant f2,String observaciones) {
		
		
		return new Mantenimiento(0, f1, f2, observaciones);
		
	} 

}
