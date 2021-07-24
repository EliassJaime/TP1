package gestores;

import dao.EstacionDAO;
import estructuras.Grafo;
import estructuras.Vertice;

public class GestorBoletos {
	
	
	
	public static void generarBoletoRutaMasCorta(Integer idOrigen,Integer idDestino) {
		
		Grafo.getInstance().caminoMinimoCosto
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen)), new Vertice<>(EstacionDAO.getNombreEstacion(idDestino)));
		
		
	}
    public static void generarBoletoRutaMasBarata(Integer idOrigen,Integer idDestino) {
    	Grafo.getInstance().caminoMinimoDistancia
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen)), new Vertice<>(EstacionDAO.getNombreEstacion(idDestino)));
		
		
	}
    public static void generarBoletoRutaMenosTiempo(Integer idOrigen,Integer idDestino) {
		
    	Grafo.getInstance().caminoMinimoDuracion
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen)), new Vertice<>(EstacionDAO.getNombreEstacion(idDestino)));
		
	}
	

}
