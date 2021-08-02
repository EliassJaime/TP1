package estructuras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.PriorityQueue;

import dao.EstacionDAO;
import dominio.ComparatorEstacion;
import dominio.Estacion;

public class MonticuloMantenimiento {
	
	PriorityQueue<Estacion> m = new PriorityQueue<>(new ComparatorEstacion());
	
	
	public static PriorityQueue<Estacion> devolverMonticulo() throws ParseException {
		
		PriorityQueue<Estacion> m = new PriorityQueue<>(new ComparatorEstacion());
	       
	

	 m.addAll(EstacionDAO.buscarTodasLasEstaciones());
	 
	 while(!m.isEmpty()) {
		 System.out.println(m.poll());
	 }
		
		
		return m;
		
		
	}

}
