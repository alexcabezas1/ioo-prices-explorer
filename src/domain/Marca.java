package domain;

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

}