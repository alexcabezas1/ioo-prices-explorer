package main;

import javax.swing.SwingUtilities;

import controlador.Controlador;
import controlador.ControladorPrincipal;
import modelo.Modelo;
import vista.InterfazVista;
import vista.TestVista;

public class ExploradorPrecios {
	
	static Modelo modelo;
	
	static void cargarDatosPrueba() {
		modelo.crearProducto("1", "Arroz Blanco", "Gallo", "Arroz");
		modelo.crearProducto("2", "Arroz Integral", "Gallo", "Arroz");
		modelo.crearProducto("3", "Arroz Salvaje", "Gallo", "Arroz");
		modelo.crearProducto("4", "Queso Crema Light", "Finlandia", "Queso Crema");
		modelo.crearProducto("5", "Queso Crema Salmon", "Finlandia", "Queso Crema");
		modelo.crearProducto("6", "Queso Crema Parmesano", "Finlandia", "Queso Crema");
		modelo.crearProducto("7", "Mini Tostaditas Queso", "Twistos", "Tostaditas");
		modelo.crearProducto("8", "Mini Tostaditas Jamon", "Twistos", "Tostaditas");
		modelo.crearProducto("9", "Mermelada Frutilla", "Arcor", "Mermelada");
		modelo.crearProducto("10", "Mermelada Ciruela", "Arcor", "Mermelada");
		modelo.crearProducto("11", "Mermelada Durazno", "Arcor", "Mermelada");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	
				modelo = new Modelo();		
				InterfazVista vista = new TestVista();
				Controlador controlPrincipal = new ControladorPrincipal(modelo, vista);
				vista.setControlador(controlPrincipal);
				
				cargarDatosPrueba();
				
				vista.agregarTipos(modelo.obtenerTipos());
				vista.arranca();
		    }
		});
	}

}
