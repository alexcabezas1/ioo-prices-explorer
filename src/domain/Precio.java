package domain;

import java.sql.Timestamp;

public class Precio {

    public Precio() {
    }

    private int id;

    private Producto producto;

    private Usuario usuario;

    private Tienda tienda;

    private float valor;

    private Timestamp fechaHoraRegistro;

    public int obtenerId() {
		return id;
	}

	public void asignarId(int id) {
		this.id = id;
	}

	public Producto obtenerProducto() {
		return producto;
	}

	public void asignarProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario obtenerUsuario() {
		return usuario;
	}

	public void asignarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tienda obtenerTienda() {
		return tienda;
	}

	public void asignarTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public float obtenerValor() {
		return valor;
	}

	public void asignarValor(float valor) {
		this.valor = valor;
	}

	public Timestamp obtenerFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void asignarFechaHoraRegistro(Timestamp fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public void validar() {
    }

}