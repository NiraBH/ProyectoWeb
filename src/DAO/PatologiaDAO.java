package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DTO.PatologiaDTO;
import DTO.SintomaDTO;
import Servicios.Consultas;

public class PatologiaDAO {
	
	public PatologiaDTO buscarPorId (int id){
		
		//Conexiones  Llamada a Pool
		{
			PatologiaDTO pdto = null;
				
			Pool pool = Pool.getInstance();
			Connection conn = Pool.getConnection();
			Statement stmt = null;
			ResultSet rset = null;
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIAS_POR_ID +id);
				while (rset.next())
			    {
					pdto = new PatologiaDTO(rset.getInt(1), rset.getNString(5), rset.getString(3), rset.getString(4), rset.getNString(2), getSintomasPorPatologiaID(conn, rset.getInt(1)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				Pool.liberarRecursos(conn, stmt, rset);
			}
			return pdto;
		}
		
		
	}

	private List<SintomaDTO> getSintomasPorPatologiaID(Connection conn, int int1) {
		// TODO Auto-generated method stub
		return null;
	}

}
