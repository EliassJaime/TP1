package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;

import dao.AccesoBDD;
import dao.BoletoDAO;
import dao.EstacionDAO;
import dao.LineaTransporteDAO;
import dao.RutaDAO;
import dto.BoletoDTO;
import dto.EstacionDTO;
import enums.EstadoEstacion;
import enums.EstadoRuta;
import estructuras.Grafo;
import estructuras.Vertice;
import gestores.GestorBoletos;
import gestores.GestorEstacion;
import gestores.GestorLineaTransporte;

public class Probando123 {

	public static void main(String[] args) throws SQLException {

		
	/*	System.out.println(Grafo.getInstance().caminoMinimoCosto
				(new Vertice<>(EstacionDAO.buscarEstacionPorId(1)), new Vertice<>(EstacionDAO.buscarEstacionPorId(5))));
		*/
		Vertice<Estacion> v= new Vertice<>(EstacionDAO.buscarEstacionPorId(1));
		System.out.println(Grafo.getInstance().getAdyacentes(v));
		
	}
	




}
