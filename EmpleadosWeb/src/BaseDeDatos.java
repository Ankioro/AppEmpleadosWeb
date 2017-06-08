import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			//registro el driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//obtengo la conexion
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "adalid");
			//creo el statement
			statement = connection.createStatement();
			//ejecuto la consulta
			resultset = statement.executeQuery("SELECT FIRST_NAME FROM EMPLOYEES");
			
			while (resultset.next())
			{
				String nombre = resultset.getString("FIRST_NAME");
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
	}

}
