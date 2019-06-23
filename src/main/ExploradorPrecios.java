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
		
		modelo.crearTienda("Carrefour Express", "Anchonera", 1253, "Anchonera", "Charcas", new float[]{(float)-34.5948884, (float)-58.4067497});
		modelo.crearTienda("Carrefour Market", "Beruti", 2951, "Beruti", "Agüero", new float[]{(float)-34.5902199, (float)-58.4059074});
		modelo.crearTienda("Carrefour Express", "Pueyrredon", 1054, "Pueyrredon", "Paraguay", new float[]{(float)-34.5973959, (float)-58.4043226});
		modelo.crearTienda("Carrefour Market", "Av Santa Fe", 1954, "Av Santa Fe", "Ayacucho", new float[] {(float)-34.5954683, (float)-58.3968893});
		modelo.crearTienda("Carrefour Express", "Billinghurst", 1380, "Billinghurst", "Paraguay", new float[] {(float)-34.5934656, (float)-58.4124682});
		modelo.crearTienda("Coto", "French", 2417, "French", "Pueyrredon", new float[] {(float)-34.5904419,(float)-58.4012164});
		modelo.crearTienda("Coto", "Charcas", 2980, "Charcas", "Agüero", new float[] {(float)-34.5926518, (float)-58.4077278});
		modelo.crearTienda("Coto", "Junin", 1073, "Junin", "Av Santa Fe", new float[] {(float)-34.5958786, (float)-58.4010799});
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
