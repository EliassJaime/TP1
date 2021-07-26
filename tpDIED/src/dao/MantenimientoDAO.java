package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dominio.Boleto;
import dominio.Mantenimiento;
import dto.BoletoDTO;
import dto.MantenimientoDTO;

public class MantenimientoDAO {
	
public static void guardarMantenimiento(MantenimientoDTO mantenimiento) {
		
		
		
		Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
		try {
			
    mantenimiento.setIdMantenimiento(obtenerId());			
			
				consulta = "insert into mantenimiento(idMantenimiento,idEstacion,fechaInicio,fechaFin,observaciones) "
					+ "values ("+mantenimiento.getIdMantenimiento() 
					+ ","+mantenimiento.getIdEstacion()+",'"+mantenimiento.getFechaInicio()+"','"
					+mantenimiento.getFechaFin()+"','"+mantenimiento.getObservaciones()+"')";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			System.out.println("paso cabeza");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

	
public static ArrayList<Mantenimiento>  obtenerMantenimientosByIdEstacion(Integer idEstacion ) {
		
		Connection con = AccesoBDD.getConn();
		ResultSet rs=null;
		
		ArrayList<Mantenimiento> mantenimientos= new ArrayList<>();
		
		String consulta = "select * from mantenimiento where idEstacion="+idEstacion;
		
		SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
		Statement st;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				
				
				mantenimientos.add(new Mantenimiento(rs.getInt("idMantenimiento"),
						null,
						(formato.parse(rs.getString("fechaInicio")).toInstant())
						, (formato.parse(rs.getString("fechaFin")).toInstant())
						, rs.getString("observaciones")));
				
				
				
			}
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return mantenimientos;
	}
	
public static ArrayList<Mantenimiento>  obtenerMantenimientos() {
	
	Connection con = AccesoBDD.getConn();
	ResultSet rs=null;
	
	ArrayList<Mantenimiento> mantenimientos= new ArrayList<>();
	
	String consulta = "select * from mantenimiento";
	
	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
	Statement st;
	
	try {
		st = con.createStatement();
		rs = st.executeQuery(consulta);
		
		while(rs.next()) {
			
			
			mantenimientos.add(new Mantenimiento(rs.getInt("idMantenimiento"),
					EstacionDAO.buscarEstacionPorId(rs.getInt("idEstacion")),
					(formato.parse(rs.getString("fechaInicio")).toInstant())
					, (formato.parse(rs.getString("fechaFin")).toInstant())
					, rs.getString("observaciones")));
			
			
			
		}
		
		st.close();
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return mantenimientos;
}



public static int obtenerId() {
	
	
	
	Connection con = AccesoBDD.getConn();
	String consulta = "SELECT max(idMantenimiento) from mantenimiento";
	
	Statement st;

	int id=0;
	ResultSet rs;
	
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while(rs.next()) {
				id=rs.getInt("max(idMantenimiento)");
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
return (id+1);	
}

	
	
	

}
