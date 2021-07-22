package estructuras;

import java.time.Duration;

import dominio.Estacion;



public class Ruta<Estacion> {
	
	private Vertice<Estacion> origen;
	private Vertice<Estacion> destino;
	private Double distancia;
	private Double duracionDelViaje;
	private Double cantidadMaxPasajeros;
	private String estado;
	private Integer costo;
	

	public Ruta(){
		distancia=1.0;
		duracionDelViaje=1.0;
		cantidadMaxPasajeros=1.0;
	} 
	
	public Ruta(Vertice<Estacion> ini,Vertice<Estacion> destino){
		this();
		this.origen = ini;
		this.destino = destino;
	}

	public Ruta(Vertice<Estacion> ini,Vertice<Estacion> destino,double distancia, double duracionDelViaje, double cantidadMaxPasajeros){
		this(ini,destino);
		this.distancia=  distancia;
		this.duracionDelViaje=  duracionDelViaje;
		this.cantidadMaxPasajeros= cantidadMaxPasajeros;
	}
	
	
	public Vertice<Estacion> getOrigen() {
		return origen;
	}

	public void setOrigen(Vertice<Estacion> origen) {
		this.origen = origen;
	}

	public Vertice<Estacion> getDestino() {
		return destino;
	}

	public void setDestino(Vertice<Estacion> destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getDuracionDelViaje() {
		return duracionDelViaje;
	}

	public void setDuracionDelViaje(Double duracionDelViaje) {
		this.duracionDelViaje = duracionDelViaje;
	}

	public Double getCantidadMaxPasajeros() {
		return cantidadMaxPasajeros;
	}

	public void setCantidadMaxPasajeros(Double cantidadMaxPasajeros) {
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

	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Ruta) && ((Ruta)obj).getValor().equals(this.distancia); 
	}

	private Object getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getDuracionRecorrido() {
		// TODO Auto-generated method stub
		return null;
	}
}
	


