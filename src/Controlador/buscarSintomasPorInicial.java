package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DTO.SintomaDTO;
import Servicios.SintomaService;


/**
 * Servlet implementation class BuscarSintomasPorInicial
 */
@WebServlet("/BuscarSintomasPorInicial")
public class buscarSintomasPorInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarSintomasPorInicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SintomaService ss = new SintomaService();
		
		
		try {
			String valorSintoma = request.getParameter("sintomaBuscado");
			List<SintomaDTO> lista_sintomaDTO = ss.buscarSintomasPorInicial(valorSintoma);
			
			
			for(SintomaDTO sintoma: lista_sintomaDTO)
			{
				valorSintoma = sintoma.getDescripcion();
				System.out.println(valorSintoma);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//lista_sintomas = (ArrayList<String>) sintomas_service.buscarSintomaPorInicial(valorSintoma);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}