package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.SintomaDTO;
import Servicios.Consultas;

public class SintomaDAO {

		
	public static List<SintomaDTO> getSintomasPorInicial (String inicial) throws SQLException
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		SintomaDTO sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		Connection conn = null;
		conn = Pool.getConnection();
	
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_SINTOMAS+inicial+"%'");
	
		while (rset2.next())
		{
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new SintomaDTO(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		
	return lista_sintomas;
	}
}