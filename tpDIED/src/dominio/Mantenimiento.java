package dominio;

import java.time.Instant;

public class Mantenimiento   {

	private Integer id;
	private Estacion estacion;
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Mantenimiento(Integer id,Estacion estacion, Instant fechaInicioMan, Instant fechaFinMan, String observaciones) {
		this.estacion=estacion;
		this.id = id;
		this.fechaInicioMan = fechaInicioMan;
		this.fechaFinMan = fechaFinMan;
		this.observaciones = observaciones;
	}

	public Mantenimiento(Integer id, Instant fechaInicioMan, Instant fechaFinMan, String observaciones) {
		this.id = id;
		this.fechaInicioMan = fechaInicioMan;
		this.fechaFinMan = fechaFinMan;
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Mantenimiento [id=" + id +  ", observaciones=" + observaciones + "]";
	}




	
	

}
