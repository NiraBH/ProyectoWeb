package Controlador;



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String inicial = request.getParameter("intro");
		SintomasService ss = new SintomasService();
		List<SintomaDTO> lista_sintomas = null;
		try {
			lista_sintomas = ss.buscarSintomasPorInicial(inicial);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		for (SintomaDTO sintoma : lista_sintomas) {
			System.out.println(sintoma);
		}
		*/
		Gson gson = new Gson();
		Type tipoListaSintomas = new TypeToken<List<SintomaDTO>>(){}.getType();
		String s = gson.toJson(lista_sintomas, tipoListaSintomas);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(s);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}