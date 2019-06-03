package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private Sistema sistema = new Sistema();
		
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
		    	System.out.println("Button1 has been clicked");
			}
		});
		
		btnCancelar=new JButton ("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Container panel=this.getContentPane();
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
	}
	
	public void agregarProducto() {
		Usuario usr = new Usuario();
		Producto prd = new Producto();
		prd.asignarCodigoBarras(txtCodigoProducto.getText());
		prd.asignarMarca(txtMarca.getText());
		prd.asignarNombre(txtNombre.getText());
		Tienda tda = new Tienda();
		float valor = 0;
		sistema.altaPrecio(usr, prd, tda, valor);
		
	}
}
