package clases;

import java.time.Instant;

public class Boleto {
	
	private Integer numBoleto;
	private String correoElectronico;
	private String nombreCliente;
	private Instant fechaDeVenta;
	private String nombreEstacionOrigen;
	private String nombreEstacionDestino;
	private Camino camino;
	private Integer costoBol;
	public Integer getNumBoleto() {
		return numBoleto;
	}
	public void setNumBoleto(Integer numBoleto) {
		this.numBoleto = numBoleto;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Instant getFechaDeVenta() {
		return fechaDeVenta;
	}
	public void setFechaDeVenta(Instant fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}
	public String getNombreEstacionOrigen() {
		return nombreEstacionOrigen;
	}
	public void setNombreEstacionOrigen(String nombreEstacionOrigen) {
		this.nombreEstacionOrigen = nombreEstacionOrigen;
	}
	public String getNombreEstacionDestino() {
		return nombreEstacionDestino;
	}
	public void setNombreEstacionDestino(String nombreEstacionDestino) {
		this.nombreEstacionDestino = nombreEstacionDestino;
	}
	public Camino getCamino() {
		return camino;
	}
	public void setCamino(Camino camino) {
		this.camino = camino;
	}
	public Integer getCostoBol() {
		return costoBol;
	}
	public void setCostoBol(Integer costoBol) {
		this.costoBol = costoBol;
	}
	
	
	

}
