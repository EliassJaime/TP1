package dto;

public class EstacionDTO {
	public int id;
	public String nombre;
	public String tipo;
	public int valorPagerank;
	
	public EstacionDTO(int id, String nombre, String tipo) {
  this.id=id;
this.nombre=nombre;
this.tipo=tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getValorPagerank() {
		return valorPagerank;
	}
	public void setValorPagerank(int valorPagerank) {
		this.valorPagerank = valorPagerank;
	}
	
	
}
