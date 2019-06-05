package domain;

public class Tienda {
	
	private static int idCounter = 0;
	
    private int id;
    
    private String nombre;
    
    private Direccion direccion;
    
    public Tienda(String nombre, Direccion dir) {
    	this.nombre = nombre;
    	this.direccion = dir;
    	this.id = idCounter++;
    }
    
    public String obtenerNombre() {
		return nombre;
	}

	public void asignarNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion obtenerDireccion() {
		return direccion;
	}

	public void asignarDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public long[] obtenerUbicacion() {
		return this.direccion.obtenerUbicacion();
	}
	
	public int obtenerId() {
		return id;
	}

	public void validar() {
        
    }

    public boolean contiene(String valor) {
        return this.nombre.contains(valor);
    }

}