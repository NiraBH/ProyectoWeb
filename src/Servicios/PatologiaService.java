package Servicios;

import DAO.PatologiaDAO;
import DTO.PatologiaDTO;

public class PatologiaService {

	public PatologiaDTO buscarPatologiaPorID (int id)
	{
		PatologiaDAO pdao = new PatologiaDAO();
		PatologiaDTO dto = pdao.buscarPorId(id);
		
		return dto;
	}
}
