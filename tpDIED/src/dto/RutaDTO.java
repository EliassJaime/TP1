package dto;

public class RutaDTO {

	private Integer idRuta;
	private Integer idOrigenE;
	private Integer idDestinoE;
	private Double distancia;
	private Double duracionDelViaje;
	private Integer cantidadMaxPasajeros;
	private String estado;
	private Double costo;
	private Integer idLineaTransporte;
	
	
	public RutaDTO(Integer idRuta,Integer idLinea, Integer idOrigenE, Integer idDestinoE, Double distancia, Double duracionDelViaje,
			Integer cantidadMaxPasajeros, String estado, Double costo) {
		this.idRuta=idRuta;
		this.idLineaTransporte = idLinea;
		this.idOrigenE = idOrigenE;
		this.idDestinoE = idDestinoE;
		this.distancia = distancia;
		this.duracionDelViaje = duracionDelViaje;
		this.cantidadMaxPasajeros = cantidadMaxPasajeros;
		this.estado = estado;
		this.costo = costo;
	}
	
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public Integer getIdOrigenE() {
		return idOrigenE;
	}
	public void setIdOrigenE(Integer idOrigenE) {
		this.idOrigenE = idOrigenE;
	}
	public Integer getIdDestinoE() {
		return idDestinoE;
	}
	public void setIdDestinoE(Integer idDestinoE) {
		this.idDestinoE = idDestinoE;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getIdLineaTransporte() {
		return idLineaTransporte;
	}

	public void setIdLineaTransporte(Integer idLineaTransporte) {
		this.idLineaTransporte = idLineaTransporte;
	}

	@Override
	public String toString() {
		return ""+idRuta;
	}
	
	
	
	
	
}
