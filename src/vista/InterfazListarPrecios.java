package vista;

import java.util.HashMap;

import controlador.Controlador;

public interface InterfazListarPrecios {
	
	static final String ABUSCAR_TIENDAS_DESDE_LISTARPRECIO="Buscar Tiendas desde Listar Precio";
	
	void arranca(); 
	void limpiar(String evento);
	void preparar();
	HashMap<String, String> obtenerDatos();
	void setControlador(Controlador c);
	void notificarControlador(String evento);	
}
