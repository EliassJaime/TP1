package estructuras;

import dominio.Estacion;
import dominio.LineaTransporte;
import enums.EstadoRuta;



public class Ruta<Estacion> {
	
	private Integer idRuta;
	private Vertice<Estacion> origen;
	private Vertice<Estacion> destino;
	private Double distancia;
	private Double duracionDelViaje;
	private Integer cantidadMaxPasajeros;
	private EstadoRuta estado;
	private Double costo;
	private LineaTransporte lineaTransporte;
	

	public Ruta(){
		distancia=1.0;
		duracionDelViaje=1.0;
		cantidadMaxPasajeros=1;
	} 
	
	public Ruta(Vertice<Estacion> ini,Vertice<Estacion> destino){
		this();
		this.origen = ini;
		this.destino = destino;
	}

	public Ruta(Integer id,Vertice<Estacion> nodo1, Vertice<Estacion> nodo2, Double distancia, Double duracionDelViaje,
			Integer cantidadMaxPasajeros,EstadoRuta estado,Double costo,LineaTransporte linea) {
		this.idRuta=id;
		this.origen = nodo1;
		this.destino = nodo2;
		this.distancia = distancia;
		this.duracionDelViaje = duracionDelViaje;
		this.cantidadMaxPasajeros = cantidadMaxPasajeros;
		this.estado=estado;
		this.costo=costo;
		this.lineaTransporte=linea;
	}


	public Ruta(Vertice<dominio.Estacion> vertice, Vertice<dominio.Estacion> vertice2, double double1, double double2,
			double double3) {
		// TODO Auto-generated constructor stub
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

	public Integer getCantidadMaxPasajeros() {
		return cantidadMaxPasajeros;
	}

	public void setCantidadMaxPasajeros(Integer cantidadMaxPasajeros) {
		this.cantidadMaxPasajeros = cantidadMaxPasajeros;
	}

	public EstadoRuta getEstado() {
		return estado;
	}

	public void setEstado(EstadoRuta estado) {
		this.estado = estado;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return  ""+idRuta +": " +origen.getValor()+"-"+destino.getValor() ;
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

	public Integer getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}

	public LineaTransporte getLineaTransporte() {
		return lineaTransporte;
	}

	public void setLineaTransporte(LineaTransporte lineaTransporte) {
		this.lineaTransporte = lineaTransporte;
	}
	
	
}
	


