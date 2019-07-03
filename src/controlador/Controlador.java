package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.InterfazVista;

public class Controlador implements ActionListener{
	protected Modelo modelo;
	protected InterfazVista vista;
	
	public Controlador(Modelo modelo, InterfazVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}
