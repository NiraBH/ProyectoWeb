
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class ObtenerInfoPatologia
   */
  @WebServlet("/ObtenerInfoPatologia")
  
  public class ObtenerInfoPatologia extends HttpServlet {
  	private static final long serialVersionUID = 1L;
         
      /**
       * @see HttpServlet#HttpServlet()3
       */
      public ObtenerInfoPatologia() {
          super();
          // TODO Auto-generated constructor stub
      }
  
  	/**
  	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		Statement st = null;
  		ResultSet rset = null;
  		Pool pool = null;

  		String select_pat = "Select id_patol from Patologias where nom_patol ='Presbicia'";
  		pool = Pool.getInstance();
  		Connection con = Pool.getConnection();
  		int idPatol = -5;

  		try {
  		st = con.createStatement();
  		rset = st.executeQuery(select_pat);
  		rset.next();
  		idPatol = rset.getInt("id_patol");
  		} catch (SQLException e) {
  		e.printStackTrace();
  		}

  		finally {
  		try {
  		rset.close();
  		} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
  		try {
  		con.close();
  		} catch (SQLException e) {
  		e.printStackTrace();
  		}
  		try {
  		st.close();
  		} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}

  		}
  		response.getWriter().append("id Queratocono: ").append(String.valueOf(idPatol));
  		}
  	
  
  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		System.out.println("Llamando al doPost");
  		String str = request.getParameter("id");
  		System.out.println("nombre = "  +str);
  	}
  
  }