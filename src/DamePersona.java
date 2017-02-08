
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.google.gson.Gson;




	/**
	* Servlet implementation class damepersona
	*/
	@WebServlet("/damepersona")
	public class DamePersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	      
	   /**
	    * @see HttpServlet#HttpServlet()
	    */
	   public DamePersona() {
	       super();
	       // TODO Auto-generated constructor stub
	   }

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Persona persona = new Persona("pepe", 22);
	Gson gson = new Gson();
	String json = gson.toJson(persona);
	PrintWriter pw = response.getWriter();
	pw.write(json);
	response.setContentType("aplication/json");
	}
}
	