package dto;

public class BoletoDTO {

	private Integer idBoleto;
	private Integer idCliente;
	private String fechaVenta;
	private Integer idOrigen;
	private Integer idDestino;
	private Double costoBol;
	
	public BoletoDTO(Integer idBoleto, Integer idCliente, String fechaVenta, Integer idOrigen, Integer idDestino,
			Double costoBol) {
		this.idBoleto = idBoleto;
		this.idCliente = idCliente;
		this.fechaVenta = fechaVenta;
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
		this.costoBol = costoBol;
	}
	public Integer getIdBoleto() {
		return idBoleto;
	}
	public void setIdBoleto(Integer idBoleto) {
		this.idBoleto = idBoleto;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Integer getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}
	public Integer getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}
	public Double getCostoBol() {
		return costoBol;
	}
	public void setCostoBol(Double costoBol) {
		this.costoBol = costoBol;
	}
	
	
}
