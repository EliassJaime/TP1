package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoBDD {
	private static final String URL = "jdbc:mysql://localhost:3306/tpdied";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private static Connection conn;
	
	private static AccesoBDD DBM;
	
	private AccesoBDD() {
		AccesoBDD.conn = AccesoBDD.getConn();
		
	}
	
	public static AccesoBDD getInstance() { 
		if ( DBM == null) {
			DBM = new AccesoBDD();
		}
		
		try {
			
			if (conn.isClosed()) {
				
				conn = getConn();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DBM;
	}
	

//	public static Connection getConn() {
//		return conn;
//	}

	public static Connection getConn(){
	    try{
	    	Class.forName("com.mysql.jdbc.Connection");
	        return DriverManager.getConnection(URL, USER, PASS);
	    }catch(Exception ex){
	        System.out.println(ex.getMessage());
	        System.out.println("couldn't connect!");
	        throw new RuntimeException(ex);
	    }
	}
//	private static Connection crearConexion() throws ClassNotFoundException, SQLException{
//
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
//		if (conexion != null){
//			System.out.print("Conexion establecida...");
//			return conexion;
//
//		}
//		return null;
//
//	}

}