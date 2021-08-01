package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.AccesoBDD;
import dao.BoletoDAO;
import dao.EstacionDAO;
import dao.LineaTransporteDAO;
import dao.RutaDAO;
import dto.BoletoDTO;
import dto.EstacionDTO;
import dto.LineaTransporteDTO;
import dto.RutaDTO;
import enums.EstadoEstacion;
import enums.EstadoRuta;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;
import gestores.GestorBoletos;
import gestores.GestorEstacion;
import gestores.GestorLineaTransporte;
import gestores.GestorRuta;

public class Probando123 {

	public static void main(String[] args) throws SQLException {
		

		

		
		ArrayList<Integer> uno= new ArrayList<>();
		ArrayList<Integer> dos= new ArrayList<>();
		
		uno.add(1);
		uno.add(2);
		uno.add(3);
		uno.add(4);
		uno.add(5);

	
		dos.add(6);
		//System.out.println(GestorLineaTransporte.contiene(uno, dos));
		
	//GestorBoletos.guardarBoleto((GestorBoletos.generarBoletoRutaMenosTiempo(3, 5, 1)));
		
	
	}
	




}
