package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dominio.LineaTransporte;
import dominio.Mantenimiento;
import dto.BoletoDTO;
import dto.LineaTransporteDTO;

public class LineaTransporteDAO {
	
	public static void guardarLineaTransporte(LineaTransporteDTO linea) {
		
		
		
		Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
		try {
				consulta = "insert into lineatransporte(idLinea,nombre,color,estadoLinea) "
					+ "values ("+linea.getIdLinea() 
					+ ",'"+linea.getNombre()+"','"+linea.getColor()+"','"+
					linea.getEstadoLinea() +  "')";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			System.out.println("paso cabeza");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
public static ArrayList<LineaTransporte>  obtenerLineasTransporte() {
	
	Connection con = AccesoBDD.getConn();
	ResultSet rs=null;
	
	ArrayList<LineaTransporte> lineas= new ArrayList<>();
	
	String consulta = "select * from lineatransporte";
	

	Statement st;
	
	try {
		st = con.createStatement();
		rs = st.executeQuery(consulta);
		
		while(rs.next()) {
			
			
			lineas.add(new LineaTransporte(rs.getInt("idLinea"),
				       rs.getString("nombre"),
					rs.getString("color"),null,
					 null));
			
			
			
		}
		
		st.close();
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return lineas;
}



public static void eliminarLineaTransporteByID(Integer idLinea) {
	

		Connection con = AccesoBDD.getConn();
		
		try {
			String consulta = "delete from lineatransporte where idLinea = " + idLinea  ;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
}

	
	
	

	
	
}
