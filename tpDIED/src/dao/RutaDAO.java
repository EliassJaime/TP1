package dao;

import java.sql.*;
import java.util.ArrayList;

import dominio.Estacion;
import dto.RutaDTO;
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
				consulta = "insert into RUTA(idRuta,idOrigenE, idDestinoE, distancia,"
						+ " duracionDelViaje, cantidadMaxPasajeros) "
						+ "values ('"+ruta.getIdRuta()+ruta.getIdOrigenE()+"','"+ ruta.getIdDestinoE()+"',"
						+ "'"+ruta.getDistancia()+"','"+ruta.getDuracionDelViaje()+"','"
								+ruta.getCantidadMaxPasajeros()+ "')" ;

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

public static ArrayList<Ruta<Estacion>> buscarTodasLasRutas(){
	

	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaRuta=null;
	
	ArrayList<Ruta<Estacion>> listaRuta=new ArrayList<Ruta<Estacion>>();
	
	String consulta = "select * from ruta";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaRuta = st.executeQuery(consulta);
		
		while(tablaRuta.next()) {
			
			Estacion estacionOrigen=GestorEstacion.getEstacionById(tablaRuta.getInt("id_Estacion_origen"));
			Estacion estacionDestino=GestorEstacion.getEstacionById(tablaRuta.getInt("id_Estacion_destino"));
			
			Ruta<Estacion> ruta = new Ruta<Estacion>(new Vertice<Estacion>(estacionOrigen), new Vertice<Estacion>(estacionDestino), tablaRuta.getDouble("distancia"),
					tablaRuta.getDouble("duracion_recorrido"), tablaRuta.getDouble("peso_maximo"));
			listaRuta.add(ruta);		
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaRuta;
}

}