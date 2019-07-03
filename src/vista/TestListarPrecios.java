package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;
import dominio.Marca;
import dominio.Producto;
import dominio.Tienda;

public class TestListarPrecios extends JFrame implements InterfazListarPrecios {
	
	private static final long serialVersionUID = 1L;
	private ListaPreciosPanel listaPrecioPanel;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestListarPrecios frame = new TestListarPrecios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TestListarPrecios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		setPreferredSize(new Dimension(1050, 500));

		listaPrecioPanel = new ListaPreciosPanel();
		listaPrecioPanel.setLayout(null);
		listaPrecioPanel.setBounds(550, 80, 400, 550);
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(listaPrecioPanel);
	}
	
	@Override
	public void arranca() {
		preparar();
		pack();
		this.setVisible(true);
		
	}

	@Override
	public void limpiar(String evento) {
		listaPrecioPanel.limpiar(evento);
	}

	@Override
	public void preparar() {
		notificarControlador(InterfazListarPrecios.ABUSCAR_TIENDAS_DESDE_LISTARPRECIO);
		
	}

	@Override
	public HashMap<String, String> obtenerDatos() {
		return listaPrecioPanel.obtenerDatos();
	}

	@Override
	public void setControlador(Controlador c) {
		this.controlador = c;		
	}

	@Override
	public void notificarControlador(String evento) {
		Random gen = new Random();
		controlador.actionPerformed(new ActionEvent(this, (Integer) gen.nextInt(), evento));
	}


}
