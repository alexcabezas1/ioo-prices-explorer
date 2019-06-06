package domain;

import java.sql.Timestamp;
import java.util.*;

public class Usuario {

    private String nombreUsuario;

    private String email;

    private String clave;

    private Timestamp fechaHoraRegistro;

    private Timestamp fechaHoraActualizacion;

    private Persona persona;

    private float[] ubicacion;

    private Precio preciosRegistrados;

    private Producto productosComprados;

    public Usuario(String nbre, String email, String clave, Persona per) {
    	this.nombreUsuario = nbre;
    	this.email = email;
    	this.clave = clave;
    	this.persona = per;
    }

    public String obtenerNombreUsuario() {
		return nombreUsuario;
	}

	public String obtenerEmail() {
		return email;
	}

	public String obtenerClave() {
		return clave;
	}

	public void asignarClave(String clave) {
		this.clave = clave;
	}

	public Timestamp obtenerFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public Timestamp obtenerFechaHoraActualizacion() {
		return fechaHoraActualizacion;
	}

	public Persona obtenerPersona() {
		return persona;
	}

	public float[] obtenerUbicacion() {
		return ubicacion;
	}

	public void asignarUbicacion(float[] ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Precio obtenerPreciosRegistrados() {
		return preciosRegistrados;
	}

	public void asignarPreciosRegistrados(Precio preciosRegistrados) {
		this.preciosRegistrados = preciosRegistrados;
	}

	public Producto obtenerProductosComprados() {
		return productosComprados;
	}

	public void asignarProductosComprados(Producto productosComprados) {
		this.productosComprados = productosComprados;
	}

	public void validar() {
    }

    public void autenticar(String usuario, String clave) {
    }

    public void comprarProducto(Producto prd, float precioCompra) {
    }


}