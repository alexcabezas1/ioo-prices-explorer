package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import domain.Persona;
import domain.Producto;
import domain.Sistema;
import domain.Tienda;
import domain.Usuario;

public class Vista extends JFrame{

	private JTextField txtCodigoProducto;
	private JLabel lblCodigoProducto;
	
	private JTextField txtNombre;
	private JLabel lblNombre;
	
	private JTextField txtPrecio;
	private JLabel lblPrecio;
	
	private JTextField txtMarca;
	private JLabel lblMarca;
	
	private JTextField txtTienda;
	private JLabel lblTienda;
	
	private JTextField txtUbicacion;
	private JLabel lblUbicacion;
	
	private JLabel lblResultado;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JButton btnBuscarCodigo;
	private JButton btnBuscarNombre;
	private JButton btnAltaPrecio;
	private JButton btnSalir;
	
	Usuario usr = new Usuario();
	
	private Sistema sistema = new Sistema();
	
	public void Login(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300,300);
		this.setVisible(true);
		
		lblNombre=new JLabel("Nombre de Usuario");
		txtNombre=new JTextField(10);
		
		btnAceptar=new JButton ("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usr.asignarFechaHoraActualizacion(new Timestamp(System.currentTimeMillis()));
				usr.asignarNombreUsuario(txtNombre.getText());
				MenuVentana("Menú");
			}
		});
		
		Container panel=this.getContentPane();
		panel.removeAll();
		panel.setLayout(new GridLayout(7,2,5,5)); //4 Filas, 2 columnas
		
		panel.add (lblNombre);
		panel.add (txtNombre);
		
		panel.add (btnAceptar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void MenuVentana(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300,300);
		this.setVisible(true);
		
		btnBuscarCodigo=new JButton ("Consultar Producto Por Código de Barras");
		btnBuscarNombre=new JButton ("Consultar Producto Por Nombre");
		btnAltaPrecio=new JButton ("Agregar un Precio");
		
		btnBuscarCodigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ObtenerProductoPorCodigoVentana("Buscar Producto por Código de Barras");
			}
		});
		
		btnBuscarNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ObtenerProductoPorNombreVentana("Buscar Producto por Nombre");
			}
		});
		
		btnAltaPrecio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AltaProductoVentana("Alta Producto");
			}
		});
		
		btnSalir=new JButton ("Salir");
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Container panel=this.getContentPane();
		panel.setLayout(new GridLayout(4,2,5,5)); //4 Filas, 2 columnas
		panel.removeAll();
		panel.add (btnBuscarCodigo);
		panel.add (btnBuscarNombre);
		panel.add (btnAltaPrecio);
		panel.add (btnSalir);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		
	public void AltaProductoVentana(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300,300);
		this.setVisible(true);
		
		lblCodigoProducto=new JLabel("Código:");
		txtCodigoProducto=new JTextField(10);
		
		lblNombre=new JLabel("Nombre");
		txtNombre=new JTextField(10);
		
		lblPrecio=new JLabel("Precio");
		txtPrecio=new JTextField(10);

		lblMarca=new JLabel("Marca:");
		txtMarca=new JTextField(10);
		
		lblTienda=new JLabel("Tienda:");
		txtTienda=new JTextField(10);
		
		lblUbicacion=new JLabel("Ubicacion:");
		txtUbicacion=new JTextField(10);
		
		
		btnAceptar=new JButton ("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Producto prd = new Producto();
//				prd.asignarCodigoBarras(txtCodigoProducto.getText());
//				prd.asignarMarca(txtMarca.getText());
//				prd.asignarNombre(txtNombre.getText());
//				Tienda tda = new Tienda();
//				float valor = 0;
//				sistema.altaPrecio(usr, prd, tda, valor);
//				MenuVentana("Menú");
			}
		});
		
		btnCancelar=new JButton ("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuVentana("Menú");
			}
		});
		
		Container panel=this.getContentPane();
		panel.removeAll();
		panel.setLayout(new GridLayout(7,2,5,5)); //4 Filas, 2 columnas
		
		panel.add (lblCodigoProducto);
		panel.add (txtCodigoProducto);
		
		panel.add (lblNombre);
		panel.add (txtNombre);
		
		panel.add (lblPrecio);
		panel.add (txtPrecio);
		
		panel.add (lblMarca);
		panel.add (txtMarca);
		
		panel.add (lblTienda);
		panel.add (txtTienda);
		
		panel.add (lblUbicacion);
		panel.add (txtUbicacion);
	
		panel.add (btnAceptar);
		panel.add (btnCancelar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void ObtenerProductoPorCodigoVentana(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300,300);
		this.setVisible(true);
		
		lblCodigoProducto=new JLabel("Código:");
		txtCodigoProducto=new JTextField(10);
		
		lblNombre=new JLabel("Nombre");
		
		txtNombre=new JTextField(10);
		txtNombre.setEnabled(false);
		
		lblMarca=new JLabel("Marca:");
		
		txtMarca=new JTextField(10);
		txtMarca.setEnabled(false);
		
		lblResultado=new JLabel("");
		lblResultado.setVisible(false);
		
		btnAceptar=new JButton ("Buscar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Producto prd = sistema.buscarProductoPorCodigoBarras(txtCodigoProducto.getText());
//				if(prd != null) {
//					txtMarca.setText(prd.obtenerMarca());
//					txtNombre.setText(prd.obtenerNombre());
//				} else {
//					lblResultado.setVisible(true);
//					lblResultado.setText("No se encontraron resultados");
//					txtMarca.setText("");
//					txtNombre.setText("");
//				}
			}
		});
		
		btnCancelar=new JButton ("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuVentana("Menú");
			}
		});
		
		Container panel=this.getContentPane();
		panel.removeAll();
		panel.setLayout(new GridLayout(4,2,5,5)); //4 Filas, 2 columnas
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new GridLayout(4,2,5,5));
		
		JPanel panelResultado = new JPanel();
		panelBusqueda.setLayout(new GridLayout(2,2,5,5));
		
		JPanel panelDetalle = new JPanel();
		panelDetalle.setLayout(new GridLayout(2,2,5,5));
		
		panelBusqueda.add (lblCodigoProducto);
		panelBusqueda.add (txtCodigoProducto);
		
		panelBusqueda.add (btnAceptar);
		panelBusqueda.add (btnCancelar);
		
		panelResultado.add (new JSeparator());
		
		panelResultado.add (lblResultado);
		
		panelDetalle.add (lblMarca);
		panelDetalle.add (txtMarca);
		
		panelDetalle.add (lblNombre);
		panelDetalle.add (txtNombre);
		
		panel.add(panelBusqueda);
		panel.add(panelResultado);
		panel.add(panelDetalle);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void ObtenerProductoPorNombreVentana(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300,300);
		this.setVisible(true);
		
		lblNombre=new JLabel("Nombre");
		txtNombre=new JTextField(10);
		
		
		lblCodigoProducto=new JLabel("Código:");
		txtCodigoProducto=new JTextField(10);
		txtCodigoProducto.setEnabled(false);
		
		lblMarca=new JLabel("Marca:");
		txtMarca=new JTextField(10);
		txtMarca.setEnabled(false);
		
		lblResultado=new JLabel("");
		lblResultado.setVisible(false);
		
		btnAceptar=new JButton ("Buscar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Producto prd = sistema.buscarProductosPorPalabra(txtNombre.getText());
//				if(prd != null) {
//					txtMarca.setText(prd.obtenerMarca());
//					txtCodigoProducto.setText(prd.obtenerCodigoBarras());
//				} else {
//					lblResultado.setVisible(true);
//					lblResultado.setText("No se encontraron resultados");
//					txtMarca.setText("");
//					txtCodigoProducto.setText("");
//				}
			}
		});
		
		btnCancelar=new JButton ("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuVentana("Menú");
			}
		});
		
		Container panel=this.getContentPane();
		panel.removeAll();
		panel.setLayout(new GridLayout(4,2,5,5)); //4 Filas, 2 columnas
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new GridLayout(4,2,5,5));
		
		JPanel panelResultado = new JPanel();
		panelBusqueda.setLayout(new GridLayout(2,2,5,5));
		
		JPanel panelDetalle = new JPanel();
		panelDetalle.setLayout(new GridLayout(2,2,5,5));
		
		panelBusqueda.add (lblNombre);
		panelBusqueda.add (txtNombre);
		
		panelBusqueda.add (btnAceptar);
		panelBusqueda.add (btnCancelar);
		
		panelResultado.add (new JSeparator());
		
		panelResultado.add (lblResultado);
		
		panelDetalle.add (lblMarca);
		panelDetalle.add (txtMarca);
		
		panelDetalle.add (lblCodigoProducto);
		panelDetalle.add (txtCodigoProducto);
		
		panel.add(panelBusqueda);
		panel.add(panelResultado);
		panel.add(panelDetalle);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
