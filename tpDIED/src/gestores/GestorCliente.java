package gestores;

import dao.ClienteDAO;
import dto.ClienteDTO;

public class GestorCliente {

	public static Integer crearCliente(String nombre, String apellido) {
		ClienteDTO c=new ClienteDTO(ClienteDAO.obtenerId(), nombre, apellido);
		ClienteDAO.guardarCliente(c);
		return c.getId();
	}

}
