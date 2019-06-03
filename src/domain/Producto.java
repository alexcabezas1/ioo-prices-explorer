package domain;

public class Producto {

    private int id;
    private String codigoBarras;
    private String nombre;
    private String marca;
    private String tipo;
    private Precio precios;
    
    public int obtenerId() {
        return this.id; 
    }
    
    public String obtenerCodigoBarras() {
        return this.codigoBarras;
    }

    public void asignarCodigoBarras(String valor) {
        this.codigoBarras = valor;
    }
    
    public String obtenerNombre() {
        return nombre;
    }

    public void asignarNombre(String valor) {
    	this.nombre = valor;
    }

    public String obtenerMarca() {
        return this.marca;
    }

    public void asignarMarca(String valor) {
        this.marca = valor;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public void asignarTipo(String valor) {
        this.tipo = valor;
    }
    
    public Precio obtenerPrecios() {
        return this.precios;
    }

    public void obtenerPrecioMasReciente(long[] ubicacion) {
    	
    }
    
    public void validar() {
        
    }

    public void agregarPrecio(Usuario usr, Tienda tda, float valor) {
        
    }

    public void contiene(String valor) {
        
    }

}