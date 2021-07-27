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
		return nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
    
  	

}
