package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
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
import javax.swing.JLabel;
import java.awt.Color;

public class TestVista extends JFrame implements InterfazVistaAltaPrecio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AltaPrecioPanel altaPrecioPanel;
	private ListaPreciosPanel listaPrecioPanel;
	private Menu menu;
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
		setBounds(100, 100, 1050, 650);
		setPreferredSize(new Dimension(1050, 500));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 1050, 650);
		setContentPane(panel);
		
		menu = new Menu();
		menu.setLayout(null);
		menu.setBounds(10, 10, 400, 500);
		panel.add(menu);
				
		altaPrecioPanel = new AltaPrecioPanel();
		altaPrecioPanel.setLayout(null);
		altaPrecioPanel.setBounds(550, 80, 400, 550);
		panel.add(altaPrecioPanel);

		listaPrecioPanel = new ListaPreciosPanel();
		listaPrecioPanel.setLayout(null);
		listaPrecioPanel.setBounds(550, 80, 400, 550);
		panel.add(listaPrecioPanel);
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(altaPrecioPanel);
	}

	@Override
	public void esconderAltaPrecio() {
		System.out.print("escondiendo alta precio\n");
		altaPrecioPanel.setVisible(false);
	}

	@Override
	public void esconderListaPrecios() {
		System.out.print("escondiendo lista precios\n");
		listaPrecioPanel.setVisible(false);
		
	}

	@Override
	public void iniciarPanelAltaPrecio() {
		System.out.print("iniciando alta precio\n");
		altaPrecioPanel.setVisible(true);
	}

	@Override
	public void iniciarListaPrecios() {
		System.out.print("iniciando listar precios\n");
		listaPrecioPanel.setVisible(true);
	}

	@Override
	public void arranca() {
		preparar();
		pack();
		this.setVisible(true);
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
		notificarControlador(InterfazVistaAltaPrecio.ALLENAR_DATOS_DESDE_ALTAPRECIO);
		altaPrecioPanel.addListenerRegistrarPrecio(this.controlador);
//		notificarControlador(InterfazVistaAltaPrecio.ALTA_PRECIO);
//		menu.iniciarPanelAltaPrecio(this.controlador);
//		notificarControlador(InterfazVistaAltaPrecio.LISTA_PRECIOS);
//		menu.iniciarPanelListaPrecio(this.controlador);
	}

	@Override
	public void notificarControlador(String evento) {
		Random gen = new Random();
		controlador.actionPerformed(new ActionEvent(this, (Integer) gen.nextInt(), evento));
	}

	@Override
	public HashMap<String, String> obtenerDatos() {
		return altaPrecioPanel.obtenerDatos();
	}
}
