package Servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.SintomaDAO;
import DTO.SintomaDTO;

public class SintomaService {

	public static List<SintomaDTO>  buscarSintomasPorInicial (String inicial) throws SQLException
	{
		List<SintomaDTO> lista_sintomas= null;
		
		lista_sintomas = SintomaDAO.getSintomasPorInicial(inicial);
		
		
		return lista_sintomas;
		
	}
	
}

