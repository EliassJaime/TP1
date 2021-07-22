package dominio;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.Estado;
import estructuras.Ruta;

public class Estacion {
	private Integer id;
	private String nombre;
    private Instant horarioApertura;
    private Instant horarioCierre;
    private Estado estado;
    private ArrayList<Ruta> rutas;
    private ArrayList<Mantenimiento> mantenimientos;
    private Boleto boleto;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public ArrayList<Ruta> getRutas() {
		return rutas;
	}
	public void setRutas(ArrayList<Ruta> rutas) {
		this.rutas = rutas;
	}
	public ArrayList<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	public Boleto getBoleto() {
		return boleto;
	}
	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
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
