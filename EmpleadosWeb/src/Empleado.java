//Creamos la clase Empleado, instanciamos un string privado nombre y creamos los
//getters and setter junto con el constructor using fields
public class Empleado {
	
	private String nombre;
	private int id;

	public Empleado(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}
