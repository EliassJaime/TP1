package dominio;

import java.time.Instant;
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
	
		Instant f1=m1.getFechaFinMan();
		Instant f2=m2.getFechaFinMan();
		
		if(f1==null) {
			f1 = Instant.now();
			
		}
		if(f2==null) {
			f2 = Instant.now();
			
		}
		
		
		if(f1.isAfter(f2)) {
			
			return 1;
		}
		else if(f1.isBefore(f2)) {
			return -1;
			
		}
		else {
			
			return 0;
		}
	}
}
