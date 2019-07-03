package controlador;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import dominio.Precio;
import dominio.Producto;
import dominio.Tienda;
import dominio.Usuario;
import modelo.Modelo;
import vista.InterfazVista;
import vista.InterfazVistaAltaPrecio;

public class ControladorAltaPrecio extends Controlador {

	protected InterfazVistaAltaPrecio vista;
	
	public ControladorAltaPrecio(Modelo modelo, InterfazVistaAltaPrecio vista) {
		super(modelo, vista);
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case InterfazVistaAltaPrecio.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO:
				buscarProductosPorPalabra();
				break;
			case InterfazVistaAltaPrecio.ALLENAR_DATOS_DESDE_ALTAPRECIO:
				prepararAltaPrecio();
				break;
			case InterfazVistaAltaPrecio.ABUSCAR_TIENDAS_DESDE_ALTAPRECIO:
				buscarTiendas();
				break;
			case InterfazVistaAltaPrecio.AGUARDAR_DATOS_ALTAPRECIO:
				guardarDatosAltaPrecio();
				break;
			case InterfazVista.ALTA_PRECIO:
				mostrarAltaPrecio();
				break;
			case InterfazVista.LISTA_PRECIOS:
				mostrarListaPrecios();
				break;
		}
	}
	
	private void mostrarAltaPrecio() {
		this.vista.esconderListaPrecios();
		this.vista.iniciarPanelAltaPrecio();
	}
	
	private void mostrarListaPrecios() {
		this.vista.esconderAltaPrecio();
		this.vista.iniciarListaPrecios();
	}
	
	private void prepararAltaPrecio() {
		this.vista.agregarTipos(modelo.obtenerTipos());
		this.vista.agregarMarcas(modelo.obtenerMarcas());
		this.vista.agregarTiendas(modelo.obtenerTiendasNombres());
		this.vista.agregarCalles(modelo.obtenerCalles());
	}
	
	private void buscarProductosPorPalabra() {
		this.vista.limpiar(InterfazVistaAltaPrecio.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO);
		String busqueda = this.vista.getPalabraBusquedaProducto();
		List<Producto> productos = this.modelo.buscarProductosPorPalabra(busqueda);
		this.vista.agregarResultadosBuscadorProductos(productos);
	}
	
	private void buscarTiendas() {
		this.vista.limpiar(InterfazVistaAltaPrecio.ABUSCAR_TIENDAS_DESDE_ALTAPRECIO);
		String busqueda = this.vista.getPalabraBusquedaTiendas();
		List<Tienda> tiendas = this.modelo.buscarTiendas(busqueda);
		this.vista.agregarResultadosBuscadorTiendas(tiendas);
	}
	
	private void guardarDatosAltaPrecio() {
		Random rand = new Random();
		HashMap<String, String> datos = this.vista.obtenerDatos();
		
		float precio;
		int tiendaAltura;
		
		if (datos.get("precio").length() > 0) {
			precio = Float.parseFloat(datos.get("precio"));
		} else {
			precio = (float) 0.0;
		}
		
		if (datos.get("tienda-altura").length() > 0) {
			tiendaAltura = Integer.parseInt(datos.get("tienda-altura"));
		}else {
			tiendaAltura = 0;
		}
		
		String datosProducto = datos.get("producto-nombre") + " " + datos.get("producto-marca") + " " + datos.get("producto-tipo"); 
		List<Producto> productos = modelo.buscarProductosPorPalabra(datosProducto);

		String datosTienda = datos.get("tienda-nombre") + " " + datos.get("tienda-calle") + " " + 
							 datos.get("tienda-altura") + " " + datos.get("tienda-entre-calles1") + " " + 
							 datos.get("tienda-entre-calles2"); 		
		List<Tienda> tiendas = modelo.buscarTiendas(datosTienda);
		
		if (!productos.isEmpty() && !tiendas.isEmpty()) {
			modelo.guardarDatosAltaPrecio(productos.get(0), tiendas.get(0), precio);
		} else if (!productos.isEmpty() && tiendas.isEmpty()) {
			modelo.guardarDatosAltaPrecio(
				productos.get(0), precio, datos.get("tienda-nombre"), 
				datos.get("tienda-calle"), Integer.parseInt(datos.get("tienda-altura")), datos.get("tienda-entre-calles1"), 
				datos.get("tienda-entre-calles2")
			);
		} else if (!tiendas.isEmpty()) {
			modelo.guardarDatosAltaPrecio(
				String.valueOf(rand.nextInt(1000)), datos.get("producto-nombre"), datos.get("producto-marca"), 
				datos.get("producto-tipo"), tiendas.get(0), precio
			);
		} else {
			modelo.guardarDatosAltaPrecio(
				String.valueOf(rand.nextInt(1000)), datos.get("producto-nombre"), datos.get("producto-marca"), 
				datos.get("producto-tipo"), precio, datos.get("tienda-nombre"), 
				datos.get("tienda-calle"), Integer.valueOf(tiendaAltura), datos.get("tienda-entre-calles1"), 
				datos.get("tienda-entre-calles2")
			);
		}
		this.vista.limpiar(InterfazVistaAltaPrecio.AGUARDAR_DATOS_ALTAPRECIO);
		this.vista.notificarControlador(InterfazVistaAltaPrecio.ALLENAR_DATOS_DESDE_ALTAPRECIO);
		System.out.println(modelo.obtenerPrecios());
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
