package vista;

import java.util.List;

import controlador.Controlador;
import dominio.Producto;


public interface InterfazVista {
	static final String ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO="Buscar Productos";
	static final String ABUSCAR_TIENDAS_DESDE_ALTAPRECIO="Buscar Tiendas";
	
	void setControlador(Controlador c);
	void arranca(); 
	void limpiar(String evento);
	String getPalabraBusquedaProducto();
	void agregarResultadosBuscadorProductos(List<Producto> items);
}