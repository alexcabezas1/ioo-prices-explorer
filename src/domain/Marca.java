package domain;

public class Marca {

    private int id;

    private String nombre;
    
    public int obtenerId() {
        return id;
    }
    
    public String obtenerNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void asignarId(int id) {
    	this.id = id;
    }
    
    public void validar() {
        
    }

    public boolean contiene(String  valor) {
        return this.nombre.contains(valor);
    }

}