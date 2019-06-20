package vista;

import controlador.Controlador;

public interface InterfazVista {
	void setControlador(Controlador c);
	void arranca(); 
	static final String ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO="Buscar Productos";
	static final String ABUSCAR_TIENDAS_DESDE_ALTAPRECIO="Buscar Tiendas";
}