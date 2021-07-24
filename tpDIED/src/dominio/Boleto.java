package dominio;

import java.time.Instant;
import java.util.List;

import estructuras.Vertice;

public class Boleto {
	
	private Integer idBoleto;
	private Cliente cliente;
	private Instant fechaDeVenta;
	private Estacion origen;
	private Estacion destino;
	private List<Vertice<Estacion>> camino;
	private Double costoBol;
	
	
	
	
	public Boleto(Integer idBoleto, Cliente cliente, Instant fechaDeVenta, Estacion origen, Estacion destino,
			List<Vertice<Estacion>> camino, Double costoBol) {
	
		this.idBoleto = idBoleto;
		this.cliente = cliente;
		this.fechaDeVenta = fechaDeVenta;
		this.origen = origen;
		this.destino = destino;
		this.camino = camino;
		this.costoBol = costoBol;
	}
	public Integer getidBoleto() {
		return idBoleto;
	}
	public void setidBoleto(Integer idBoleto) {
		this.idBoleto = idBoleto;
	}
	
	public Instant getFechaDeVenta() {
		return fechaDeVenta;
	}
	public void setFechaDeVenta(Instant fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}
	public Estacion getOrigen() {
		return origen;
	}
	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}
	public Estacion getDestino() {
		return destino;
	}
	public void setDestino(Estacion destino) {
		this.destino = destino;
	}
	public Double getCostoBol() {
		return costoBol;
	}
	public void setCostoBol(Double costoBol) {
		this.costoBol = costoBol;
	}
	public List<Vertice<Estacion>> getCamino() {
		return camino;
	}
	public void setCamino(List<Vertice<Estacion>> camino) {
		this.camino = camino;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", cliente=" + cliente + ", fechaDeVenta=" + fechaDeVenta + ", origen="
				+ origen + ", destino=" + destino + ", camino=" + camino + ", costoBol=" + costoBol + "]";
	}
	
	
	

}
