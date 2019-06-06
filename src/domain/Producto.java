package domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Producto {
	
	private static int idCounter = 0;
	
    private int id;
    private String codigoBarras;
    private String nombre;
    private Marca marca;
    private String tipo;
    private List<Precio> precios = new ArrayList<Precio>();
    
    public Producto(String codbar, String nombre, Marca mrc, String tpo) {
    	this.codigoBarras = codbar.toLowerCase();
    	this.nombre = nombre.toLowerCase();
    	this.marca = mrc;
    	this.tipo = tpo.toLowerCase();
    	this.id = ++idCounter;
    }
    
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

    public Marca obtenerMarca() {
        return this.marca;
    }

    public void asignarMarca(Marca valor) {
        this.marca = valor;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public void asignarTipo(String valor) {
        this.tipo = valor;
    }
    
    public List<Precio> obtenerPrecios() {
        return this.precios;
    }

    public void obtenerPrecioMasReciente(long[] ubicacion) {
    	
    }
    
    public void validar() {
        
    }

    public boolean contiene(String valor) {
        String contenido = this.codigoBarras + " " + 
        				   this.nombre + " " + 
        				   this.marca.obtenerNombre() + " " + 
        				   this.tipo;
        return contenido.contains(valor);
    }

    public Precio agregarPrecio(Usuario usr, Tienda tda, float valor) {
    	Precio prc = new Precio(this, usr, tda, valor);
    	this.precios.add(prc);
    	//usr.asignarPreciosRegistrados(precio);
    	return prc;
    }
    
    public String toString() {
    	String cont = "producto:" + String.valueOf(this.obtenerId());
    	cont += ", nombre:" + this.obtenerNombre();
    	cont += ", cod-barras:" + this.obtenerCodigoBarras();
    	cont += ", marca:" + this.obtenerMarca().obtenerNombre();
    	cont += ", tipo:" + this.obtenerTipo();
    	return cont;
    }
}