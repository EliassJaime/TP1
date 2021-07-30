package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
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
		
		LineaTransporte dtoLinea = new LineaTransporte(0, "Nose", "Rojo", EstadoRuta.Activa, null);
		GestorLineaTransporte.crearDTO(dtoLinea);
		GestorLineaTransporte.altaLineaTransporte(dtoLinea);
		
		RutaDTO dto = new RutaDTO(0, 2,2, 3, 10.0, 12.0,
				30,"Activa", 8.0);
		
		GestorRuta.guardarRuta(dto);

	//GestorBoletos.guardarBoleto((GestorBoletos.generarBoletoRutaMenosTiempo(3, 5, 1)));
		
	
	}
	




}
