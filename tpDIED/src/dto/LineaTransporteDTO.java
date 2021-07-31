package dto;

public class LineaTransporteDTO {

	private Integer idLinea;
	private String nombre;
	private String color;
	private String estadoLinea;
	
	public LineaTransporteDTO(Integer idLinea, String nombre, String color, String estadoLinea) {
		this.idLinea = idLinea;
		this.nombre = nombre;
		this.color = color;
		this.estadoLinea = estadoLinea;
	}
	public LineaTransporteDTO() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
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
	public String getEstadoLinea() {
		return estadoLinea;
	}
	
	public void setEstado(String string) {
		this.estadoLinea = string;
		
	}
	
	
	
}
