package dominio;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import enums.EstadoEstacion;
import estructuras.Ruta;

public class Estacion {
	

	private Integer id;
	private String nombre;
    private String horarioApertura;
    private String horarioCierre;
    private EstadoEstacion estado;
    private ArrayList<Mantenimiento> mantenimientos;
 
    
    
	public Estacion(Integer id, String nombre, String horarioApertura, String horarioCierre, EstadoEstacion estado) {
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
	public String getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public String getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(String horarioCierre) {
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
	

	public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
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
