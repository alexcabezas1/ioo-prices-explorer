package vista;

import java.util.Collection;

import controlador.Controlador;
import dominio.Marca;
import dominio.Producto;


public interface InterfazVista {
	static final String ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO="Buscar Productos desde Alta Precio";
	static final String ABUSCAR_TIENDAS_DESDE_ALTAPRECIO="Buscar Tiendas desde Alta Precio";
	static final String ALLENAR_DATOS_DESDE_ALTAPRECIO="Llenar Datos para Alta Precio";
	
	void setControlador(Controlador c);
	void arranca(); 
	void limpiar(String evento);
	void preparar();
	void notificarControlador(String evento);
	String getPalabraBusquedaProducto();
	void agregarResultadosBuscadorProductos(Collection<Producto> items);
	void agregarTipos(Collection<String> items);
	void agregarMarcas(Collection<Marca> items);
}