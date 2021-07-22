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
import gestores.GestorEstaciones;
import gestores.GestorRuta;




public class Grafo<Estacion> {
	
	private static Grafo GRAFO;
	
	private List<Ruta<Estacion>> rutas;
	private List<Vertice<Estacion>> vertices;

	
	 public Grafo(List<Ruta<Estacion>> rutas, List<Vertice<Estacion>> vertices) {
		// TODO Auto-generated constructor stub
		 this.rutas=rutas;
		 this.vertices=vertices;
	}
	
	public  static Grafo getInstance() {
		 
		 if (GRAFO==null) {
			 
			 ArrayList<Vertice<dominio.Estacion>> listaVertices = new ArrayList<Vertice<dominio.Estacion>>();
			 ArrayList<dominio.Estacion> Estaciones = GestorEstaciones.buscarTodasLasEstacions();
			 
			 for(dominio.Estacion p : Estaciones) 
				 
				 listaVertices.add(new Vertice<dominio.Estacion>(p));
			 
			 GRAFO = new Grafo(GestorRuta.buscarTodasLasRutas(), listaVertices);
		 }
		 return GRAFO;
	}
	
	
	public Grafo(){
		this.rutas = new ArrayList<Ruta<Estacion>>();
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
	
	public void conectar(Estacion n1,Estacion n2){
		this.conectar(getNodo(n1), getNodo(n2), 1.0, 1.0, 1.0);
	}

	public void conectar(Estacion n1,Estacion n2,double distancia, double duracionRecorrido, double CantidadMaxPasajeros){
		this.conectar(getNodo(n1), getNodo(n2), distancia, duracionRecorrido, CantidadMaxPasajeros);
	}

	private void conectar(Vertice<Estacion> nodo1,Vertice<Estacion> nodo2, double distancia, double duracionRecorrido, double CantidadMaxPasajeros){
		this.rutas.add(new Ruta<Estacion>(nodo1,nodo2, distancia, duracionRecorrido, CantidadMaxPasajeros));
	}
	
	public Vertice<Estacion> getNodo(Estacion valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<Estacion>(valor)));
	}
	
	public Vertice<Estacion> getNodo(int idEstacion){
		Vertice<Estacion> vert = new Vertice<Estacion>();
		for(Vertice<Estacion> v : vertices) {
			if(idEstacion == ((dominio.Estacion) v.getValor()).getId())
				return v;
		}
		return null;
	}

	public List<Estacion> getAdyacentes(Estacion valor){ 
		Vertice<Estacion> unNodo = this.getNodo(valor);
		List<Estacion> salida = new ArrayList<Estacion>();
		for(Ruta<Estacion> enlace : this.rutas){
			if( enlace.getOrigen().equals(unNodo)){
				salida.add(enlace.getDestino().getValor());
			}
		}
		return salida;
	}
	

	public List<Vertice<Estacion>> getAdyacentes(Vertice<Estacion> unNodo){  //funciona
		List<Vertice<Estacion>> salida = new ArrayList<Vertice<Estacion>>();
		for(Ruta<Estacion> enlace : this.rutas){
			if( enlace.getOrigen().equals(unNodo)){
				salida.add(enlace.getDestino());
			}
		}
		return salida; 
	}
	
	
	public void imprimirRutas(){
		System.out.println(this.rutas.toString());
	}

	public Integer gradoEntrada(Vertice<Estacion> vertice){
		Integer res =0;
		for(Ruta<Estacion> arista : this.rutas){
			if(arista.getDestino().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<Estacion> vertice){
		Integer res =0;
		for(Ruta<Estacion> arista : this.rutas){
			if(arista.getOrigen().equals(vertice)) ++res;
		}
		return res;
	}
	public List<Estacion> recorridoAnchura(Vertice<Estacion> Origen){
		List<Estacion> resultado = new ArrayList<Estacion>();
		
		//estructuras auxiliares
		Queue<Vertice<Estacion>> pendientes = new LinkedList<Vertice<Estacion>>();
		HashSet<Vertice<Estacion>> marcados = new HashSet<Vertice<Estacion>>();
		marcados.add(Origen);
		pendientes.add(Origen);
		
		while(!pendientes.isEmpty()){
			Vertice<Estacion> actual = pendientes.poll();
			List<Vertice<Estacion>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<Estacion> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<Estacion> recorridoProfundidad(Vertice<Estacion> Origen){
		List<Estacion> resultado = new ArrayList<Estacion>();
		Stack<Vertice<Estacion>> pendientes = new Stack<Vertice<Estacion>>();
		HashSet<Vertice<Estacion>> marcados = new HashSet<Vertice<Estacion>>();
		marcados.add(Origen);
		pendientes.push(Origen);
		
		while(!pendientes.isEmpty()){
			Vertice<Estacion> actual = pendientes.pop();
			List<Vertice<Estacion>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<Estacion> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<Estacion> recorridoTopologico(){
		List<Estacion> resultado = new ArrayList<Estacion>();
		Map<Vertice<Estacion>,Integer> gradosVertice = new HashMap<Vertice<Estacion>,Integer>();
		for(Vertice<Estacion> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
		
			List<Vertice<Estacion>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertice<Estacion> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<Estacion> ady: this.getAdyacentes(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
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
		 ArrayList<Estacion> Estacions = (ArrayList<Estacion>) GestorEstaciones.buscarTodasLasEstacions();
		 
		 for(Estacion p : Estacions) 
			 
			 listaVertices.add(new Vertice<Estacion>(p));
		 
		 GRAFO = new Grafo(GestorRuta.buscarTodasLasRutas(), listaVertices);
    }
    
    
    public ArrayList<Double> flujoMaximoValor(Estacion Origen, Estacion Destino) {
    	ArrayList<Double> retorno = new ArrayList<Double>();
    	List<List<String>> recorridos = flujoMaximo( Origen, Destino);
    	
    	for(List<String> ls : recorridos) {
    		retorno.add(Double.parseDouble(ls.subList(ls.size()-1, ls.size()).get(0)));
    	}
    	
    	return retorno;
    }
    
    public List<List<String>> flujoMaximo (Estacion Origen, Estacion Destino){
    return this.flujoMaximo(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
    }
    
    public List<List<String>> flujoMaximo (Vertice<Estacion> Origen, Vertice<Estacion> Destino){
    	//va a devolver los nombres de la ruta y el �ltimo elemento va a ser el flujo m�ximo 
    	
    	List<List<String>> retorno = new ArrayList<List<String>>();
    	
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> recorridos = getRecorridos(listaAdyOrigen,Origen, Destino); 

    		
    		for(int i = 0; i<recorridos.size();i++) {
    				
    				List<String> recorridoString = new ArrayList<String>();
    				List<Vertice<Estacion>> recorrido = recorridos.get(i);
    				
    				for(int j = 0; j<recorrido.size();j++){
    					
    					if(j!= 0) {
    						Ruta ruta= rutaEntreDosEstacions(recorrido.get(j-1), recorrido.get(j));
    					
    						if(recorridoString.size() == 1) {
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getCantidadMaxPasajeros()));
    						}else if(Double.parseDouble(recorridoString.get(recorridoString.size()-1)) > ruta.getCantidadMaxPasajeros()) {
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getCantidadMaxPasajeros()));
    						}else {
    							String pesoMax = recorridoString.get(recorridoString.size()-1);
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(pesoMax);
    						}
    					}else {
    						recorridoString.add(((dominio.Estacion) recorrido.get(j).getValor()).getNombre());
    					}
    				}
    				retorno.add(recorridoString);
    			}    	
    	
    	return retorno;
    	
    }
    
    
    private List<List<Vertice<Estacion>>> getRecorridos(List<Vertice<Estacion>> listaAdy, Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	List<List<Vertice<Estacion>>> retorno = new ArrayList<List<Vertice<Estacion>>>();
    	
    	if(!listaAdy.isEmpty()) {
    		
    		for (Vertice<Estacion> v : listaAdy) {
    		
    			if(v.equals(Destino)) {
    				
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

	public Ruta rutaEntreDosEstacions(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
    	for (Ruta r : this.rutas) {
    		if (r.getOrigen().equals(Origen) && r.getDestino().equals(Destino)) return r;
    	}
		return null;
    }
	
	public List<List<String>> caminoMinimoDistancia(Estacion Origen,Estacion Destino){
		List<List<String>> retorno = this.caminoMinimoDistancia(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
		
		return retorno;
	}
	
	
	public List<List<String>> caminoMinimoDistancia(Vertice<Estacion> Origen,Vertice<Estacion> Destino) {
		List<List<String>> retorno = new ArrayList<List<String>>();
		
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> caminos = getRecorridos(listaAdyOrigen,Origen, Destino);
    	
    	Double distanciaMinima=null;
    	
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Estacion>> c = caminos.get(j);
    		Double distanciaMinimaAux = distanciaCamino(caminos.get(j));
    		List<String> caminoString = new ArrayList<String>();
    		
    		if(distanciaMinima==null) {
    			distanciaMinima = distanciaMinimaAux;
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(distanciaMinima.toString());
    			retorno.add(caminoString);
    			
    		}else if(distanciaMinima > distanciaMinimaAux){
    			retorno.clear();
    			distanciaMinima = distanciaMinimaAux;
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(distanciaMinima.toString());
    			retorno.add(caminoString);
    		}else if(distanciaMinima == distanciaMinimaAux){
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(distanciaMinima.toString());
    			retorno.add(caminoString);
    		} else if(distanciaMinima < distanciaMinimaAux) {
    			
    		}
    		
    	}
    	
		return retorno;
	}

	public List<List<String>> caminoMinimoDuracion(Estacion Origen,Estacion Destino){
		List<List<String>> retorno = this.caminoMinimoDuracion(new Vertice<Estacion>(Origen), new Vertice<Estacion>(Destino));
		return retorno;
	}
	public List<List<String>> caminoMinimoDuracion(Vertice<Estacion> Origen, Vertice<Estacion> Destino) {
		
		List<List<String>> retorno = new ArrayList<List<String>>();
		
    	List<Vertice<Estacion>> listaAdyOrigen =  this.getAdyacentes(Origen); 
    	
    	List<List<Vertice<Estacion>>> caminos = getRecorridos(listaAdyOrigen,Origen, Destino);
    	
    	Double duracionMinima=null;
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Estacion>> c = caminos.get(j);
    		Double duracionMinimaAux = duracionCamino(caminos.get(j));
    		List<String> caminoString = new ArrayList<String>();
    		
    		if(duracionMinima==null) {
    			duracionMinima = duracionMinimaAux;
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(duracionMinima.toString());
    			retorno.add(caminoString);
    			
    		}else if(duracionMinima > duracionMinimaAux){
    			duracionMinima = duracionMinimaAux;
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(duracionMinima.toString());
    			retorno.clear();
    			retorno.add(caminoString);
    		}else if(duracionMinima == duracionMinimaAux){
    			caminoString.addAll(listaNombresEstacions(c));
    			caminoString.add(duracionMinima.toString());
    			retorno.add(caminoString);
    		}
    		
    	}
		
		return retorno;
	}

	public List<String> listaNombresEstacions(List<Vertice<Estacion>> listVertices) {
		List<String> ret = new ArrayList<String>();
		for(Vertice<Estacion> v : listVertices)
			ret.add(((dominio.Estacion) v.getValor()).getNombre());
		return ret;
	}

	private Double distanciaCamino(List<Vertice<Estacion>> list) {
		Double distanciaMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstacions(list.get(i-1), list.get(i));
				if(distanciaMinima==null) {
					distanciaMinima=ruta.getDistancia();
				}else {
					distanciaMinima=distanciaMinima + ruta.getDistancia();
				}
			}
		}
		
		return distanciaMinima;
	}
	
	private Double duracionCamino(List<Vertice<Estacion>> list) {
		
		Double duracionMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosEstacions(list.get(i-1), list.get(i));
				if(duracionMinima==null) {
					duracionMinima=ruta.getDuracionRecorrido();
				}else {
					duracionMinima=duracionMinima + ruta.getDuracionRecorrido();
				}
			}
		}
		
		return duracionMinima;
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
					((dominio.Estacion) v.getValor()).getTipo().toString());
			
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
	
	public double getDistanciaEntreEstacions(Vertice<Estacion> Origen,Vertice<Estacion> Destino) {
		return rutaEntreDosEstacions(Origen, Destino).getDistancia();
	}
	
	public double getDuracionEntreEstacions(Vertice<Estacion> Origen,Vertice<Estacion> Destino) {
		return rutaEntreDosEstacions(Origen, Destino).getDuracionRecorrido();
	}
	
	public List<Double> getValoresDistanciaConDemasVertices(Vertice<Estacion> vertice){
		
		List<Double> retorno = new ArrayList<Double>();
		
		for(Vertice<Estacion> v : vertices) {
			if(v.equals(vertice)) {
				retorno.add(0.0);
			}else {
				Ruta ruta = rutaEntreDosEstacions(vertice, v);
				if(ruta == null) {
					retorno.add(0.0);
				}else {
					retorno.add(ruta.getDistancia());
				}
				
			}
		}
		
		return retorno;
	}
	
	public List<Double> getValoresDuracionConDemasVertices(Vertice<Estacion> vertice){
		
		List<Double> retorno = new ArrayList<Double>();
		
		for(Vertice<Estacion> v : vertices) {
			if(v.equals(vertice)) {
				retorno.add(0.0);
			}else {
				Ruta ruta = rutaEntreDosEstacions(vertice, v);
				if(ruta == null) {
					retorno.add(0.0);
				}else {
					retorno.add(ruta.getDuracionRecorrido());
				}
				
			}
		}
		
		return retorno;
	}
}