package gestores;

import java.util.ArrayList;

import dao.RutaDAO;
import dominio.Estacion;
import dto.RutaDTO;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;


public class GestorRuta {
	
	public static ArrayList<Ruta<Estacion>> buscarTodasLasRutas(){
		return RutaDAO.buscarTodasLasRutas();
		
	}

	public static void guardarRuta(RutaDTO rutaDto) {
		
		RutaDAO.guardarRuta(rutaDto);
		Grafo.getInstance().actualizarGrafo();
		
	}

}