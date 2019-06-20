package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import controlador.ControladorPrincipal;

public class TestVista extends JFrame implements InterfazVista {

	private AltaPrecioPanel altaPrecioPanel;
	private BuscadorProductosDialog buscadorProductosDialog;
	private BuscadorTiendaDialog buscadorTiendaDialog;

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
		//contentPane = new JPanel();
		
		//contentPane.setLayout(new BorderLayout(0, 0));
		
		buscadorProductosDialog = new BuscadorProductosDialog();
		altaPrecioPanel = new AltaPrecioPanel();
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(altaPrecioPanel);
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControlador(Controlador c) {
		altaPrecioPanel.getBtnBuscarProducto().addActionListener(c);
		altaPrecioPanel.getBtnBuscarTienda().addActionListener(c);
		altaPrecioPanel.getBtnRegistrarPrecio().addActionListener(c);
		
	}

}
