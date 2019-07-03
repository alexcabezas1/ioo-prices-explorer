package vista;

import java.util.HashMap;

import controlador.Controlador;

public interface InterfazVista {
	static final String ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO="Buscar Productos desde Alta Precio";
	static final String ABUSCAR_TIENDAS_DESDE_ALTAPRECIO="Buscar Tiendas desde Alta Precio";
	static final String ALLENAR_DATOS_DESDE_ALTAPRECIO="Llenar Datos para Alta Precio";
	static final String AGUARDAR_DATOS_ALTAPRECIO="Guardar Datos de Alta Precio";

	static final String ALTA_PRECIO = "Alta Precio";
	static final String LISTA_PRECIOS = "Lista de precios";
	
	
	void arranca(); 
	void limpiar(String evento);
	void preparar();
	HashMap<String, String> obtenerDatos();
	void setControlador(Controlador c);
	void notificarControlador(String evento);	


	void esconderListaPrecios();
	void iniciarPanelAltaPrecio();
	void esconderAltaPrecio();
	void iniciarListaPrecios();
}