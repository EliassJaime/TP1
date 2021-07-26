package gestores;

import java.util.ArrayList;

import dao.LineaTransporteDAO;
import dao.RutaDAO;
import dominio.LineaTransporte;
import dto.EstacionDTO;
import dto.LineaTransporteDTO;
import dto.RutaDTO;

public class GestorLineaTransporte {

	public static void altaLineaTransporte(LineaTransporte l) {

		LineaTransporteDAO.guardarLineaTransporte(
				new LineaTransporteDTO(l.getIdLinea(), l.getNombre(), l.getColor(), l.getEstadolinea().toString()));
	}

	public static void editarLineaTransporte(LineaTransporte l) {

		LineaTransporteDAO.guardarLineaTransporte(crearDTO(l));

	}
	
	public static void eliminarLineaTransporte(LineaTransporte l) {
		LineaTransporteDAO.eliminarLineaTransporteByID(l.getIdLinea());
		
		
	}
	
	
	
	public static void agregarTrayecto(Integer idLineaTransporte, ArrayList<EstacionDTO> estaciones) {
		
		
		ArrayList<RutaDTO> rutas= new ArrayList<>();
		
		
		
		for(int i=0;i<(estaciones.size()-1);i++) {
		
		rutas.add(new RutaDTO(0,idLineaTransporte, estaciones.get(i).getId(), estaciones.get(i+1).getId(), 3.0, 2.3, 15, "Activa", 32.2));
		
		}
		
		for(RutaDTO r:rutas) {
			RutaDAO.guardarRuta(r);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public static LineaTransporteDTO crearDTO(LineaTransporte l) {
		return new LineaTransporteDTO(l.getIdLinea(), l.getNombre(), l.getColor(), l.getEstadolinea().toString());
	}
	
	
	
	

}
