package dominio;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import enums.EstadoEstacion;
import estructuras.Ruta;

public class Estacion {
	

	private Integer id;
	private String nombre;
    private Instant horarioApertura;
    private Instant horarioCierre;
    private EstadoEstacion estado;
    private ArrayList<Mantenimiento> mantenimientos;
 
    
    
	public Estacion(Integer id, String nombre, Instant horarioApertura, Instant horarioCierre, EstadoEstacion estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.estado = estado;
		mantenimientos= new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Instant getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(Instant horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public Instant getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(Instant horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public EstadoEstacion getEstado() {
		return estado;
	}
	public void setEstado(EstadoEstacion estado) {
		this.estado = estado;
	}

	public ArrayList<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	public void addMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + ", horarioApertura=" + horarioApertura + ", horarioCierre="
				+ horarioCierre + ", estado=" + estado + ", mantenimientos=" + mantenimientos + "]";
	}
    
    
  	

}
