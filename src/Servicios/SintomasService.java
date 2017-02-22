package Servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.SintomasDAO;
import DTO.SintomaDTO;


public class SintomasService {

	public List<SintomaDTO>  buscarSintomasPorInicial (String inicial) throws SQLException
	{
		List<SintomaDTO> lista_sintomas= null;
		
		lista_sintomas = SintomasDAO.getSintomasPorInicial(inicial);
		
		
		return lista_sintomas;
		
	}
	
}



