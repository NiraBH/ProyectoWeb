package servicios;

import dao.PatologiaDAO;
import dto.PatologiasDTO;

public class PatologiaServiceN {

	
	public PatologiasDTO buscarPatologiaPorID (int id)
	{
		PatologiasDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			pdto = pdao.buscarPorId(id);
		
		return pdto;
	}
}