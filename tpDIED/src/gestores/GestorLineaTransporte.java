package gestores;

import java.util.ArrayList;
import java.util.List;

import dao.EstacionDAO;
import dao.LineaTransporteDAO;
import dao.RutaDAO;
import dominio.Estacion;
import dominio.LineaTransporte;
import dto.EstacionDTO;
import dto.LineaTransporteDTO;
import dto.RutaDTO;
import estructuras.Ruta;
import estructuras.Vertice;

public class GestorLineaTransporte {

	public static void altaLineaTransporte(LineaTransporte l) {

		LineaTransporteDAO.guardarLineaTransporte(
				new LineaTransporteDTO(l.getIdLinea(), l.getNombre(), l.getColor(), l.getEstadolinea().toString()));
	}

	public static void editarLineaTransporte(LineaTransporte l) {

		LineaTransporteDAO.guardarLineaTransporte(crearDTO(l));

	}
	
	public static void eliminarLineaTransporte(LineaTransporteDTO lineaTransporteDTO) {
		LineaTransporteDAO.eliminarLineaTransporteByID(lineaTransporteDTO.getIdLinea());
		
		
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
	
	
	
	
    public static ArrayList<LineaTransporte> buscarTodasLasLineasTrasporte(){
		
		return LineaTransporteDAO.obtenerLineasTransporte();
	}
	
	
	
    public static int obtenerIdLineaTransporte(String nombreL) {
		return LineaTransporteDAO.getIdLineaTransporte(nombreL);
	}
    public static LineaTransporte obtenerLineaTransportePorId(Integer id) {
		return LineaTransporteDAO.obtenerLineaPorID(id);
	}
	
	
	

	public static LineaTransporteDTO crearDTO(LineaTransporte l) {
		return new LineaTransporteDTO(l.getIdLinea(), l.getNombre(), l.getColor(), l.getEstadolinea().toString());
	}
	
	public static ArrayList<LineaTransporteDTO> buscarlineast(String nombre,String estado,
			String color,String id,ArrayList<Integer> trayecto){
		ArrayList<LineaTransporte> lineas=LineaTransporteDAO.obtenerLineasTransporte();

		
		int tam=lineas.size();
		if(nombre!="all") {
			for(int i=0; i<tam;i++) {
				
				if(lineas.get(i).getNombre().toLowerCase().compareTo(nombre)!=0) {
					
					lineas.remove(i);
					i--;
					tam=lineas.size();
				}	
			}
			}
		if(estado!="all") {
			for(int i=0; i<tam;i++) {
				
				if(lineas.get(i).getEstadolinea().toString().compareTo(estado)!=0) {
					lineas.remove(i);
					i--;
					tam=lineas.size();
				}	
			}
			}
		if(color!="all") {
			for(int i=0; i<tam;i++) {
				
				if(lineas.get(i).getColor().toLowerCase().compareTo(color)!=0) {
					lineas.remove(i);
					i--;
					tam=lineas.size();
				}	
			}
			}
		
		if(id!="all") {
			for(int i=0; i<tam;i++) {
				
				if(lineas.get(i).getIdLinea()!=Integer.parseInt(id)) {
					lineas.remove(i);
					i--;
					tam=lineas.size();
				}	
			}
			}
		
		if(trayecto.size()>0) {
			
			ArrayList<Ruta> subTrayecto = new ArrayList<>();
			for(int i=0;i<trayecto.size()-1;i++) {
				 
				Ruta r=new Ruta<Estacion>(new Vertice<Estacion>(EstacionDAO.buscarEstacionPorId(trayecto.get(i)))
						, new Vertice<Estacion>(EstacionDAO.buscarEstacionPorId(trayecto.get(i+1))));
				r.setIdRuta(-1);
				System.out.println(r);
				
				subTrayecto.add(r);
				
			}
			
      for(int i=0; i<tam;i++) {
				
				if(!contiene(lineas.get(i).getTrayectoria(), subTrayecto)) {
					lineas.remove(i);
					i--;
					tam=lineas.size();
					
				}	
			}
				
			
			
		}
		
		
		
		
		return GestorLineaTransporte.obtenerlineasDTO(lineas);
	}
	
	
	public static Boolean contiene(List<Ruta<Estacion>> list,ArrayList<Ruta> segundo) {
		
		Boolean contiene=false;
		
		
		int i;
		int j = -1;
		for( i=0;i<list.size();i++) {
			
			if(list.get(i).equals(segundo.get(0))) {
				
				i++;
				for( j=1;j<segundo.size();j++) {
					
					if(!list.get(i).equals(segundo.get(j))) {
					break;	
					}
					else {
						i++;}	}		
			}		
		}
		if( j==segundo.size()) {contiene=true;}
		
		
		return contiene;
	}
	
	
	
	
	
	

	public static ArrayList<LineaTransporteDTO> obtenerlineasDTO(ArrayList<LineaTransporte> lineas){
		ArrayList<LineaTransporteDTO> lineasDTO=new ArrayList<LineaTransporteDTO>();
		
		for(LineaTransporte c:lineas) {
			LineaTransporteDTO dto=new LineaTransporteDTO();
			dto.setNombre(c.getNombre());
			dto.setEstado(c.getEstadolinea().toString());
			dto.setColor(c.getColor());
			dto.setIdLinea(c.getIdLinea());
			lineasDTO.add(dto);
		}
	
		
		return lineasDTO;
	}
	

	
	

}
