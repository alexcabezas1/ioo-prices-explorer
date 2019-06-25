package vista;

import java.util.Collection;

import controlador.Controlador;
import dominio.Marca;
import dominio.Producto;
import dominio.Tienda;


public interface InterfazVistaAltaPrecio extends InterfazVista {
	String getPalabraBusquedaProducto();
	String getPalabraBusquedaTiendas();
	void agregarResultadosBuscadorProductos(Collection<Producto> items);
	void agregarResultadosBuscadorTiendas(Collection<Tienda> items);
	void agregarTipos(Collection<String> items);
	void agregarMarcas(Collection<Marca> items);
	void agregarTiendas(Collection<String> items);
	void agregarCalles(Collection<String> items);
}