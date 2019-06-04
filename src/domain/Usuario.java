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

    private long[] ubicacion;

    private Precio preciosRegistrados;

    private Producto productosComprados;


    public String obtenerNombreUsuario() {
		return nombreUsuario;
	}

	public void asignarNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String obtenerEmail() {
		return email;
	}

	public void asignarEmail(String email) {
		this.email = email;
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

	public void asignarFechaHoraRegistro(Timestamp fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public Timestamp obtenerFechaHoraActualizacion() {
		return fechaHoraActualizacion;
	}

	public void asignarFechaHoraActualizacion(Timestamp fechaHoraActualizacion) {
		this.fechaHoraActualizacion = fechaHoraActualizacion;
	}

	public Persona obtenerPersona() {
		return persona;
	}

	public void asignarPersona(Persona persona) {
		this.persona = persona;
	}

	public long[] obtenerUbicacion() {
		return ubicacion;
	}

	public void asignarUbicacion(long[] ubicacion) {
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