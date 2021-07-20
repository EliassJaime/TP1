package clases;

import java.time.Instant;

public class Mantenimiento {
	
	private Instant fechaInicioMan;
    private Instant fechaFinMan;
    private String observaciones;
    
    
	public Instant getFechaInicioMan() {
		return fechaInicioMan;
	}
	public void setFechaInicioMan(Instant fechaInicioMan) {
		this.fechaInicioMan = fechaInicioMan;
	}
	public Instant getFechaFinMan() {
		return fechaFinMan;
	}
	public void setFechaFinMan(Instant fechaFinMan) {
		this.fechaFinMan = fechaFinMan;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
    
    

}
