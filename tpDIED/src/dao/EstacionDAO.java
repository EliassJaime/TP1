package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


import dominio.Estacion;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import enums.EstadoEstacion;

public class EstacionDAO {
	
	public static void EliminarEstacion(int idEstacion) {

		Connection con = AccesoBDD.getConn();
		
		try {
			String consulta = "delete from estacion where id = " + idEstacion  ;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
public static void guardarEstacion(EstacionDTO estacion) {
		
	
		Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
		try {
			
			
			
			if(estacion.getId()==0) {
				
				estacion.setId(obtenerIdEstacion());
				
				consulta = "insert into estacion(id,nombre,horarioApertura,horarioCierre,estado) "
					+ "values ("+estacion.getId()+",'"+estacion.getNombre()+"','"+estacion.getHorarioApertura()+"',"
							+ "'"+estacion.getHorarioCierre()+"',"+"'"+estacion.getEstado()+"')";

			}
			else {
				consulta= "update estacion set nombre='"+estacion.getNombre()+"',horarioApertura='"
			+estacion.getHorarioApertura()+"',horarioCierre='"+estacion.getHorarioCierre()+"',"
					+ "estado='"+estacion.getEstado()
			+"' WHERE id="+estacion.getId()+";";
				
			}
				
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			System.out.println("paso cabeza");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

public static ArrayList<Estacion> buscarTodasLasEstaciones(){
	

	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	
	ArrayList<Estacion> listaEstacion=new ArrayList<Estacion>();
	
	String consulta = "select * from estacion";

	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
	
		
		while(tablaEstacion.next()) {
			
		    
			
			
		
			
			listaEstacion.add(EstacionDAO.buscarEstacionPorId(tablaEstacion.getInt("id")));		
		}
		
		
		
		st.close();
		con.close();
		
	} catch (Exception ex) {
		// TODO Auto-genera202 catch block
		ex.printStackTrace();
	}
	
	return listaEstacion;
}

public static Estacion buscarEstacionPorId(int idEstacion) {
	
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	
	Estacion estacion=null;
	
	String consulta = "select * from estacion where id='"+idEstacion+"'";
	
	Statement st;

	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
	
		    
			
			 estacion = new Estacion(tablaEstacion.getInt("id")
					,tablaEstacion.getString("nombre"),tablaEstacion.getString("horarioApertura"),tablaEstacion.getString("horarioCierre")
					,null);
			 
			 if(tablaEstacion.getString("estado").equals("Operativo")) {
			 estacion.setEstado(EstadoEstacion.Operativo);}
			 else {
				 estacion.setEstado(EstadoEstacion.EnMantenimiento);}
				 
			 estacion.setMantenimientos(MantenimientoDAO.obtenerMantenimientosByIdEstacion(estacion.getId()));
			 
			 for(Mantenimiento m:estacion.getMantenimientos()) {
				 m.setEstacion(estacion);
				 
			 }
		}
		
		st.close();
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return estacion;
}

public static boolean ExisteEstacion(Integer idEstacion) {

	
	Connection con = AccesoBDD.getConn();
	ResultSet estaciones=null;
	Boolean existe=false;
	
	String consulta = "select * from estacion where nombre='"+idEstacion+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		estaciones = st.executeQuery(consulta);
		
		while(estaciones.next()) {
			existe=true;
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return existe;
}

public static int getIdEstacion(String nombreEstacion) {
	
	Connection con = AccesoBDD.getConn();
	
	ResultSet tablaEstacion=null;
	
	Integer id=null;
	
	String consulta = "select id from estacion where nombre ='"+nombreEstacion+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaEstacion = st.executeQuery(consulta);
		
		while(tablaEstacion.next()) {
			id=tablaEstacion.getInt("id");
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return id;
}



public static String getNombreEstacion (int idEstacion) { 
	
	String nombreEstacion = null;
	Connection con = AccesoBDD.getConn();
	ResultSet tablaEstacion=null;
	String consulta = "select nombre from estacion where id='"+idEstacion+"'";
	
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

public static int obtenerIdEstacion() {
	
	
	
	Connection con = AccesoBDD.getConn();
	String consulta = "SELECT max(id) from estacion";
	
	Statement st;

	int id=0;
	ResultSet rs;
	
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while(rs.next()) {
				id=rs.getInt("max(id)");
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
return (id+1);	
}



}