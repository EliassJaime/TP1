package dto;

public class MantenimientoDTO {

	private Integer idMantenimiento;
	private Integer idEstacion;
	private String fechaInicio;
	private String fechaFin;
	private String observaciones;
	
	public MantenimientoDTO(Integer idMantenimiento, Integer idEstacion, String fechaInicio, String fechaFin,
			String observaciones) {
		this.idMantenimiento = idMantenimiento;
		this.idEstacion = idEstacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.observaciones = observaciones;
	}
	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	public Integer getIdEstacion() {
		return idEstacion;
	}
	public void setIdEstacion(Integer idEstacion) {
		this.idEstacion = idEstacion;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
}
