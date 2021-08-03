package estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import dto.EstacionDTO;
import enums.EstadoEstacion;
import enums.EstadoRuta;
import gestores.GestorEstacion;
import gestores.GestorRuta;




public class Grafo<Estacion> {
	
	private static Grafo GRAFO;
	
	private List<Ruta> rutas;
	private List<Vertice<Estacion>> vertices;

	
	 public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public List<Vertice<Estacion>> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice<Estacion>> vertices) {
		this.vertices = vertices;
	}

	public Grafo(List<Ruta> rutas, List<Vertice<Estacion>> vertices) {
		// TODO Auto-generated constructor stub
		 this.rutas=rutas;
		 this.vertices=vertices;
	}
	
	public  static Grafo getInstance() {
		 
		 if (GRAFO==null) {
			 
			 ArrayList<Vertice<dominio.Estacion>> listaVertices = new ArrayList<Vertice<dominio.Estacion>>();
			 ArrayList<dominio.Estacion> Estaciones = GestorEstacion.buscarTodasLasEstaciones();
			 
			 for(dominio.Estacion p : Estaciones) 
				 
				 listaVertices.add(new Vertice<dominio.Estacion>(p));
			 
			 GRAFO = new Grafo(GestorRuta.buscarTodasLasRutas(), listaVertices);
		 }
		 return GRAFO;
	}
	
	
	public Grafo(){
		this.rutas = new ArrayList<Ruta>();
		this.vertices = new ArrayList<Vertice<Estacion>>();
	}
	
	public List<Vertice<Estacion>> vertices() {
		return this.vertices;
	}
	
	public void addNodo(Estacion nodo){
		this.addNodo(new Vertice<Estacion>(nodo));
	}

	private void addNodo(Vertice<Estacion> nodo){
		this.vertices.add(nodo);
	}
	


	



	
	

	public List<Vertice<Estacion>> getAdyacentes(Vertice<Estacion> unNodo){  
		List<Vertice<Estacion>> salida = new ArrayList<Vertice<Estacion>>();
		for(Ruta enlace : this.rutas){
			if( enlace.getOrigen().equals(unNodo) && !((dominio.Estacion)enlace.getDestino().getValor())
					.getEstado().equals(EstadoEstacion.EnMantenimiento)){
				salida.add(enlace.getDestino());
			}
		}
		return salida; 
	}
	


	public Integer gradoEntrada(Vertice<Estacion> vertice){
		Integer res =0;
		for(Ruta arista : this.rutas){
			if(arista.getDestino().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<Estacion> vertice){
		Integer res =0;
		for(Ruta arista : this.rutas){
			if(arista.getOrigen().equals(vertice)) ++res;
		}
		return res;
	}

        
    private boolean esAdyacente(Vertice<Estacion> v1,Vertice<Estacion> v2){
    	List<Vertice<Estacion>> ady = this.getAdyacentes(v1);
        for(Vertice<Estacion> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
    
    
    public void actualizarGrafo() {
    	
    	 ArrayList<Vertice<Estacion>> listaVertices = new ArrayList<Vertice<Estacion>>();
		 ArrayList<Estacion> Estaciones = (ArrayList<Estacion>) GestorEstacion.buscarTodasLasEstaciones();
		 
		 for(Estacion p : Estaciones) 
			 
			 listaVertices.add(new Vertice<Estacion>(p));
		 
		 GRAFO = new Grafo(GestorRuta.buscarTodasLasRutas(), listaVertices);
    }
    
    
    public ArrayList<Integer> flujoMaximoValor(Estacion Origen, Estacion Destino) {
    	ArrayList<Integer> retorno = new ArrayList<Integer>();
    	List<List<String>> recorridos = flujoMaximo( Origen, Destino);
    	
    	for(List<String> ls : recorridos) {
    		retorno.add(Integer.parseInt(ls.subList(ls.size()-1, ls.size()).get(0)));
    	}
    	
    	return retorno;
    }
    
    public List<List<String>> flujoMaximo (Estacion Origen, Estacion Destino){
    return this.flujoMaximo(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
    }
    
    public List<List<String>> flujoMaximo (Vertice<Estacion> Origen, Vertice<Estacion> Destino){
   
    	
    	List<List<String>> retorno = new ArrayList<List<String>>();
    	
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	System.out.println(listaAdyOrigen);
    	
    	List<List<Vertice<Estacion>>> recorridos = getRecorridosFlujo(listaAdyOrigen,Origen, Destino); 

    		
    		for(int i = 0; i<recorridos.size();i++) {
    				
    				List<String> recorridoString = new ArrayList<String>();
    				List<Vertice<Estacion>> recorrido = recorridos.get(i);
    		
    				
    				for(int j = 0; j<recorrido.size();j++){
    					
    					if(j!= 0) {
    						Ruta ruta= rutaEntreDosEstacionesFlujo(recorrido.get(j-1), recorrido.get(j));
    					
    						
    						if(recorridoString.size() == 1) {
    							
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getCantidadMaxPasajeros()));
    						}else if(Double.parseDouble(recorridoString.get(recorridoString.size()-1)) > ruta.getCantidadMaxPasajeros()) {
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getCantidadMaxPasajeros()));
    						}else {
    							String cantMax = recorridoString.get(recorridoString.size()-1);
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(cantMax);
    						}
    					}else {
    						recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    					}
    				}
    				retorno.add(recorridoString);
    			}    	
    	
    	return retorno;
    	
    }
    
    
    public List<List<Vertice<Estacion>>> getRecorridos(List<Vertice<Estacion>> listaAdy, Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	List<List<Vertice<Estacion>>> retorno = new ArrayList<List<Vertice<Estacion>>>();
    	
    	if(!listaAdy.isEmpty()) {
    		
    		for (Vertice<Estacion> v : listaAdy) {
    		
    			if(v.equals(Destino) && !((dominio.Estacion)Destino.getValor())
    					.getEstado().equals(EstadoEstacion.EnMantenimiento)) {
    				
    				List<Vertice<Estacion>> recorrido = new ArrayList<Vertice<Estacion>>();
    				recorrido.add(Origen);
    				recorrido.add(v);
    				retorno.add(recorrido);
    				
    			}else {
    				List<List<Vertice<Estacion>>> listaSub = getRecorridos(this.getAdyacentes(v), v, Destino);
    				if(!listaAdy.isEmpty()) {
    					for(List<Vertice<Estacion>> ls : listaSub) {
    						
    						List<Vertice<Estacion>> recorrido = new ArrayList<Vertice<Estacion>>();
    						
    						recorrido.add(Origen);
    						recorrido.addAll(ls);
    						retorno.add(recorrido);
    						
    						
    					}
    				}
    			}
    		}
    	}
		return retorno;
	}
    public List<List<Vertice<Estacion>>> getRecorridosFlujo(List<Vertice<Estacion>> listaAdy, Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	List<List<Vertice<Estacion>>> retorno = new ArrayList<List<Vertice<Estacion>>>();
    	
    	if(!listaAdy.isEmpty()) {
    		
    		for (Vertice<Estacion> v : listaAdy) {
    		
    			if(v.equals(Destino)) {
    				
    				List<Vertice<Estacion>> recorrido = new ArrayList<Vertice<Estacion>>();
    				recorrido.add(Origen);
    				recorrido.add(v);
    				retorno.add(recorrido);
    				
    			}else {
    				List<List<Vertice<Estacion>>> listaSub = getRecorridosFlujo(this.getAdyacentes(v), v, Destino);
    				if(!listaAdy.isEmpty()) {
    					for(List<Vertice<Estacion>> ls : listaSub) {
    						
    						List<Vertice<Estacion>> recorrido = new ArrayList<Vertice<Estacion>>();
    						
    						recorrido.add(Origen);
    						recorrido.addAll(ls);
    						retorno.add(recorrido);
    						
    						
    					}
    				}
    			}
    		}
    	}
		return retorno;
	}

	public Ruta rutaEntreDosEstaciones(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	for (Ruta r : this.rutas) {

    		if (r.getOrigen().equals(Origen) && r.getDestino().equals(Destino) && r.getEstado().equals(EstadoRuta.Activa)) {return r;}
    	}
		return null;
    }
	public Ruta rutaEntreDosEstacionesFlujo(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	for (Ruta r : this.rutas) {

    		if (r.getOrigen().equals(Origen)) {return r;}
    	}
		return null;
    }
	
	public List<Ruta<Estacion>> caminoMinimoDistancia(Estacion Origen,Estacion Destino){
		List<Ruta<Estacion>> retorno = this.caminoMinimoDistancia(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
		
		return retorno;
	}
	
	
	public List<Ruta<Estacion>> caminoMinimoDistancia(Vertice<Estacion> Origen,Vertice<Estacion> Destino) {
		List<Ruta<Estacion>> retorno = new ArrayList<>();
		
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> caminos = getRecorridos(listaAdyOrigen,Origen, Destino);
    	
    	Double distanciaMinima=null;
    	
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Estacion>> c = caminos.get(j);
    		Double distanciaMinimaAux = distanciaCamino(caminos.get(j));
    		List<Ruta<Estacion>> retornoAux= obtenerRutas(caminos.get(j));
    		
    		if(distanciaMinima==null) {
    			distanciaMinima = distanciaMinimaAux;
    			retorno=retornoAux;
    			
    		}else if(distanciaMinima > distanciaMinimaAux){
    		
    			distanciaMinima = distanciaMinimaAux;
    			retorno=retornoAux;
    		}else if(distanciaMinima == distanciaMinimaAux){
    			retorno=retornoAux;
    		}
    		
    	}
    	
		return retorno;
	}

	private Double distanciaCamino(List<Vertice<Estacion>> list) {
		Double distanciaMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstaciones(list.get(i-1), list.get(i));
				if(distanciaMinima==null) {
					distanciaMinima=ruta.getDistancia();
				}else {
					distanciaMinima=distanciaMinima + ruta.getDistancia();
				}
			}
		}
		
		return distanciaMinima;
	}

	
	
	
	public List<Ruta<Estacion>> caminoMinimoDuracion(Estacion Origen,Estacion Destino){
		List<Ruta<Estacion>> retorno = this.caminoMinimoDuracion(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
		return retorno;
	}
	public List<Ruta<Estacion>> caminoMinimoDuracion(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
		
		List<Ruta<Estacion>> retorno = new ArrayList<>();
		
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> caminos = getRecorridos(listaAdyOrigen,Origen, Destino);
    	
    	Double duracionMinima=null;
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Estacion>> c = caminos.get(j);
    		Double duracionMinimaAux = duracionCamino(caminos.get(j));
    		List<Ruta<Estacion>> retornoAux = obtenerRutas(caminos.get(j));
    		
    		if(duracionMinima==null) {
    			duracionMinima = duracionMinimaAux;
    			retorno=retornoAux;
    			
    		}else if(duracionMinima > duracionMinimaAux){
    			duracionMinima = duracionMinimaAux;
    		retorno=retornoAux;
    		}
    	
    	}
		
		return retorno;
	}
	
	private Double duracionCamino(List<Vertice<Estacion>> list) {
		
		Double duracionMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstaciones(list.get(i-1), list.get(i));
				if(duracionMinima==null) {
					duracionMinima=ruta.getDuracionRecorrido();
				}
			
			}
		}
		
		return duracionMinima;
	}


	public List<Ruta<Estacion>> caminoMinimoCosto(Estacion Origen,Estacion Destino){
		List<Ruta<Estacion>> retorno = this.caminoMinimoCosto(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
		return retorno;
	}
	public List<Ruta<Estacion>> caminoMinimoCosto(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
		
		List<Ruta<Estacion>> retorno = new ArrayList<>();
		
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> caminos = getRecorridos(listaAdyOrigen,Origen, Destino);
    	
    	Double costoMinimo=null;
    	for(int j=0;j<caminos.size();j++) {
    		
    	
    		Double costoMinimoAux = costoCamino(caminos.get(j));
    		List<Ruta<Estacion>> retornoAux= obtenerRutas(caminos.get(j));
    				
    	
    		
    		if(costoMinimo==null) {
    			costoMinimo = costoMinimoAux;
    			retorno=retornoAux;
    			
    			
    		}else if(costoMinimo > costoMinimoAux){
    			costoMinimo = costoMinimoAux;
    			retorno=retornoAux;
    			
    		}
    		
    		
    	}
		
		return retorno;
	}
private Double costoCamino(List<Vertice<Estacion>> list) {
		
		Double costo=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstaciones(list.get(i-1), list.get(i));
				if(costo==null) {
					costo=ruta.getCosto();
				}else {
					costo=costo + ruta.getCosto();
				}
			}
		}
		
		return costo;
	}


public Double costoCaminoRutas(List<Ruta<Estacion>> lista) {
	
	Double costo= 0.0;
	for(int i = 0; i<lista.size(); i++) {
		costo=costo+lista.get(i).getCosto();
	}
	

	return costo;
	
}
public Double distanciaCaminoRutas(List<Ruta<Estacion>> lista) {
	
	Double distancia= 0.0;
	for(int i = 0; i<lista.size(); i++) {
		distancia=distancia+lista.get(i).getDistancia();
	}
	

	return distancia;
	
}

public Double duracionCaminoRutas(List<Ruta<Estacion>> lista) {
	
	Double duracion= 0.0;
	for(int i = 0; i<lista.size(); i++) {
		duracion=duracion+lista.get(i).getDuracionDelViaje();
	}
	

	return duracion;
	
}
	
	
	
	public  List<Ruta<Estacion>> obtenerRutas(List<Vertice<Estacion>> lista){
	
		List<Ruta<Estacion>> rutas2= new ArrayList<>();
		
		for(int i = 0; i<lista.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstaciones(lista.get(i-1), lista.get(i));
			    
				
				rutas2.add(ruta);
			}
		}
		
		return rutas2;
	}
	
	
	



	public int getPageRank(Estacion nodo){
		return this.getPageRank(new Vertice<Estacion>(nodo));
	}
	
	public int getPageRank(Vertice<Estacion> v) {
		Integer pageRank = 0;

		for (Ruta r : rutas) {
			if (r.getDestino().equals(v) ) {
				pageRank++;
			}
		}

		return pageRank;
	}

	public ArrayList<EstacionDTO> getEstacionPagerank() {
		ArrayList<EstacionDTO> listaRetorno = new ArrayList<EstacionDTO>();
		
		for(Vertice<Estacion> v : vertices) {
			
			EstacionDTO Estacion = new EstacionDTO(0, ((dominio.Estacion) v.getValor()).getNombre(),
					null, null, null);
			
			Estacion.setValorPagerank(getPageRank(v));
			
			listaRetorno.add(Estacion);
			
		}
		
		return listaRetorno;
	}
	
	public ArrayList<Estacion> getEstacions(){
		
		ArrayList<Estacion> Estacions = new ArrayList<>();
		
		for(Vertice<Estacion> v : this.vertices) {
			
			Estacions.add(v.getValor());
			
		}
		
		return Estacions;
		
	}    
	
	
	
	
}