package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;

import dao.AccesoBDD;
import dao.BoletoDAO;
import dao.EstacionDAO;
import dto.BoletoDTO;
import dto.EstacionDTO;
import enums.EstadoEstacion;
import gestores.GestorEstacion;

public class Probando123 {

	public static void main(String[] args) throws SQLException {

		
		ArrayList<Estacion> e= EstacionDAO.buscarTodasLasEstaciones();
		System.out.println(e);
		
	}

}
