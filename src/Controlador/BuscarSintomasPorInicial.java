package Controlador;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.Type;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DTO.SintomaDTO;
import Servicios.SintomasService;

/**
 * Servlet implementation class BuscarSintomasPorInicial
 */
@WebServlet("/BuscarSintomasPorInicial")
public class BuscarSintomasPorInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomasPorInicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SintomasService ss = new SintomasService();
		
		
		try {
			String valorSintoma = request.getParameter("sintomaBuscado");
			List<SintomaDTO> lista_sintomaDTO = ss.buscarSintomasPorInicial(valorSintoma);
			
			
			for(SintomaDTO sintoma: lista_sintomaDTO)
			{
				valorSintoma = sintoma.getDescripcion();
				System.out.println(valorSintoma);
			}
			
			Gson gson = new Gson();
			Type tipoListaSintomas = new TypeToken<List<SintomaDTO>>(){}.getType();
			String s = gson.toJson(lista_sintomaDTO, tipoListaSintomas);
			System.out.println(s);
			 
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
