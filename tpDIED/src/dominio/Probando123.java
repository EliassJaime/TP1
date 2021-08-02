package dominio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import dao.AccesoBDD;
import dao.BoletoDAO;
import dao.EstacionDAO;
import dao.LineaTransporteDAO;
import dao.MantenimientoDAO;
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
import gestores.GestorMantenimiento;
import gestores.GestorRuta;

public class Probando123 {

	public static void main(String[] args) throws SQLException, ParseException {
		

		PriorityQueue<Estacion> m = new PriorityQueue<>(new ComparatorEstacion());
       
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		
		Instant fechaInicio= f.parse("02/08/2022").toInstant();
		Instant fechaFin= f.parse("15/08/2022").toInstant();
		
		
		//Mantenimiento m1=new Mantenimiento(0, EstacionDAO.buscarEstacionPorId(8), fechaInicio, fechaFin, "todo correcto cabecita");
		
		//MantenimientoDAO.guardarMantenimiento(GestorMantenimiento.crearDTO(m1));
		
	 m.addAll(EstacionDAO.buscarTodasLasEstaciones());
	 
	 while(!m.isEmpty()) {
		 System.out.println(m.poll());
	 }
		
		
	
	
	}
	




}
