package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;
import controlador.ControladorAltaPrecio;
import modelo.Modelo;

public class Menu extends JPanel {

	private JButton btnAltaPrecio;
	private JButton btnListaPrecios;
	private JButton btnSalir;
	
	private Controlador controlador;
	
	public Menu(){
		setLayout(null);

		btnAltaPrecio = new Boton ("Alta Precio", 1);
		add(btnAltaPrecio);

		btnListaPrecios = new Boton ("Lista de Precios", 2);
		add(btnListaPrecios);
		
		
		btnSalir = new JButton ("Salir");
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
	}
	
	public void addListeners(Controlador controlador) {
		btnAltaPrecio.addActionListener(controlador);
		btnListaPrecios.addActionListener(controlador);
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void iniciarPanelAltaPrecio(Controlador c) {
		System.out.print("iniciando alta precio");
		Random gen = new Random();
		c.actionPerformed(new ActionEvent(this, (Integer) gen.nextInt(), InterfazVistaAltaPrecio.ALTA_PRECIO));
	}

	public void iniciarPanelListaPrecio(Controlador c) {
		System.out.print("iniciando alta precio");
		Random gen = new Random();
		c.actionPerformed(new ActionEvent(this, (Integer) gen.nextInt(), InterfazVistaAltaPrecio.LISTA_PRECIOS));
	}
	
	

}
