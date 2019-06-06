package domain;

public class Persona {
	
	private static int idCounter = 0;
	
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String fechaNacimiento;
	private String sexo;
	
	public Persona(String nbre, String apel, String dni, String fecNac, String sexo) {
		 this.nombre = nbre.toLowerCase();
		 this.apellido = apel.toLowerCase();
		 this.dni = dni;
		 this.fechaNacimiento = fecNac;
		 this.sexo = sexo.toLowerCase();
		 this.id = ++idCounter;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}
	
}
