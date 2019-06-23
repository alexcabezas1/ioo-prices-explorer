package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Random;

import javax.swing.JFrame;
import controlador.Controlador;
import dominio.Marca;
import dominio.Producto;
import dominio.Tienda;

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
		preparar();
		pack();
		setVisible(true);
	}

	@Override
	public void setControlador(Controlador c) {
		controlador = c;
		altaPrecioPanel.setControlador(c);
	}
	
	@Override
	public String getPalabraBusquedaProducto() {
		return altaPrecioPanel.getPalabraBuscadorProductos();
	}
	
	@Override
	public String getPalabraBusquedaTiendas() {
		return altaPrecioPanel.getPalabraBuscadorTiendas();
	}
	
	@Override
	public void agregarResultadosBuscadorProductos(Collection<Producto> items) {
		altaPrecioPanel.agregarResultadosBuscadorProductos(items);	
	}

	@Override
	public void agregarResultadosBuscadorTiendas(Collection<Tienda> items) {
		altaPrecioPanel.agregarResultadosBuscadorTiendas(items);
	}
	
	@Override
	public void agregarTipos(Collection<String> items) {
		altaPrecioPanel.agregarItemsSelectorTipos(items);
	}
	
	@Override
	public void agregarMarcas(Collection<Marca> items) {
		altaPrecioPanel.agregarItemsSelectorMarcas(items);
	}

	@Override
	public void agregarTiendas(Collection<String> items) {
		altaPrecioPanel.agregarItemsSelectorTiendas(items);
	}

	@Override
	public void agregarCalles(Collection<String> items) {
		altaPrecioPanel.agregarItemsSelectorCalles(items);
	}
	
	@Override
	public void limpiar(String evento) {
		altaPrecioPanel.limpiar(evento);
	}

	@Override
	public void preparar() {
		notificarControlador(InterfazVista.ALLENAR_DATOS_DESDE_ALTAPRECIO);
	}

	@Override
	public void notificarControlador(String evento) {
		Random gen = new Random();
		controlador.actionPerformed(new ActionEvent(this, (Integer) gen.nextInt(), evento));
	}
}
