package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AccesoBDD;

public class Probando123 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		
		AccesoBDD conexion=AccesoBDD.getInstance();
		Connection con=null;
		con=AccesoBDD.getConn();
		Statement sentencia;
		
	
		sentencia = con.createStatement();
		sentencia.executeUpdate("INSERT INTO cliente(id,nombre,correo)"
					+ "VALUES (1,'elia','daisbid@homiafa')"); 

	
	

	
		
		
	}

}
