package dominio;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import enums.EstadoEstacion;
import estructuras.Ruta;

public class Estacion {
	
	int nqv;
	private Integer id;
	private String nombre;
    private Instant horarioApertura;
    private Instant horarioCierre;
    private EstadoEstacion estado;
    private ArrayList<Mantenimiento> mantenimientos;
 
    
    
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
	public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Object getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
  	

}
