package dto;

public class EstacionDTO {
	
	
	private Integer id;
	private String nombre;
	private String estado;
	private String horarioApertura;
	private String horarioCierre;
	
	public EstacionDTO(Integer id, String nombre, String estado, String horarioApertura, String horarioCierre) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
	}
	public EstacionDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public String getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(String horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public void setValorPagerank(int pageRank) {
		// TODO Auto-generated method stub
		
	}

	
}
