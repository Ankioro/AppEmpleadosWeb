import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Esto se denomina DAO (DataAccessObject)
public class EmpleadoBD {

	//Es una seccion de java que indica que sólo se ejecutara una vez (para que en
	//futuras peticiones llame automaticamente al driver de oracle 
	static {
		//registro el driver importado de Oracle (pero sólo 1 vez)
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Recogemos los empleados por nombre
	public List<Empleado> getEmpleadosBD()
	{
		List<Empleado> listaEmpleados = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			//obtengo la conexion (el getConnection se emplea en cada llamada)
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "adalid");
			//creo el statement
			statement = connection.createStatement();
			//ejecuto la consulta (el resultset es el cuerpo del codigo)
			resultset = statement.executeQuery("SELECT FIRST_NAME FROM EMPLOYEES");

			//Creamos un ArrayList para poder trabajar con la lista creada anteriormente
			//Esto se debe a que List es un tipo padre y ArrayList es un subtipo
			listaEmpleados = new ArrayList<Empleado>();
			Empleado empleadoAuxiliar = null;
			
			//Una vez instanciado el ArrayList creamos y agregamos los empleados
			while (resultset.next())
			{
				String nombre = resultset.getString("FIRST_NAME");
				empleadoAuxiliar = new Empleado(nombre);
				listaEmpleados.add(empleadoAuxiliar);
				System.out.println(nombre);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try{
			resultset.close();
			statement.close();
			connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	
		
		return listaEmpleados;
	}
	
	//Recogemos los empleados por ID de departamento
	public List<Empleado> getEmpleadosBD(int ndpto)
	{
		List<Empleado> listaEmpleados = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			//obtengo la conexion (el getConnection se emplea en cada llamada)
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "adalid");
			//creo el statement
			statement = connection.createStatement();
			//ejecuto la consulta (el resultset es el cuerpo del codigo)
			resultset = statement.executeQuery("SELECT FIRST_NAME FROM EMPLOYEES WHERE"
					+ "DEPARTMENT_ID = " +ndpto);

			//Creamos un ArrayList para poder trabajar con la lista creada anteriormente
			//Esto se debe a que List es un tipo padre y ArrayList es un subtipo
			listaEmpleados = new ArrayList<Empleado>();
			Empleado empleadoAuxiliar = null;
			
			//Una vez instanciado el ArrayList creamos y agregamos los empleados
			while (resultset.next())
			{
				String nombre = resultset.getString("FIRST_NAME");
				empleadoAuxiliar = new Empleado(nombre);
				listaEmpleados.add(empleadoAuxiliar);
				System.out.println(nombre);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try{
			resultset.close();
			statement.close();
			connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	
		
		return listaEmpleados;
	}
	
	
	public List<Empleado> getEmpleadoNombreEIDDB()
	{

		List<Empleado> listaEmpleados = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			//obtengo la conexion (el getConnection se emplea en cada llamada)
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "adalid");
			//creo el statement
			statement = connection.createStatement();
			//ejecuto la consulta (el resultset es el cuerpo del codigo)
			resultset = statement.executeQuery("SELECT FIRST_NAME, EMPLOYEE_ID FROM EMPLOYEES");

			//Creamos un ArrayList para poder trabajar con la lista creada anteriormente
			//Esto se debe a que List es un tipo padre y ArrayList es un subtipo
			listaEmpleados = new ArrayList<Empleado>();
			Empleado empleadoAuxiliar = null;
			
			//Una vez instanciado el ArrayList creamos y agregamos los empleados
			String nombre = null;
			int id = -1;
			
			while (resultset.next())
			{
				nombre = resultset.getString("FIRST_NAME");
				id = resultset.getInt("EMPLOYEE_ID");
				empleadoAuxiliar = new Empleado(nombre, id);
				listaEmpleados.add(empleadoAuxiliar);
				System.out.println(nombre);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try{
			resultset.close();
			statement.close();
			connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}	
		
		return listaEmpleados;	
	}
}
