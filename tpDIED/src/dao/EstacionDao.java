package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Estacion;



public class EstacionDao {
	
	public static void EliminarEstacion(int idEstacion) {

		Connection con = AccesoBDD.getConn();
		
		try {
			String consulta = "delete from Estacion where id_Estacion = '" + idEstacion +"'" ;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
public static void AltaEstacion(Estacion estacion) {
		
	
		Connection con = AccesoBDD.getConn();
		String consulta = null;
		
		try {
				consulta = "insert into Estacion(nombre,tipo_Estacion) "
					+ "values ('"+estacion.getNombre()+"','"+estacion.getTipo().toString()+"')";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

public static ArrayList<Estacion> buscarTodasLasEstacions(){
	
//	Este metodo devuelve una lista con todas las Estacions que hay guardadas en la base de datos.
	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	
	ArrayList<Estacion> listaEstacion=new ArrayList<Estacion>();
	
	String consulta = "select * from Estacion";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
			Estacion Estacion = new Estacion(tablaEstacion.getInt("id_Estacion"),tablaEstacion.getString("nombre"), 
					TipoEstacion.valueOf(tablaEstacion.getString("tipo_Estacion")));
			
			
			
			
			listaEstacion.add(Estacion);		
		}
		
		for( Estacion p : listaEstacion) {
			p.setListaStock(DAOStock.getListaStockPorIdEstacion(p.getId()));
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaEstacion;
}

public static Estacion buscarEstacionPorId(int idEstacion) {
	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	
	Estacion Estacion=null;
	
	String consulta = "select * from Estacion where id_Estacion='"+idEstacion+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
			Estacion = new Estacion(tablaEstacion.getInt("id_Estacion"),tablaEstacion.getString("nombre"), 
					TipoEstacion.valueOf(tablaEstacion.getString("tipo_Estacion")));
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return Estacion;
}

public static boolean ExisteEstacion(String EstacionDestino) {

	
	Connection con = AccesoBDD.getConn();
	ResultSet Estacions=null;
	
	Estacion Estacion=null;
	
	String consulta = "select * from Estacion where nombre='"+EstacionDestino+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		Estacions = st.executeQuery(consulta);
		
		while(Estacions.next()) {
			Estacion = new Estacion(Estacions.getInt("id_Estacion"),Estacions.getString("nombre"), 
					TipoEstacion.valueOf(Estacions.getString("tipo_Estacion")));
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(Estacion == null) {
		return false;
	}else { 
		return true;
	}
}

public static int getIdEstacion(String EstacionDestino) {
	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	
	Estacion Estacion=null;
	
	String consulta = "select * from Estacion where nombre ='"+EstacionDestino+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
			Estacion = new Estacion(tablaEstacion.getInt("id_Estacion"),tablaEstacion.getString("nombre"), 
					TipoEstacion.valueOf(tablaEstacion.getString("tipo_Estacion")));
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return Estacion.getId();
}

public static Object[] obtenerEstacions() {

	ArrayList<Estacion> Estacions = new ArrayList<>();
	ResultSet rs = null;
	Connection con = AccesoBDD.getConn();

	try {

		PreparedStatement st = con.prepareStatement("select * from `Estacion`");
		rs = st.executeQuery();
		while(rs.next()) {

			Estacion Estacion = new Estacion(rs.getInt(1), rs.getString(2), TipoEstacion.valueOf(rs.getString(3)));
			Estacions.add(Estacion);
		}
		st.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Estacions.toArray();


}

public static String getNombreEstacion (int idEstacion) { 
	
	String nombreEstacion = null;
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	String consulta = "select * from Estacion where id_Estacion='"+idEstacion+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
			
			nombreEstacion = tablaEstacion.getString("nombre");
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return nombreEstacion;
	
}



}