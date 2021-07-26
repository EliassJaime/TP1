package gestores;

import dao.EstacionDAO;
import dominio.Boleto;
import estructuras.Grafo;
import estructuras.Vertice;

public class GestorBoletos {
	
	
	
	public static Boleto generarBoletoRutaMasCorta(Integer idOrigen,Integer idDestino) {
		
		
		Boleto boleto= new Boleto();
		
		
		boleto.setCamino(Grafo.getInstance().caminoMinimoDistancia
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen)), new Vertice<>(EstacionDAO.getNombreEstacion(idDestino)))
		);
		
		
		boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
		
		
		return boleto;
		
		
	}
    public static Boleto generarBoletoRutaMasBarata(Integer idOrigen,Integer idDestino) {
    	Boleto boleto= new Boleto();
    	
    	boleto.setCamino(Grafo.getInstance().caminoMinimoCosto
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen))
				, new Vertice<>(EstacionDAO.getNombreEstacion(idDestino))));
    	
    	boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
		return boleto;
	
    
    
    }
    public static Boleto generarBoletoRutaMenosTiempo(Integer idOrigen,Integer idDestino) {
		
    	Boleto boleto= new Boleto();
    	
    	
    	boleto.setCamino(Grafo.getInstance().caminoMinimoDuracion
		(new Vertice<>(EstacionDAO.getNombreEstacion(idOrigen))
				, new Vertice<>(EstacionDAO.getNombreEstacion(idDestino))));
		
    	
    	boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
		return boleto;
	}
	

}
