package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Estacion;
import dominio.LineaTransporte;
import dto.LineaTransporteDTO;
import enums.EstadoRuta;
import estructuras.Ruta;
import gestores.GestorRuta;

public class LineaTransporteDAO {

	public static void guardarLineaTransporte(LineaTransporteDTO linea) {

		Connection con = AccesoBDD.getConn();
		String consulta = null;
		System.out.println("ojo el try");
		try {

			if (linea.getIdLinea() == 0) {

				linea.setIdLinea(obtenerId());
				consulta = "insert into lineatransporte(idLinea,nombre,color,estadoLinea) " + "values ("
						+ linea.getIdLinea() + ",'" + linea.getNombre() + "','" + linea.getColor() + "','"
						+ linea.getEstadoLinea() + "')";

			} else {
				consulta = "update lineatransporte set nombre='" + linea.getNombre() + "',color='" + linea.getColor()
						+ "',estadoLinea='" + linea.getEstadoLinea() + "'" + " WHERE idLinea=" + linea.getIdLinea()
						+ ";";
			}
	
			if(linea.getEstadoLinea().equals("Activa")) {
				for(Ruta<Estacion> r: RutaDAO.obtenerRutasPorIdLinea(linea.getIdLinea())) {
					if(r.getEstado().equals(EstadoRuta.NoActiva)) {
						r.setEstado(EstadoRuta.Activa);
						RutaDAO.guardarRuta(GestorRuta.obtenerDTO(r));
					}
					
				}
			}
			else {
       for(Ruta<Estacion> r: RutaDAO.obtenerRutasPorIdLinea(linea.getIdLinea())) {
					if(r.getEstado().equals(EstadoRuta.Activa)) {
						r.setEstado(EstadoRuta.NoActiva);
						RutaDAO.guardarRuta(GestorRuta.obtenerDTO(r));
					}
				}
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
	
	public static int getIdLineaTransporte(String nombreLinea) {
		
		Connection con = AccesoBDD.getConn();
		ResultSet tablaEstacion=null;
		Integer id=null;
		String consulta = "select idLinea from lineatransporte where nombre ='"+nombreLinea+"'";
		Statement st;
		
		try {
			st = con.createStatement();
			tablaEstacion = st.executeQuery(consulta);
			
			while(tablaEstacion.next()) {
				id=tablaEstacion.getInt("idLinea");
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static ArrayList<LineaTransporte> obtenerLineasTransporte() {

		Connection con = AccesoBDD.getConn();
		ResultSet rs = null;
		ArrayList<LineaTransporte> lineas = new ArrayList<>();
		String consulta = "select * from lineatransporte";
		Statement st;

		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {

				LineaTransporte l = new LineaTransporte(rs.getInt("idLinea"), rs.getString("nombre"),
						rs.getString("color"), null, null);
				if (rs.getString("estadoLinea").equals("Activa")) {

					l.setEstadolinea(EstadoRuta.Activa);
				} else {
					l.setEstadolinea(EstadoRuta.NoActiva);
				}

				l.setTrayectoria(RutaDAO.obtenerRutasPorIdLinea(l.getIdLinea()));
				lineas.add(l);
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
			String consulta = "delete from lineatransporte where idLinea = " + idLinea;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);

			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	public static int obtenerId() {

		Connection con = AccesoBDD.getConn();
		String consulta = "SELECT max(idLinea) from lineatransporte";
		Statement st;
		int id = 0;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			while (rs.next()) {
				id = rs.getInt("max(idLinea)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (id + 1);
	}

	public static LineaTransporte obtenerLineaPorID(Integer idLinea) {

		Connection con = AccesoBDD.getConn();
		ResultSet rs = null;
		String consulta = "select * from lineatransporte where idLinea=" + idLinea;
		LineaTransporte l = null;
		Statement st;

		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				l = new LineaTransporte(rs.getInt("idLinea"), rs.getString("nombre"), rs.getString("color"), null,
						null);
				if (rs.getString("estadoLinea").equals("Activa")) {
					l.setEstadolinea(EstadoRuta.Activa);
				} else {
					l.setEstadolinea(EstadoRuta.NoActiva);
				}
			}

			st.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
}
