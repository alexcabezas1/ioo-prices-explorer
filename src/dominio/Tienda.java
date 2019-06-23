package dominio;

public class Tienda {
	
	private static int idCounter = 0;
	
    private int id;
    
    private String nombre;
    
    private Direccion direccion;
    
    public Tienda(String nombre, Direccion dir) {
    	this.nombre = nombre.toLowerCase();
    	this.direccion = dir;
    	this.id = ++idCounter;
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

	public float[] obtenerUbicacion() {
		return this.direccion.obtenerUbicacion();
	}
	
	public int obtenerId() {
		return id;
	}

	public void validar() {
        
    }

    public boolean contiene(String valor) {
    	String cont = this.nombre + " " +
    				  this.direccion.obtenerCalle() + " " +
    				  String.valueOf(this.direccion.obtenerAltura()) + " " +
    				  this.direccion.obtenerEntreCalle1() + " " +
    				  this.direccion.obtenerEntreCalle2();
        return cont.contains(valor);
    }
    
    protected String obtenerValores() {
    	return this.nombre + this.direccion.obtenerValores();
    }
    
    @Override
    public int hashCode() {
    	return obtenerValores().hashCode();
    }
    
    @Override
    public boolean equals(Object otraTienda) {
    	Tienda otra = (Tienda) otraTienda;
    	if (otra == null) return false;
    	return otra.obtenerValores().equals(this.obtenerValores()); 
    }
    
    public String toString() {
    	return this.nombre;
    }

}