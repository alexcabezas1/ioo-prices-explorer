package domain;

import java.sql.Timestamp;

public class Precio {
	
	private static int idCounter = 0;
	
    private int id;

    private Producto producto;

    private Usuario usuario;

    private Tienda tienda;

    private float valor;

    private Timestamp fechaHoraRegistro;

    public Precio(Producto prd, Usuario usr, Tienda tda, float valor) {
    	this.producto = prd;
    	this.usuario = usr;
    	this.tienda = tda;
    	this.valor = valor;
    	this.id = idCounter++;
    	this.fechaHoraRegistro = new Timestamp(System.currentTimeMillis());
    }
    
    public int obtenerId() {
		return id;
	}

	public Producto obtenerProducto() {
		return producto;
	}

	public Usuario obtenerUsuario() {
		return usuario;
	}

	public Tienda obtenerTienda() {
		return tienda;
	}

	public float obtenerValor() {
		return valor;
	}

	public Timestamp obtenerFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void validar() {
    }

}