package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dominio.Boleto;
import dto.BoletoDTO;
import dto.RutaDTO;

public class BoletoDAO {
	
	
	public static void guardarBoleto(BoletoDTO boleto) {
		
		Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
		try {
			
			boleto.setIdBoleto(obtenerId());
			
				consulta = "insert into boleto(idBoleto,idCliente,fechaVenta,idOrigen,idDestino,costoBol) "
					+ "values ("+boleto.getIdBoleto() 
					+ ","+boleto.getIdCliente()+",'"+boleto.getFechaVenta()+"',"
					+boleto.getIdOrigen()+","+boleto.getIdDestino()+","+boleto.getCostoBol()+  ")";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			guardarRutaBoleto(boleto.getRuta(), boleto.getIdBoleto());
			
			st.close();
			con.close();
			System.out.println("paso cabeza");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
public static ArrayList<Boleto>  obtenerBoletos( ) {
		
		Connection con = AccesoBDD.getConn();
		ResultSet rs=null;
		
		ArrayList<Boleto> boletos= new ArrayList<>();
		
		String consulta = "select * from boleto";
		
		SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
		Statement st;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			while(rs.next()) {
				boletos.add(new Boleto(rs.getInt("idBoleto"), ClienteDAO.obtenerClienteByID(rs.getInt("idCliente"))	
						, (formato.parse(rs.getString("fechaVenta")).toInstant())
						, EstacionDAO.buscarEstacionPorId(rs.getInt("idOrigen"))
						, EstacionDAO.buscarEstacionPorId(rs.getInt("idDestino")), 
						null, rs.getDouble("costoBol")));
			}
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return boletos;
	}
   
   public static void guardarRutaBoleto(ArrayList<RutaDTO> rutas,Integer idBoleto) {
	
	   System.out.println(rutas.size());
	   Connection con = AccesoBDD.getConn();
		String consulta = null;
	System.out.println("ojo el try");
		try {
			
			for(RutaDTO r:rutas) {
				System.out.println("holis");
			
				consulta = "insert into boletoruta(idRuta,idBoleto) "
					+ "values ("+r.getIdRuta() 
					+ ","+idBoleto +")";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			}
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

}
   public static int obtenerId() {

		Connection con = AccesoBDD.getConn();
		String consulta = "SELECT max(idBoleto) from boleto";
		Statement st;
		int id = 0;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				id = rs.getInt("max(idBoleto)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (id + 1);
	}
}
