package gestores;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import dao.BoletoDAO;
import dao.ClienteDAO;
import dao.EstacionDAO;
import dominio.Boleto;
import dominio.Estacion;
import dto.BoletoDTO;
import dto.RutaDTO;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;

public class GestorBoletos {
	
	
	
	public static Boleto generarBoletoRutaMasCorta(Integer idOrigen,Integer idDestino,Integer idCliente) {
		
		
		Boleto boleto= new Boleto();
		
		Estacion origen=EstacionDAO.buscarEstacionPorId(idOrigen);
		Estacion destino=EstacionDAO.buscarEstacionPorId(idDestino);
		
		boleto.setCamino(Grafo.getInstance().caminoMinimoDistancia
		(new Vertice<>(origen), new Vertice<>(destino)));
		boleto.setidBoleto(BoletoDAO.obtenerId());
		boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
		boleto.setOrigen(origen);
		boleto.setDestino(destino);
		boleto.setCliente(ClienteDAO.obtenerClienteByID(idCliente));
		
		boleto.setFechaDeVenta(Instant.now());
		
		return boleto;
		
		
	}
    public static Boleto generarBoletoRutaMasBarata(Integer idOrigen,Integer idDestino,Integer idCliente) {
    	Boleto boleto= new Boleto();
    	
		
		Estacion origen=EstacionDAO.buscarEstacionPorId(idOrigen);
		Estacion destino=EstacionDAO.buscarEstacionPorId(idDestino);
    	
    	boleto.setCamino(Grafo.getInstance().caminoMinimoCosto
		(new Vertice<>(origen)
				, new Vertice<>(destino)));
    	boleto.setidBoleto(BoletoDAO.obtenerId());
    	boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
		
    	
    	boleto.setOrigen(origen);
		boleto.setDestino(destino);
		boleto.setCliente(ClienteDAO.obtenerClienteByID(idCliente));
		
		boleto.setFechaDeVenta(Instant.now());
    	return boleto;
	
    
    
    }
    public static Boleto generarBoletoRutaMenosTiempo(Integer idOrigen,Integer idDestino,Integer idCliente) {
		
    	Boleto boleto= new Boleto();
		
		Estacion origen=EstacionDAO.buscarEstacionPorId(idOrigen);
		Estacion destino=EstacionDAO.buscarEstacionPorId(idDestino);
    	
    	
    	boleto.setCamino(Grafo.getInstance().caminoMinimoDuracion
		(new Vertice<>(origen)
				, new Vertice<>(destino)));
		
    	
    	boleto.setCostoBol(Grafo.getInstance().costoCaminoRutas(boleto.getCamino()));
    	boleto.setidBoleto(BoletoDAO.obtenerId());
    	boleto.setOrigen(origen);
		boleto.setDestino(destino);
		boleto.setCliente(ClienteDAO.obtenerClienteByID(idCliente));
		
		boleto.setFechaDeVenta(Instant.now());
		return boleto;
	}
    
    
    public static void guardarBoleto(Boleto boleto) {
    
    	 BoletoDAO.guardarBoleto(crearDTO(boleto));
    	
    	
    	
    	
    }
    
    public static BoletoDTO crearDTO(Boleto boleto) {
    	
    	ArrayList<RutaDTO> rutas= new ArrayList<>();
    	
    	
    	SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
    	
    	
    	for(Ruta<Estacion> r:boleto.getCamino()) {
    		
    		System.out.println(r);
    		rutas.add(new RutaDTO(r.getIdRuta(), r.getLineaTransporte().getIdLinea(), r.getOrigen().getValor().getId(), r.getDestino().getValor().getId(), r.getDistancia(), r.getDuracionDelViaje(), r.getCantidadMaxPasajeros(), r.getEstado().toString(), r.getCosto()));
    			
    	}
    	
    		System.out.println(rutas);
    	
    	BoletoDTO dto=new BoletoDTO(0, boleto.getCliente().getId(), f.format(Date.from(boleto.getFechaDeVenta())), boleto.getOrigen().getId(),boleto.getDestino().getId(), boleto.getCostoBol());
    	dto.setRuta(rutas);
    	
    	return dto ;
    }
	

}
