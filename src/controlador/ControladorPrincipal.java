package controlador;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import dominio.Precio;
import dominio.Producto;
import dominio.Usuario;
import modelo.Modelo;
import vista.InterfazVista;

public class ControladorPrincipal extends Controlador {

	public ControladorPrincipal(Modelo modelo, InterfazVista vista) {
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case InterfazVista.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO:
				buscarProductosPorPalabra();
				break;
		}
	}
	
	public void iniciarSesion() {
		// TODO obtener usuario y clave de la vista
		String nombreUsuario = ""; 
		String clave = "";
		modelo.asignarUsuarioLogeado(nombreUsuario, clave);
	}
	
	public void buscarProductosPorPalabra() {
		this.vista.limpiar(InterfazVista.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO);
		String busqueda = this.vista.getPalabraBusquedaProducto();
		System.out.print(busqueda);
		List<Producto> productos = this.modelo.buscarProductosPorPalabra(busqueda);
		this.vista.agregarResultadosBuscadorProductos(productos);
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
