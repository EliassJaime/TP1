package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Estacion;
import dto.RutaDTO;
import enums.EstadoRuta;
import estructuras.Ruta;
import estructuras.Vertice;
import gestores.GestorEstacion;


public class RutaDAO {
	
	public static void EliminarRuta(int idRuta) {

		Connection con = AccesoBDD.getConn();
		
		try {
			String consulta = "delete from ruta where idRuta = '" + idRuta +"'" ;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
public static void guardarRuta(RutaDTO ruta) {
		
		
		Connection con = AccesoBDD.getConn();
		String consulta = null;
		
		try {
			System.out.println("Entro al try");
			if(ruta.getIdRuta()==0) {
				
				ruta.setIdRuta(obtenerId());
				
				consulta = "insert into RUTA(idRuta,idLineaTransporte,idOrigenE, idDestinoE, distancia,"
						+ " duracionDelViaje, cantidadMaxPasajeros,estado,costo) "
						+ "values ("+ruta.getIdRuta()+","+ruta.getIdLineaTransporte()+","+ruta.getIdOrigenE()+","+ ruta.getIdDestinoE()+","
						+ruta.getDistancia()+","+ruta.getDuracionDelViaje()+","
								+ruta.getCantidadMaxPasajeros()+",'"+ruta.getEstado()+ "',"+ruta.getCosto() +")" ;
			}
			else {
				consulta= "update ruta set distancia="+ruta.getDistancia()+",duracionDelViaje='"
						+ruta.getDuracionDelViaje()+",cantidadMaxPasajeros="+ruta.getCantidadMaxPasajeros()+
						
						",estado='" +ruta.getEstado() +"',costo=" +ruta.getCosto() 
								+ " WHERE idLinea="+ruta.getIdRuta()+";";
				
			}
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

public static ArrayList<Ruta<Estacion>> buscarTodasLasRutas(){
	

	
	Connection con = AccesoBDD.getConn();
	ResultSet rs=null;
	
	ArrayList<Ruta<Estacion>> listaRuta=new ArrayList<Ruta<Estacion>>();
	
	String consulta = "select * from ruta";
	
	Statement st;
	
	try {
		st = con.createStatement();
		rs = st.executeQuery(consulta);
		
		while(rs.next()) {
			
			Estacion estacionOrigen=GestorEstacion.getEstacionById(rs.getInt("idOrigenE"));
			Estacion estacionDestino=GestorEstacion.getEstacionById(rs.getInt("idDestinoE"));
			
			
			Ruta<Estacion> ruta = new Ruta<Estacion>(rs.getInt("idRuta"), new Vertice<Estacion>(estacionOrigen),  new Vertice<Estacion>(estacionDestino), rs.getDouble("distancia"), rs.getDouble("duracionDelViaje"), rs.getInt("cantidadMaxPasajeros")
					,null, rs.getDouble("costo"),  LineaTransporteDAO.obtenerLineaPorID(rs.getInt("idLineaTransporte")));
			
			if(rs.getString("estado").equals(EstadoRuta.Activa)) {
				ruta.setEstado(EstadoRuta.Activa);
				
			}
			else {
				ruta.setEstado(EstadoRuta.NoActiva);
				
			}
			
			listaRuta.add(ruta);		
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	return listaRuta;
}




public static int obtenerId() {
	
	
	
	Connection con = AccesoBDD.getConn();
	String consulta = "SELECT max(idRuta) from ruta";
	
	Statement st;

	int id=0;
	ResultSet rs;
	
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while(rs.next()) {
				id=rs.getInt("max(idRuta)");
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
return (id+1);	
}

public static ArrayList<Ruta<Estacion>> obtenerRutasPorIdLinea(Integer idLinea) {

	Connection con = AccesoBDD.getConn();
	ResultSet rs=null;
	
	ArrayList<Ruta<Estacion>> listaRuta=new ArrayList<Ruta<Estacion>>();
	
	String consulta = "select * from ruta where idLineaTransporte=" +idLinea;
	
	Statement st;
	
	try {
		st = con.createStatement();
		rs = st.executeQuery(consulta);
		
		while(rs.next()) {
			
			Estacion estacionOrigen=GestorEstacion.getEstacionById(rs.getInt("idOrigenE"));
			Estacion estacionDestino=GestorEstacion.getEstacionById(rs.getInt("idDestinoE"));
			
			
			Ruta<Estacion> ruta = new Ruta<Estacion>(rs.getInt("idRuta"), new Vertice<Estacion>(estacionOrigen),  new Vertice<Estacion>(estacionDestino), rs.getDouble("distancia"), rs.getDouble("duracionDelViaje"), rs.getInt("cantidadMaxPasajeros")
					,null, rs.getDouble("costo"),  LineaTransporteDAO.obtenerLineaPorID(rs.getInt("idLineaTransporte")));
			
			if(rs.getString("estado").equals(EstadoRuta.Activa)) {
				ruta.setEstado(EstadoRuta.Activa);
				
			}
			else {
				ruta.setEstado(EstadoRuta.NoActiva);
				
			}
			
			listaRuta.add(ruta);		
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	return listaRuta;
}


	
	

}