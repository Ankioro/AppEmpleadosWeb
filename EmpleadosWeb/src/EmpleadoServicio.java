import java.util.List;

public class EmpleadoServicio {

	public List<Empleado> getEmpleados()
	{
		List<Empleado> listaEmpleados = null;
		
		//Lamamos a EmpleadoBD para crear un nuevo objeto empleado y llamamos a 
		//listaEmpleados para recoger los datos de los empleados de la base de datos
		EmpleadoBD empleadoBD = new EmpleadoBD();
		listaEmpleados  = empleadoBD.getEmpleadoNombreEIDDB();
		
		return listaEmpleados;
	}
/*	
	public List<Empleado> getEmpleadosByDpto (int ndpto) 

	{
		EmpleadoBD empleadoBD = new EmpleadoBD();
		listaEmpleados  = empleadoBD.getEmpleadosBDByDpto();
		
		return listaEmpleados;
	}
	
	*/
	public List<Empleado> getEmpleadosByDpto(int ndpto)
	{
		List<Empleado> listaEmpleados = null;
		
		EmpleadoBD empleadoBD = new EmpleadoBD();
		listaEmpleados  = empleadoBD.getEmpleadosBD();
		
		return listaEmpleados;
	}
	
}
