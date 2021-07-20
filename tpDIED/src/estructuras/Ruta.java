package estructuras;

import java.time.Duration;

public class Ruta {
	
	private String origen;
	private String destino;
	private Integer distancia;
	private Duration duraci�nDelViaje;
	private Integer cantidadMaxPasajeros;
	private String estado;
	private Integer costo;
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	public Duration getDuraci�nDelViaje() {
		return duraci�nDelViaje;
	}
	public void setDuraci�nDelViaje(Duration duraci�nDelViaje) {
		this.duraci�nDelViaje = duraci�nDelViaje;
	}
	public Integer getCantidadMaxPasajeros() {
		return cantidadMaxPasajeros;
	}
	public void setCantidadMaxPasajeros(Integer cantidadMaxPasajeros) {
		this.cantidadMaxPasajeros = cantidadMaxPasajeros;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	

}
