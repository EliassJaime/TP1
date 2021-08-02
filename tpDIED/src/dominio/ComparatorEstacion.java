package dominio;

import java.util.Comparator;

public class ComparatorEstacion implements Comparator<Estacion> {

	@Override
	public int compare(Estacion o1, Estacion o2) {
		if(o1.getMantenimientos().size() ==0) {   
			
			if(o2.getMantenimientos().size() ==0) {   
				
				return 0;
			}
			else {return -1;}

		}
     if(o2.getMantenimientos().size() ==0) {   
			
			if(o1.getMantenimientos().size() ==0) {   
				
				return 0;
			}
			else {return 1;}

		}
		
		
		Mantenimiento m1=o1.getMantenimientos().get(o1.getMantenimientos().size()-1);
		
		Mantenimiento m2=o2.getMantenimientos().get(o2.getMantenimientos().size()-1);
	
		
		
		
		if(m1.getFechaFinMan().isAfter(m2.getFechaFinMan())) {
			
			return 1;
		}
		else if(m1.getFechaFinMan().isBefore(m2.getFechaFinMan())) {
			return -1;
			
		}
		else {
			
			return 0;
		}
		
		
		
	
	}
	
}
