package dominio;

public class Marca {
	
	private static int idCounter = 0;
	
    private int id;

    private String nombre;
    
    public Marca(String nombre) {
    	this.nombre = nombre.toLowerCase();
    	this.id = ++idCounter;
    }
    
    public int obtenerId() {
        return id;
    }
    
    public String obtenerNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void validar() {
        
    }

    public boolean contiene(String  valor) {
        return this.nombre.contains(valor);
    }
    
    
    public String toString() {
    	return this.nombre;
    }
    
    @Override
    public int hashCode() {
    	return this.nombre.hashCode();
    }
    
    @Override
    public boolean equals(Object otraMrc) {
    	try {
	    	Marca otra = (Marca) otraMrc;
	    	if (otra == null) return false;
	    	return otra.obtenerNombre().equals(this.obtenerNombre()); 
    	} catch(Exception e) {
    		String otra = (String) otraMrc;
    		return otra.toLowerCase().equalsIgnoreCase(this.obtenerNombre());
    	}
    }
}