package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import controlador.ControladorPrincipal;
import dominio.Producto;

public class TestVista extends JFrame implements InterfazVista {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AltaPrecioPanel altaPrecioPanel;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestVista frame = new TestVista();
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
	public TestVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 374);
		setPreferredSize(new Dimension(300, 370));
		//contentPane = new JPanel();
		
		//contentPane.setLayout(new BorderLayout(0, 0));
		
		altaPrecioPanel = new AltaPrecioPanel();
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(altaPrecioPanel);
	}

	@Override
	public void arranca() {
		pack();
		setVisible(true);
	}

	@Override
	public void setControlador(Controlador c) {
		controlador = c;
		altaPrecioPanel.setControlador(c);
		//altaPrecioPanel.getBtnRegistrarPrecio().addActionListener(c);
	}
	
	public String getPalabraBusquedaProducto() {
		return altaPrecioPanel.getPalabraBuscadorProductos();
	}

	@Override
	public void agregarResultadosBuscadorProductos(List<Producto> items) {
		altaPrecioPanel.agregarResultadosBuscadorProductos(items);	
	}

	@Override
	public void limpiar(String evento) {
		altaPrecioPanel.limpiar(evento);
		
	}



}
