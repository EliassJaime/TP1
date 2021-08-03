package gestores;

import java.util.ArrayList;

import dao.RutaDAO;
import dominio.Estacion;
import dto.RutaDTO;
import estructuras.Grafo;
import estructuras.Ruta;


public class GestorRuta {
	public static ArrayList<Ruta<Estacion>> buscarTodasLasRutas(){
		return RutaDAO.buscarTodasLasRutas();
	}
	
	public static void guardarRuta(RutaDTO rutaDto) {
		rutaDto.setIdRuta(0);
		RutaDAO.guardarRuta(rutaDto);
		Grafo.getInstance().actualizarGrafo();
	}

	public static RutaDTO obtenerDTO(Ruta<Estacion> r) {
		RutaDTO dto=new RutaDTO(r.getIdRuta(), r.getLineaTransporte().getIdLinea(), r.getOrigen().getValor().getId(), 
				r.getDestino().getValor().getId(), r.getDistancia(), r.getDuracionDelViaje(), r.getCantidadMaxPasajeros(), 
				r.getEstado().toString(), r.getCosto());
		return dto;
	}

}