package dominio;

import java.util.List;

import enums.EstadoRuta;
import estructuras.Ruta;

public class LineaTransporte {

	private Integer idLinea;
	private String nombre;
	private String color;
	private EstadoRuta estadolinea;
	private List<Ruta> trayectoria;
	
	public LineaTransporte(Integer idLinea, String nombre, String color, EstadoRuta estadolinea, List<Ruta> trayectoria) {
		this.idLinea=idLinea;
		this.nombre = nombre;
		this.color = color;
		this.estadolinea = estadolinea;
		this.trayectoria = trayectoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public EstadoRuta getEstadolinea() {
		return estadolinea;
	}
	public void setEstadolinea(EstadoRuta estadolinea) {
		this.estadolinea = estadolinea;
	}
	public List<Ruta> getTrayectoria() {
		return trayectoria;
	}
	public void setTrayectoria(List<Ruta> trayectoria) {
		this.trayectoria = trayectoria;
	}
	public Integer getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}
	
	
}
