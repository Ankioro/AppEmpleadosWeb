

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



/**
 * Servlet implementation class ConsultaEmpleados
 */
@WebServlet("/ConsultaEmpleados")
public class ConsultaEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger("mylog");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("entro en el doget");
		//Creamos e importamos la lista de empleados
		EmpleadoServicio es = new EmpleadoServicio();
		List<Empleado> le = es.getEmpleados();
		
		int contador = 0;
		for (Empleado e : le)
		{
			contador = contador +1;
			System.out.println("Nombre = " + contador + " " + e.getNombre() +
					e.getId());
		}
		
		request.setAttribute("lempleados", le);
		request.getRequestDispatcher("listaempleados.jsp").forward(request, response);
		
		//response.getWriter().append("LLAMO A GET Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
