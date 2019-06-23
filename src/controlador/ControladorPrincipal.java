package controlador;

import java.awt.event.ActionEvent;
import java.util.List;

import dominio.Precio;
import dominio.Producto;
import dominio.Tienda;
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
			case InterfazVista.ALLENAR_DATOS_DESDE_ALTAPRECIO:
				prepararAltaPrecio();
				break;
			case InterfazVista.ABUSCAR_TIENDAS_DESDE_ALTAPRECIO:
				buscarTiendas();
				break;
		}
	}
	
	private void iniciarSesion() {
		// TODO obtener usuario y clave de la vista
		String nombreUsuario = ""; 
		String clave = "";
		modelo.asignarUsuarioLogeado(nombreUsuario, clave);
	}
	
	private void prepararAltaPrecio() {
		this.vista.agregarTipos(modelo.obtenerTipos());
		this.vista.agregarMarcas(modelo.obtenerMarcas());
		System.out.print(modelo.obtenerCalles());
		this.vista.agregarTiendas(modelo.obtenerTiendasNombres());
		this.vista.agregarCalles(modelo.obtenerCalles());
	}
	
	private void buscarProductosPorPalabra() {
		this.vista.limpiar(InterfazVista.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO);
		String busqueda = this.vista.getPalabraBusquedaProducto();
		List<Producto> productos = this.modelo.buscarProductosPorPalabra(busqueda);
		this.vista.agregarResultadosBuscadorProductos(productos);
	}
	
	private void buscarTiendas() {
		this.vista.limpiar(InterfazVista.ABUSCAR_TIENDAS_DESDE_ALTAPRECIO);
		String busqueda = this.vista.getPalabraBusquedaTiendas();
		List<Tienda> tiendas = this.modelo.buscarTiendas(busqueda);
		this.vista.agregarResultadosBuscadorTiendas(tiendas);
	}
	
	private void buscarDireccion() {
		
	}
	
	private void buscarMarcas() {
		
	}
	
	private void guardarDatosAltaPrecio() {
		
	}
	
	private void mostrarDetalleProducto() {
		
	}
	
	private void mostrarPreciosZona() {
		
	}
	
	private void elegirProducto(int id) {
    	Usuario usr = modelo.obtenerUsuarioLogeado();
    	Producto prd = modelo.buscarProductos(new Integer[]{id}).get(0);
    	Precio prc = prd.obtenerPrecioMasReciente(usr.obtenerUbicacion());
    	// TODO Llamar a iniciarVentanaDetallePrecio
    }
}
