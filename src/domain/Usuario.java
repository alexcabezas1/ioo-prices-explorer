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


    public void obtenerNombreUsuario() {
    }

    public void asignarNombreUsuario(String valor) {
    }

    public void obtenerEmail() {
    }

    public void asignarEmail(String valor) {
    }

    public void asignarClave(String valor) {
    }

    public void obtenerFechaHoraRegistro() {
    }

    public void obtenerFechaHoraActualizacion() {
    }

    public void obtenerPersona() {
    }

    public void obtenerUbicacion() {
    }

    public void validar() {
    }

    public void autenticar(String usuario, String clave) {
    }

    public void comprarProducto(Producto prd, float precioCompra) {
    }

    public void obtenerPreciosRegistrados() {
    }

    public void productosComprados() {
    }

    public void productosComprados(String fechaHora) {
    }

}