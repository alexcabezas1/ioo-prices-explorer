package controlador;

import java.awt.event.ActionEvent;

import dominio.Precio;
import dominio.Producto;
import dominio.Usuario;
import modelo.Modelo;

public class ControladorPrincipal extends Controlador {
	private Modelo modelo;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void iniciarSesion() {
		// TODO obtener usuario y clave de la vista
		String nombreUsuario = ""; 
		String clave = "";
		modelo.asignarUsuarioLogeado(nombreUsuario, clave);
	}
	
	public void buscarProductosPorPalabra() {
		
	}
	
	public void buscarTiendas() {
		
	}
	
	public void buscarDireccion() {
		
	}
	
	public void buscarMarcas() {
		
	}
	
	public void guardarDatosAltaPrecio() {
		
	}
	
	public void mostrarDetalleProducto() {
		
	}
	
	public void mostrarPreciosZona() {
		
	}
	
    public void elegirProducto(int id) {
    	Usuario usr = modelo.obtenerUsuarioLogeado();
    	Producto prd = modelo.buscarProductos(new Integer[]{id}).get(0);
    	Precio prc = prd.obtenerPrecioMasReciente(usr.obtenerUbicacion());
    	// TODO Llamar a iniciarVentanaDetallePrecio
    }
}
