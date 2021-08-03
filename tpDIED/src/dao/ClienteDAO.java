package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import dominio.Cliente;
import dominio.Estacion;
import dto.ClienteDTO;
import dto.EstacionDTO;
import enums.EstadoEstacion;

public class ClienteDAO {
	public static void guardarCliente(ClienteDTO cliente) {
		
		
		Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
	
		try {
				consulta = "insert into cliente(id,nombre,correo) "
					+ "values ("+cliente.getId() 
					+ ",'"+cliente.getNombre()+"','"+cliente.getCorreo()+"')";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			System.out.println("paso cabeza");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	public static Cliente obtenerClienteByID(Integer idCliente) {
		
		Connection con = AccesoBDD.getConn();
		ResultSet rs=null;
		
		Cliente cliente=null;
		
		String consulta = "select * from cliente where id='"+idCliente+"'";
		
		Statement st;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			
			while(rs.next()) {
					
				 cliente = new Cliente(rs.getInt("id"),rs.getString("nombre"), rs.getString("correo"));
			}
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return cliente;
	}
	
	
	
	public static int obtenerId() {
		
		
		
		Connection con = AccesoBDD.getConn();
		String consulta = "SELECT max(id) from cliente";
		
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
